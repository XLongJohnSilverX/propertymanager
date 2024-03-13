import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
function UnitCard({unit}) {
    return (
        <Card style={{ width: '18rem' }}>
        {/* <Card.Img variant="top" src="holder.js/100px180" /> */}
        <Card.Body>
          <Card.Title>{unit.unitIdentifier}</Card.Title>
          <Card.Text>
          {unit.tenantList.map((tenant) => {
          return <span key={tenant.id}>{tenant.firstName} {tenant.lastName}</span>;
        })}
              
          </Card.Text>
          <Button variant="primary">View</Button>
        </Card.Body>
      </Card>
    )
}
export default UnitCard