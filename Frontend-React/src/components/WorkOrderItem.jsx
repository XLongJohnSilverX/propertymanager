
import Button from 'react-bootstrap/Button';
import { useEffect, useState } from 'react';
import { useNavigate } from "react-router-dom"; 
import Card from "react-bootstrap/Card";

function WorkOrderItem({workOrder}){
    const navigate = useNavigate();
    function navigateToWorkOrder(){
      navigate("/workorder/" + workOrder.id);
    } 
  
    const [unit, setUnit] = useState({
        id : "",
        unitIdentifier: "",
        tenantList: [],
        petList: [],
        workOrderList: []
    })
    useEffect(() => {
        
    })
    return (
        <>
        <Card style={{ width: "18rem" }}>
      {/* <Card.Img variant="top" src="holder.js/100px180" /> */}
      <Card.Body>
        <Card.Title>{workOrder.title} | {workOrder.status}</Card.Title>
        <Card.Text>
          <span>
            {workOrder.description}
          </span>
        </Card.Text>
        <Button variant="info" onClick={navigateToWorkOrder}>Go to Work Order</Button>{' '}
      </Card.Body>
    </Card>
        </>
    )

}
export default WorkOrderItem;