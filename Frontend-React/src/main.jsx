import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import PropertyList from './Pages/PropertyList.jsx';
import PropertyView from './Pages/PropertyView.jsx';
import UnitView from './Pages/UnitView.jsx';
import TenantItem from './components/TenantItem.jsx';
import TenantView from './Pages/TenantView.jsx';
const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
  },
  {
    path: "property",
    element: <PropertyList />,
  },
  {
    path: "property/:id",
    element: <PropertyView />,
  },
 {
  path: "unit/:id",
  element: <UnitView />
 },
 {
  path: "tenant/:id",
  element: <TenantView />
 }
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
     <RouterProvider router={router} />
  </React.StrictMode>,
)
