import Badge from 'react-bootstrap/Badge';
import Accordion from 'react-bootstrap/Accordion';
function workOrderItem({workOrder}){
    return(
        <>
        <Accordion defaultActiveKey="0">
      <Accordion.Item eventKey="0">
        <Accordion.Header>{workOrder.title}<Badge bg="secondary">{workOrder.workOrderStatus}</Badge> </Accordion.Header>
        <Accordion.Body>
           <ul>
        <li>Description: {workOrder.description}</li>
            <li>Date Scheduled: {workOrder.dateScheduled}</li>
            <li>Date Created: {workOrder.dateCreated}</li>

           </ul>
            
        </Accordion.Body>
      </Accordion.Item>
      
    </Accordion>
     

        </>
    )
}
export default workOrderItem;