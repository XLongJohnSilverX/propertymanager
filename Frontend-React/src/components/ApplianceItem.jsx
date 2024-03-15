import ListGroup from "react-bootstrap/ListGroup";
/**
 * Renders the details of an appliance item.
 *
 * @param {Object} appliance - the appliance object containing details
 * @return {JSX.Element} the rendered list of appliance details
 */
function ApplianceItem({ appliance }) {
  return (
    <>
      <ListGroup>
        <ListGroup.Item>{appliance.applianceType}</ListGroup.Item>
        <ListGroup.Item>Make: {appliance.make}</ListGroup.Item>
        <ListGroup.Item>Model: {appliance.model}</ListGroup.Item>
        <ListGroup.Item>S/N: {appliance.serialNumber}</ListGroup.Item>
        <ListGroup.Item>
          Power Type: {appliance.appliancePowerType}
        </ListGroup.Item>
        <ListGroup.Item>
          Other Information: <p>{appliance.otherInformation}</p>
        </ListGroup.Item>
      </ListGroup>
    </>
  );
}
export default ApplianceItem;
