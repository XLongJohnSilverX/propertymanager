import React from 'react';
import NavbarComponent from '../components/NavbarComponent';
import { useState, useEffect } from 'react';
import PropertyCard from '../components/PropertyCard';
function PropertyList(){

    const [propertyList, setPropertyList] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/property/", { mode: "cors" })
        .then((response) => response.json())
      .then((data) => setPropertyList(data))
      

      .catch((error) => console.error(error));
      
    })
    return (
        <>
        <NavbarComponent/>
        <h1>Property</h1>
        {propertyList.map((property) => {
          return <PropertyCard key={property.id} data={property} />;
        })}
        </>
    )
}
export default PropertyList;