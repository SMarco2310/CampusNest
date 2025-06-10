import { ChevronFirst, MoreVertical } from 'lucide-react';
import user from '../assets/user.png';
import campusnest_logo from '../assets/campusnest_logo.png';

export default function Sidebar({ children }) {
  return (
    <aside className="h-screen">
        <nav className="h-full flex flex-col bg-white border-r shadow-sm fixed top-0 left-0 w-64">
            <div className="p-4 pb-2 flex justify-between items-center">
              <img
                src={campusnest_logo}
                alt="CampusNest Logo"
                className="w-22 h-20"
              />
              <button className='p-1.5 rounded-lg bg-gray-50 hover:bg-gray-100'>
                <ChevronFirst/>
              </button>
            </div>
            <ul className="flex-1 px-3">
                {children}
            </ul>
            <div className="border-t flex p-3">
                <img
                    src={user}
                    alt=''
                    className='w-10 h-10'
                />
                <div className={`flex justify-between items-center w-52 ml-3`}>
                    <div className='leading-4'>
                        <h4 className='font-semibold text-black'>Admin</h4>
                        <span className='text-xs text-gray-600'>admin@gmail.com</span>
                    </div>
                    <MoreVertical size={20}/>
                </div>
            </div>
        </nav>
    </aside>
  );
}

export function SidebarItem({ icon, label, active, alert }) {
  return (
    <li className={`relative flex ietms-center py-2 px-3 my-1
    font-medium rounded-md cursor-pointer
    transtion-colors
        ${active
            ? "bg-gradient-to-tr from-indigo-200 to-indigo-100 text-indigo-800"
            : "hover:bg-indigo-50 text-gray-600"
        }
    `}>
      {icon}
      <span className="text-sm">{label}</span>
      {alert && (
        <div className={`absloute right-2 w-2 h-2 rounded bg-indigo-400`}/>
      )}
    </li>
  );
}