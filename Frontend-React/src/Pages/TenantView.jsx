import NavbarComponent from "../components/NavbarComponent";
import { useEffect, useState } from "react";
import {
    BrowserRouter as Router,
    Link,
    Route,
    Routes,
    useParams,
  } from "react-router-dom";
  
function TenantView() {
    const { id } = useParams();
  const [tenant, setTenant] = useState({
    firstName: "",
    lastName: "",
    email: "",
    phoneNumber: "",
    
  })
  useEffect(() => {
    fetch("http://localhost:8080/tenant/" + id + '/', { mode: "cors" })
    .then((response) => response.json())
  .then((data) => setTenant(data))
  

  .catch((error) => console.error(error));
 
})
        return (
            <>
            <NavbarComponent/>
                <h1>Tenant Page</h1>;
                <p>{tenant.firstName} {tenant.lastName} {tenant.email} {tenant.phoneNumber}</p>
                <p>
                    TODO: Add conversations here!
                </p>
            </>
        )
    
    }
    
    export default TenantView;