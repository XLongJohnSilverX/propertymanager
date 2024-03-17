import Accordion from 'react-bootstrap/Accordion';
import Button from 'react-bootstrap/Button';;
function WorkOrderItem({workOrder}){
    return (
        <>
        <Accordion.Item >
        <Accordion.Header>{workOrder.title} | {workOrder.workOrderStatus}</Accordion.Header>
        <Accordion.Body>
         {workOrder.description}
         <Button variant="info">Go to Work Order</Button>{' '}
        </Accordion.Body>
      </Accordion.Item>
        </>
    )

}
export default WorkOrderItem;