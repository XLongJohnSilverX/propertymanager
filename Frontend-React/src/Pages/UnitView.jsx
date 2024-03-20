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
function UnitView() {
  const { id } = useParams();
  const [unit, setUnit] = useState({
    id: "",
    unitIdentifier: "",
    tenantList: [],
    petList: [],
    workOrderList: [],
    unitDescription: "",
    numberOfBeds: "",
    numberOfBaths: "",
    squareFeet: "",
    appliances: [{}],
    monthlyRent: "",
    vacant: "",
  });
  useEffect(() => {
    fetch("http://localhost:8080/unit/" + id + "/", { mode: "cors" })
      .then((response) => response.json())
      .then((data) => setUnit(data))

      .catch((error) => console.error(error));
  });

  return (
    <>
      <NavbarComponent />
      <div className="d-inline-flex justify-content-between flex-row w-100 p-3">
        <h1>Unit: {unit.unitIdentifier}</h1>
        <Button variant="primary">Edit</Button>
      </div>

      <div>
        <Accordion defaultActiveKey={[""]} alwaysOpen>
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
          <Accordion.Item eventKey="4" alwaysOpen>
            <Accordion.Header>Rent Payment and Information</Accordion.Header>
            <Accordion.Body>
              <h1>TODO: Add RENT INFO HERE</h1>
            </Accordion.Body>
          </Accordion.Item>
          <Accordion.Item eventKey="2" alwaysOpen>
            <Accordion.Header>Work Orders</Accordion.Header>
            <Accordion.Body>
              {unit.workOrderList.map((workOrder) => {
                return (
                  <WorkOrderItem key={workOrder.id} workOrder={workOrder} />
                );
              })}
            </Accordion.Body>
          </Accordion.Item>
          <Accordion.Item eventKey="1" alwaysOpen>
            <Accordion.Header>Tenants</Accordion.Header>
            <Accordion.Body>
              {unit.tenantList.map((tenant) => {
                return <TenantItem key={tenant.id} tenant={tenant} />;
              })}
            </Accordion.Body>
          </Accordion.Item>

          <Accordion.Item eventKey="3" alwaysOpen>
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
