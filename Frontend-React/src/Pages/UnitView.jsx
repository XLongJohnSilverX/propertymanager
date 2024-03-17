import NavbarComponent from "../components/NavbarComponent";
import { useEffect, useState } from "react";
import {
    BrowserRouter as Router,
    Link,
    Route,
    Routes,
    useParams,
  } from "react-router-dom";
  import Accordion from 'react-bootstrap/Accordion';
import TenantItem from "../components/TenantItem";
function UnitView(){

    const { id } = useParams();
    const [unit, setUnit] = useState({
        id : "",
        unitIdentifier: "",
        tenantList: [],
        petList: []
    })
    useEffect(() => {
        fetch("http://localhost:8080/unit/" + id + '/', { mode: "cors" })
        .then((response) => response.json())
      .then((data) => setUnit(data))
      

      .catch((error) => console.error(error));
     
    })

    return (
        <>
        <NavbarComponent/>
        <h1>Unit: {unit.unitIdentifier}</h1>
        <div>
        <Accordion defaultActiveKey={['0']} alwaysOpen>
      <Accordion.Item eventKey="0">
        <Accordion.Header>Unit Information</Accordion.Header>
        <Accordion.Body>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
          eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
          minim veniam, quis nostrud exercitation ullamco laboris nisi ut
          aliquip ex ea commodo consequat. Duis aute irure dolor in
          reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
          pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
          culpa qui officia deserunt mollit anim id est laborum.
        </Accordion.Body>
      </Accordion.Item>
      <Accordion.Item eventKey="1">
        <Accordion.Header>Tenants</Accordion.Header>
        <Accordion.Body>
        {unit.tenantList.map((tenant) => {
          return <TenantItem key={tenant.id} tenant={tenant} />;
        })}
        </Accordion.Body>
      </Accordion.Item>
      <Accordion.Item eventKey="2">
        <Accordion.Header>Pets</Accordion.Header>
        <Accordion.Body>
         PETS
        </Accordion.Body>
      </Accordion.Item>
    </Accordion>
        </div>
        </>
    )
}
export default UnitView;