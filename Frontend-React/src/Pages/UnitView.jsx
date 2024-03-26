import NavbarComponent from "../components/NavbarComponent";
import { useEffect, useState } from "react";
import {
  BrowserRouter as Router,
  Link,
  Route,
  Routes,
  useParams,
} from "react-router-dom";
import Accordion from "react-bootstrap/Accordion";
import TenantItem from "../components/TenantItem";
import WorkOrderItem from "../components/WorkOrderItem";
import Button from "react-bootstrap/esm/Button";
import PetItem from "../components/PetItem";
import ListGroup from "react-bootstrap/ListGroup";
import ApplianceItem from "../components/ApplianceItem";
import RentItem from "../components/RentItem";
import UnitInfoItem from "../components/UnitInfoItem";

import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';

function UnitView() {
  const { id } = useParams();
  const [lease, setLease] = useState([{
    id: '',
    rentList:[{}],
  }]);
  const [workOrderList, setWorkOrderList] = useState([{}]);
  const [unit, setUnit] = useState({
    id: "",
    unitIdentifier: "",
    tenantList: [],
    petList: [],
    
    unitDescription: "",
    numberOfBeds: "",
    numberOfBaths: "",
    squareFeet: "",
    appliances: [{}],
    monthlyRent: "",
    vacant: "",
  });
  useEffect(() => {
    console.log("Calling server");
    fetch("http://localhost:8080/unit/" + id + "/", { mode: "cors" })
      .then((response) => response.json())
      .then((data) => setUnit(data))

      .catch((error) => console.error(error));

      fetch("http://localhost:8080/workorder/byunit/" + id + "/", { mode: "cors" })
      .then((response) => response.json())
      .then((data) => setWorkOrderList(data))
      .catch((error) => console.error(error));

    fetch("http://localhost:8080/lease/byunit/" + id + "/", { mode: "cors" })
    .then(console.log("Calling server"))
    .then((response) => response.json())
    .then((data) => setLease(data))
   
    .catch((error) => console.error(error));
  }, []);

  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  function editSuccess() {
    alert("Unit was edited successfully!");
  }

  function saveChanges() {
    
     let foo = {...unit};
    foo.unitIdentifier = document.getElementById("editForm.unitIdentifier").value;
    foo.unitDescription = document.getElementById("editForm.unitDescription").value;
    foo.numberOfBeds = document.getElementById("editForm.numberOfBeds").value;
    foo.numberOfBaths = document.getElementById("editForm.numberOfBaths").value;
    foo.squareFeet = document.getElementById("editForm.squareFeet").value;
     
    
    
    handleClose();
    fetch("http://localhost:8080/unit/" + id + "/", {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(foo),
    })
      .then((response) => response.json())
      .then((data) => setUnit(data))
      .catch((error) => console.error(error))
      .then(editSuccess);
  }

  return (
    <>
      <NavbarComponent />
      <div className="d-inline-flex justify-content-between flex-row w-100 p-3">
        <h1>Unit: {unit.unitIdentifier}</h1>
        <Button variant="primary" onClick={handleShow}>
        Edit Unit
      </Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Edit Unit</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3" controlId="editForm.unitIdentifier">
              <Form.Label>Unit Identifier</Form.Label>
              <Form.Control
                type="text"
                placeholder="I. E. 101"
                defaultValue={unit.unitIdentifier}
                autoFocus
              />
            </Form.Group>
            <Form.Group
              className="mb-3"
              controlId="editForm.unitDescription"
            >
              <Form.Label>Unit Description</Form.Label>
              <Form.Control as="textarea" rows={3} defaultValue={unit.unitDescription}/>
            </Form.Group>
            <Form.Group
              className="mb-3"
              controlId="editForm.numberOfBeds"
            >
              <Form.Label>Number of Beds</Form.Label>
              <Form.Control
                type="text"
                
                defaultValue={unit.numberOfBeds}
                autoFocus
              />
            </Form.Group>
            <Form.Group
              className="mb-3"
              controlId="editForm.numberOfBaths"
            >
              <Form.Label>Number of Baths</Form.Label>
              <Form.Control
                type="text"
                
                defaultValue={unit.numberOfBaths}
                autoFocus
              />
            </Form.Group>
            <Form.Group
              className="mb-3"
              controlId="editForm.squareFeet"
            >
              <Form.Label>squareFeet</Form.Label>
              <Form.Control
                type="text"
                
                defaultValue={unit.squareFeet }
                autoFocus
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={saveChanges}>
            Save Changes
          </Button>
        </Modal.Footer>
      </Modal>
      </div>

      <div>
        <Accordion defaultActiveKey={[""]} >
        <Accordion.Item eventKey="0">
          <UnitInfoItem unit={unit} />
          </Accordion.Item>
          <Accordion.Item eventKey="4" >
            <Accordion.Header>Rent Payment and Information</Accordion.Header>
            <Accordion.Body>
              {/* TODO: make this work when there has been multiple leases and only show current lease
              may need to add field to lease.
              */}
              {lease[0].rentList.map((rent) => {
           return <RentItem key={rent.id} rent={rent} />;
              })}
            </Accordion.Body>
          </Accordion.Item>
          
          <Accordion.Item eventKey="2" >
            <Accordion.Header>Work Orders</Accordion.Header>
            <Accordion.Body>
              {workOrderList.map((workOrder) => {
                return <WorkOrderItem key={workOrder.id} workOrder={workOrder} />
              
              })}
            </Accordion.Body>
          </Accordion.Item>
          <Accordion.Item eventKey="1" >
            <Accordion.Header>Tenants</Accordion.Header>
            <Accordion.Body>
              {unit.tenantList.map((tenant) => {
                return <TenantItem key={tenant.id} tenant={tenant} />;
              })}
            </Accordion.Body>
          </Accordion.Item>

          <Accordion.Item eventKey="3" >
            <Accordion.Header>Pets</Accordion.Header>
            <Accordion.Body>
              {unit.petList.map((pet) => {
                return <PetItem key={pet.id} pet={pet} />;
              })}
            </Accordion.Body>
          </Accordion.Item>
        </Accordion>
      </div>
    </>
  );
}
export default UnitView;
