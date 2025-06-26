import './App.css';
import {BrowserRouter,Routes,Route} from "react-router-dom";
import Login from './pages/Login';
import Register from './pages/Register';
import Dashboard from './pages/Dashboard';
import Hostels from './pages/Hostels';
import HostelDetails from './pages/HostelDetails';
import Rooms from './pages/Rooms';
import RoomDetails from './pages/RoomDetails';
import Home from './pages/Home';
import NavBar from './components/navBar';


function App() {
  return (
      // <BrowserRouter>
      //   <Routes>
      //     <Route path="/login" element={<Login />} />
      //     <Route path="/register" element={<Register />} />
      //     <Route path="/dashboard" element={<Dashboard />} />
      //     <Route path="/hostels" element={<Hostels />} />
      //     <Route path="/hostels/:id" element={<HostelDetails />} />
      //     <Route path="/rooms" element={<Rooms />} />
      //     <Route path="/rooms/:id" element={<RoomDetails />} />
      //     <Route path="/" element={<Home />} />
      //   </Routes>
      // </BrowserRouter>

      <NavBar/>

  );
}

export default App;
