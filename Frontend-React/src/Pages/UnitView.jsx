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
import ApplianceItem from "../components/ApplianceItem";
import ListGroup from 'react-bootstrap/ListGroup';
import PetItem from "../components/PetItem";
import WorkOrderItem from "../components/WorkOrderItem";
function UnitView(){

    const { id } = useParams();
    const [unit, setUnit] = useState({
        id : "",
        unitIdentifier: "",
        tenantList: [],
        petList: [],
        appliances: [],
        isVacant: "",
        allowsPets: "",
        numberOfBeds: "",
        numberOfBaths: "",
        squareFeet: "",
        monthlyRent: "",
        securityDeposit: "",
        unitDescription: "",
        workOrderList: []
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
        <Accordion defaultActiveKey={['1']} alwaysOpen>
      <Accordion.Item eventKey="0">
        <Accordion.Header>Unit Information</Accordion.Header>
        <Accordion.Body>
        <ListGroup>
      <ListGroup.Item>is Vacant: {unit.isVacant}</ListGroup.Item>
      <ListGroup.Item>squareFeet: {unit.squareFeet}</ListGroup.Item>
      <ListGroup.Item>Bedrooms: {unit.numberOfBeds}</ListGroup.Item>
      <ListGroup.Item>Baths: {unit.numberOfBaths}</ListGroup.Item>
      <ListGroup.Item>Monthly Rent: ${unit.monthlyRent}</ListGroup.Item>
      <ListGroup.Item>Allows pets: {unit.allowsPets}</ListGroup.Item>
      <ListGroup.Item>securityDeposit: ${unit.securityDeposit}</ListGroup.Item>
      <ListGroup.Item>Description: {unit.unitDescription}</ListGroup.Item>
    </ListGroup>
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
        <Accordion.Header>Work Orders</Accordion.Header>
        <Accordion.Body>
        {unit.workOrderList.map((workOrder) => {
          return <WorkOrderItem key={workOrder.id} workOrder={workOrder} /> ;
        })}
        </Accordion.Body>
      </Accordion.Item>
      <Accordion.Item eventKey="3">
        <Accordion.Header>Pets</Accordion.Header>
        <Accordion.Body>
        {unit.petList.map((pet) => {
          return <PetItem key={pet.id} pet={pet} />;
        })}
        </Accordion.Body>
      </Accordion.Item>
      <Accordion.Item eventKey="4">
        <Accordion.Header>Appliances</Accordion.Header>
        <Accordion.Body>
        {unit.appliances.map((appliance) => {
          return <ApplianceItem key={appliance.id} appliance={appliance} /> ;
        })}
        </Accordion.Body>
      </Accordion.Item>
    </Accordion>
        </div>
        </>
    )
}
export default UnitView;