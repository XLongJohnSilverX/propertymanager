import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { useNavigate } from "react-router-dom";
/**
 * Generates a property card component with the given data.
 *
 * @param {object} data - The data object containing information about the property
 * @return {JSX.Element} The property card component
 */
// TODO: Add pictures to card
function PropertyCard({data}) {
  
  const navigate = useNavigate();

  function navigateToProperty() {
    navigate("/property/" + data.id);
  }

  
  return (
    <Card style={{ width: '18rem' }}>
      {/* <Card.Img variant="top" src="holder.js/100px180" /> */}
      <Card.Body>
        <Card.Title>{data.name}</Card.Title>
        <Card.Text>
         <span>{data.address.streetAddress},{data.address.city}</span>     
        </Card.Text>
        <Button variant="primary" onClick={navigateToProperty}>View Property</Button>
      </Card.Body>
    </Card>
  );
}

export default PropertyCard;