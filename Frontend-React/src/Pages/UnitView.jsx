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

  return (
    <>
      <NavbarComponent />
      <div className="d-inline-flex justify-content-between flex-row w-100 p-3">
        <h1>Unit: {unit.unitIdentifier}</h1>
        <Button variant="primary">Edit</Button>
      </div>

      <div>
        <Accordion defaultActiveKey={[""]} >
          <Accordion.Item eventKey="0">
            <Accordion.Header>Unit Information</Accordion.Header>
            <Accordion.Body>
              {unit.unitDescription}
              <ListGroup>
                <ListGroup.Item>
                  {unit.numberOfBeds} bed(s), {unit.numberOfBaths} bath(s) |{" "}
                  {unit.squareFeet} sq. ft.
                </ListGroup.Item>
                <ListGroup.Item>
                  <Accordion>
                    {unit.appliances.map((appliance) => {
                      return (
                        <ApplianceItem
                          key={appliance.id}
                          appliance={appliance}
                        />
                      );
                    })}
                  </Accordion>
                </ListGroup.Item>
              </ListGroup>
            </Accordion.Body>
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
