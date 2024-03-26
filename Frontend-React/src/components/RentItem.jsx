//TODO: add date formating
import Card from "react-bootstrap/Card";
import Badge from 'react-bootstrap/Badge';
import Button from "react-bootstrap/Button";



function RentItem({ rent }) {
  const dueDate = new Date(rent.dueDate);
  var monthName;
  var month = dueDate.getMonth();
  
console.log("due", month);
  switch (month) {
    case 1:
      monthName = "January";
      break;
    case 2:
      monthName = "February";
      break;
    case 3:
      monthName = "March";
      break;
    case 4:
      monthName = "April";
      break;
    case 5:
      monthName = "May";
      break;
    case 6:
      monthName = "June";
      break;
    case 7:
      monthName = "July";
      break;
    case 8:
      monthName = "August";
      break;
    case 9:
      monthName = "September";
      break;
    case 10:
      monthName = "October";
      break;
    case 11:
      monthName = "November";
      break;
    case 12:
      monthName = "December";
      break;
    default:
      monthName = "ERROR";

  }
  console.log("month", month, monthName);

  if (rent.paid) {
    return (
      <>
        <Card style={{ width: "100%" }}>
      {/* <Card.Img variant="top" src="holder.js/100px180" /> */}
      <Card.Body>
        <Card.Title>{monthName} <Badge pill bg="success">
        Paid
      </Badge></Card.Title>
        <Card.Text>
          <span> 
            Paid : ${rent.rentAmount} on {dueDate.toDateString()}
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
            Paid : ${rent.rentAmount} on {dueDate.toDateString()}
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
        <Card.Title>{monthName} <Badge pill bg="warning" text="dark">
        Not Paid
      </Badge></Card.Title>
        <Card.Text>
          <span> 
            ${rent.rentAmount} due on {dueDate.toDateString()}
          </span>
        </Card.Text>
        
      </Card.Body>
    </Card>
      </>
    );
  }
}
export default RentItem;
