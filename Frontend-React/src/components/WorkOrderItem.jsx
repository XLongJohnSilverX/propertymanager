import Accordion from 'react-bootstrap/Accordion';
import Button from 'react-bootstrap/Button';
import { useEffect, useState } from 'react';
function WorkOrderItem({workOrder}){
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
         <Button variant="info">Go to Work Order</Button>{' '}
        </Accordion.Body>
      </Accordion.Item>
        </>
    )

}
export default WorkOrderItem;