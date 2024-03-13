import React from 'react';
import NavbarComponent from '../components/NavbarComponent';
import { useState, useEffect } from 'react';
import PropertyCard from '../components/PropertyCard';

/**
+ * The PropertyList component that renders a list of properties fetched from the server.
+ * It fetches a list of properties from a local server using the fetch API when the component is rendered. 
The fetched data is stored in the propertyList state variable using useState hook. 
component then renders a NavbarComponent followed by a list of PropertyCard components, 
each representing a property from the fetched data.
+ * @param {void} 
+ * @return {JSX} The JSX for rendering the property list component
+ */

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