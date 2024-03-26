import Accordion from "react-bootstrap/Accordion";
import ListGroup from "react-bootstrap/ListGroup";
import ApplianceItem from "./ApplianceItem";
import Button from "react-bootstrap/esm/Button";
function UnitInfoItem({unit}){
return (
<>

<Accordion.Header>Unit Information </Accordion.Header>
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
            </Accordion.Body></>
)
           
}
export default UnitInfoItem;