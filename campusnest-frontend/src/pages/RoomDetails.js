// import React from "react";
// import { useEffect, useState } from "react";
// import { useParams } from "react-router-dom";
// import API from "../api/axios";
//
// // const { id } = useParams(); // assuming /rooms/:id
// // const [room, setRoom] = useState(null);
// //
// // useEffect(() => {
// //     API.get(`/rooms/${id}`) // Adjust endpoint if needed
// //         .then(res => setRoom(res.data))
// //         .catch(err => console.error(err));
// // }, [id]);
//
// const handleBook = () => {
//     API.post(`/bookings`, { roomId: room.id })
//         .then(() => alert("Room booked!"))
//         .catch(err => alert("Failed to book room"));
// };
//
// function RoomDetails(props) {
//     return (
//         <div className="max-w-4xl mx-auto p-4">
//             {/* Room Images */}
//             <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mb-6">
//                 {props.images.map((url, index) => (
//                     <img key={index} src={url} alt={`Room ${index + 1}`} className="rounded-lg shadow-md h-64 object-cover" />
//                 ))}
//             </div>
//
//             {/* Room Info */}
//             <div className="bg-white rounded-lg shadow-md p-6">
//                 <h2 className="text-2xl font-bold mb-2">Room {room.roomNumber}</h2>
//                 <p className="text-gray-700 mb-1"><strong>Price per bed:</strong> GH₵ {room.pricePerBed}</p>
//                 <p className="text-gray-700 mb-1"><strong>Number of beds:</strong> {room.numberOfBeds}</p>
//
//                 <div className="mt-4">
//                     <h4 className="text-lg font-semibold mb-2">Commodities:</h4>
//                     <ul className="list-disc list-inside text-gray-700">
//                         {props.commodities.map((item, index) => (
//                             <li key={index}>{item}</li>
//                         ))}
//                     </ul>
//                 </div>
//
//                 <button
//                     onClick={handleBook}
//                     className="mt-6 bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition"
//                 >
//                     Book Room
//                 </button>
//             </div>
//         </div>
//     );
// }
//
// export default RoomDetails;