
import NavbarComponent from "../components/NavbarComponent";
import {
    BrowserRouter as Router,
    Link,
    Route,
    Routes,
    useParams,
  } from "react-router-dom";
import { useState, useEffect } from 'react';
import UnitCard from "../components/UnitCard";
/**
 * Fetches property data based on the given ID and renders the property view with name,
 * address, and unit list.
 *
 * @param {void} 
 * @return {JSX} The property view component
 */
function PropertyView(){
    const { id } = useParams();
    const [property, setProperty] = useState({
        name: "",
        address: {
            streetAddress: "",
            city: "",
            state: "",
            zipCode: ""
        },
        unitList: []
    });
    useEffect(() => {
        fetch("http://localhost:8080/property/" + id + '/', { mode: "cors" })
        .then((response) => response.json())
      .then((data) => setProperty(data))
      

      .catch((error) => console.error(error));
     
    })

 
    return(
        <>
        <NavbarComponent/>
        <h1>
           {property.name}
        </h1>
        <h2>
          {property.address.streetAddress}, {property.address.city}, {property.address.state}     {property.address.zipCode}     
        </h2>
        <h3>
        Maintenance Limit $ {property.maintenanceLimit}
        </h3>
        {property.unitList.map((unit) => {
          return <UnitCard key={unit.id} unit={unit} />;
        })}
        </>
    );


}
export default PropertyView;