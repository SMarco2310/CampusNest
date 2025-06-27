// import React from "react";
// import { useEffect, useState } from "react";
// import API from "../components/API";
//
//
//
// function HostelDetails(){
//
//     const { id } = useParams(); // /hostels/:id
//     const [hostel, setHostel] = useState(null);
//
//     useEffect(() => {
//         API.get(`/hostels/${id}`)
//             .then(res => setHostel(res.data))
//             .catch(err => console.error(err));
//     }, [id]);
//
//     if (!hostel) return <div className="text-center p-10">Loading hostel details...</div>;
//
// // Calculate price range
//     const prices = hostel.rooms.map(r => r.pricePerBed);
//     const minPrice = Math.min(...prices);
//     const maxPrice = Math.max(...prices);
//
//     return (
//         <div className="max-w-5xl mx-auto p-4">
//             {/* Images */}
//             <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mb-6">
//                 {hostel.images.map((url, idx) => (
//                     <img key={idx} src={url} alt={`Hostel Image ${idx + 1}`} className="rounded-lg shadow-md h-64 object-cover" />
//                 ))}
//             </div>
//
//             {/* Hostel Info */}
//             <div className="bg-white rounded-lg shadow-md p-6 mb-6">
//                 <h2 className="text-3xl font-bold mb-2">{hostel.name}</h2>
//                 <p className="text-gray-600 mb-2"><strong>Location:</strong> {hostel.location}</p>
//                 <p className="text-gray-600 mb-2"><strong>Number of Rooms:</strong> {hostel.rooms.length}</p>
//
//                 <div className="mt-4">
//                     <h4 className="text-lg font-semibold mb-2">Price Range:</h4>
//                     <table className="w-full table-auto border border-gray-300">
//                         <thead>
//                         <tr className="bg-gray-100">
//                             <th className="border px-4 py-2 text-left">Minimum Price</th>
//                             <th className="border px-4 py-2 text-left">Maximum Price</th>
//                         </tr>
//                         </thead>
//                         <tbody>
//                         <tr>
//                             <td className="border px-4 py-2">GH₵ {minPrice}</td>
//                             <td className="border px-4 py-2">GH₵ {maxPrice}</td>
//                         </tr>
//                         </tbody>
//                     </table>
//                 </div>
//             </div>
//
//             {/* Manager Info */}
//             <div className="bg-white rounded-lg shadow-md p-6 mb-6">
//                 <h4 className="text-xl font-semibold mb-2">Hostel Manager</h4>
//                 <p className="text-gray-700"><strong>Name:</strong> {hostel.manager.name}</p>
//                 <p className="text-gray-700"><strong>Email:</strong> {hostel.manager.email}</p>
//                 <p className="text-gray-700"><strong>Contact:</strong> {hostel.manager.contact}</p>
//             </div>
//
//             {/* Description */}
//             <div className="bg-white rounded-lg shadow-md p-6">
//                 <h4 className="text-xl font-semibold mb-2">Description</h4>
//                 <p className="text-gray-700">{hostel.description}</p>
//             </div>
//         </div>
//     );
//
// }