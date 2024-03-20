import Accordion from 'react-bootstrap/Accordion';
import Button from 'react-bootstrap/Button';
import { useEffect, useState } from 'react';
import { useNavigate } from "react-router-dom"; 

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
        fetch("http://localhost:8080/unit/" + workOrder.unitId + '/', { mode: "cors" })
        .then((response) => response.json())
        .then((data) => setUnit(data))
    })
    return (
        <>
        <Accordion.Item >
        <Accordion.Header>{unit.unitIdentifier} | {workOrder.title} | {workOrder.workOrderStatus}</Accordion.Header>
        <Accordion.Body>
            
         {workOrder.description}
         <Button variant="info" onClick={navigateToWorkOrder}>Go to Work Order</Button>{' '}
        </Accordion.Body>
      </Accordion.Item>
        </>
    )

}
export default WorkOrderItem;