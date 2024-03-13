import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import { useNavigate } from "react-router-dom";
/**
 * Generates a property card component with the given data.
 *This code snippet defines a PropertyCard component in JavaScript that generates a card displaying property information.
It takes a data object as input, which contains details about the property, 
and renders a card with the property's name, address, and a button to view the property. 
When the button is clicked, it navigates to the property details page 
using the React Router's useNavigate hook
 * @param {object} data - The data object containing information about the property
 * @return {JSX.Element} The property card component
 */
// TODO: Add pictures to card
function PropertyCard({ data }) {
  const navigate = useNavigate();

  function navigateToProperty() {
    navigate("/property/" + data.id);
  }

  return (
    <Card style={{ width: "18rem" }}>
      {/* <Card.Img variant="top" src="holder.js/100px180" /> */}
      <Card.Body>
        <Card.Title>{data.name}</Card.Title>
        <Card.Text>
          <span>
            {data.address.streetAddress},{data.address.city}
          </span>
        </Card.Text>
        <Button variant="primary" onClick={navigateToProperty}>
          View Property
        </Button>
      </Card.Body>
    </Card>
  );
}

export default PropertyCard;
