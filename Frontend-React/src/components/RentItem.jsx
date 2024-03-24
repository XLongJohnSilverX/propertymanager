//TODO: add date formating
import Card from "react-bootstrap/Card";
import Badge from 'react-bootstrap/Badge';
import Button from "react-bootstrap/Button";
function RentItem({ rent }) {
  if (rent.paid) {
    return (
      <>
        <Card style={{ width: "100%" }}>
      {/* <Card.Img variant="top" src="holder.js/100px180" /> */}
      <Card.Body>
        <Card.Title>{rent.dueDate} <Badge pill bg="success">
        Paid
      </Badge></Card.Title>
        <Card.Text>
          <span> 
            Paid : ${rent.rentAmount} on {rent.paymentDate}
          </span>
        </Card.Text>
        <Button variant="primary" >
          View Payment
        </Button>
      </Card.Body>
    </Card>
      </>
    );
  }
  if (rent.overdue && !rent.paid) {
    return (
      <>
        <Card style={{ width: "100%" }}>
      {/* <Card.Img variant="top" src="holder.js/100px180" /> */}
      <Card.Body>
        <Card.Title>{rent.dueDate} <Badge pill bg="danger">
        Overdue
      </Badge></Card.Title>
        <Card.Text>
          <span> 
            Paid : ${rent.rentAmount} on {rent.paymentDate}
          </span>
        </Card.Text>
        
      </Card.Body>
    </Card>
      </>
    );
  }
  else {
    return (
      <>
       <Card style={{ width: "100%" }}>
      {/* <Card.Img variant="top" src="holder.js/100px180" /> */}
      <Card.Body>
        <Card.Title>{rent.dueDate} <Badge pill bg="warning" text="dark">
        Not Paid
      </Badge></Card.Title>
        <Card.Text>
          <span> 
            ${rent.rentAmount} due on {rent.dueDate}
          </span>
        </Card.Text>
        
      </Card.Body>
    </Card>
      </>
    );
  }
}
export default RentItem;
