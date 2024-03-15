import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { useNavigate } from "react-router-dom"; 
/**
 * Renders a card component displaying information about a specific unit.
 *This code defines a React component called UnitCard, which takes a unit object as a parameter. 
 It renders a card component displaying information about the unit, 
 including the unit identifier and a list of tenants. 
 It also includes a button for viewing more details.
 * @param {object} unit - The unit object containing unit details and a list of tenants
 * @return {JSX.Element} A Card component displaying unit and tenant information
 */
function UnitCard({unit}) {
  const navigate = useNavigate();
  function navigateToUnit(){
    navigate("/unit/" + unit.id);
  }  
  return (
        <Card style={{ width: '18rem' }}>
        {/* <Card.Img variant="top" src="holder.js/100px180" /> */}
        <Card.Body>
          <Card.Title>{unit.unitIdentifier}</Card.Title>
          <Card.Text>
          {unit.tenantList.map((tenant) => {
          return <span key={tenant.id}>{tenant.firstName} {tenant.lastName}</span>;
        })}
              
          </Card.Text>
          <Button variant="primary" onClick={navigateToUnit}>View</Button>
        </Card.Body>
      </Card>
    )
}
export default UnitCard