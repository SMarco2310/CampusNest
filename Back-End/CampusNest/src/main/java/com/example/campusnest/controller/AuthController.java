package com.example.campusnest.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final FirebaseAuth firebaseAuth;
    private final UserRepository userRepository;

    public AuthController(FirebaseAuth firebaseAuth, UserRepository userRepository) {
        this.firebaseAuth = firebaseAuth;
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        try {
            UserRecord.CreateRequest createRequest = new UserRecord.CreateRequest()
                    .setEmail(request.getEmail())
                    .setPassword(request.getPassword())
                    .setDisplayName(request.getDisplayName());

            UserRecord userRecord = firebaseAuth.createUser(createRequest);

            // Save additional user info in your DB
            AppUser user = new AppUser();
            user.setUid(userRecord.getUid());
            user.setEmail(request.getEmail());
            user.setName(request.getDisplayName());
            userRepository.save(user);

            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
        } catch (FirebaseAuthException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating user: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // Firebase Admin SDK does not handle email/password login directly.
        // Usually, client SDK (e.g., Android/iOS/Web) authenticates and sends token.
        // Backend verifies ID token here:
        try {
            String idToken = request.getIdToken(); // ID token from client
            FirebaseToken decodedToken = firebaseAuth.verifyIdToken(idToken);
            String uid = decodedToken.getUid();

            // Fetch user info from DB if needed
            AppUser user = userRepository.findByUid(uid);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found in database");
            }

            return ResponseEntity.ok(user);
        } catch (FirebaseAuthException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid ID token: " + e.getMessage());
        }
    }
}
