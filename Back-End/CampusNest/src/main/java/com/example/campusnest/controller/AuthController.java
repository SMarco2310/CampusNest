package com.example.campusnest.controller;

import com.example.campusnest.dto.LoginRequest;
import com.example.campusnest.dto.SignupRequest;
import com.example.campusnest.entity.User;
import com.example.campusnest.repository.UserRepository;
import com.example.campusnest.utils.Role;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
                    .setDisplayName(request.getDisplayName())
                    .setPhoneNumber(request.getPhoneNumber());

            UserRecord userRecord = firebaseAuth.createUser(createRequest);

            User user = new User();
            user.setEmail(request.getEmail());
            user.setName(request.getDisplayName());
            user.setPassword(request.getPassword());
            user.setPhoneNumber(request.getPhoneNumber());
            user.setRole(Role.valueOf(request.getRole()));
            userRepository.save(user);

            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
        } catch (FirebaseAuthException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating user: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            String idToken = request.getIdToken();
            FirebaseToken decodedToken = firebaseAuth.verifyIdToken(idToken);
            String uid = decodedToken.getUid();

            Optional<User> user = userRepository.findById(Long.valueOf(uid));
            if (user.isPresent()) {
                return ResponseEntity.ok(user.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found in database");
            }
        } catch (FirebaseAuthException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid ID token: " + e.getMessage());
        }
    }
}
