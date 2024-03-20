import ListGroup from 'react-bootstrap/ListGroup';
import Accordion from 'react-bootstrap/Accordion';
function ApplianceItem({appliance}){
    return (
       <>
        <Accordion.Item >
        <Accordion.Header>{appliance.applianceType}</Accordion.Header>
        <Accordion.Body>
        <ListGroup>
      <ListGroup.Item>{appliance.make}</ListGroup.Item>
      <ListGroup.Item>{appliance.model}</ListGroup.Item>
      <ListGroup.Item>{appliance.serialNumber}</ListGroup.Item>
      <ListGroup.Item>{appliance.appliancePowerType}</ListGroup.Item>
      <ListGroup.Item>{appliance.otherInformation}</ListGroup.Item>
    </ListGroup>   
         
        </Accordion.Body>
      </Accordion.Item>
       </>
    )
}
export default ApplianceItem;