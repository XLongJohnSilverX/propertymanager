import NavbarComponent from "../components/NavbarComponent";
import WorkOrderItem from "../components/WorkOrderItem";
import { useEffect, useState } from "react";
import Accordion from 'react-bootstrap/Accordion';
function WorkOrderList(){
    const [workOrderList, setWorkOrderList] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/workorder/", { mode: "cors" })
        .then((response) => response.json())
        .then((data) => setWorkOrderList(data))
    })
    
    return (
        <>
        <NavbarComponent/>
        <h1>Work Orders</h1>
        <Accordion defaultActiveKey={['0']} >
      
        {workOrderList.map((workOrder) => {
          return <WorkOrderItem key={workOrder.id} workOrder={workOrder} />;
        })}
      
    </Accordion>
        
        </>
    )
}
export default WorkOrderList;