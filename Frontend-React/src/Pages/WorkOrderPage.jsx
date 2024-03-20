import { useState, useEffect } from "react";
import NavbarComponent from "../components/NavbarComponent";
import {
    BrowserRouter as Router,
    Link,
    Route,
    Routes,
    useParams,
    useNavigate
  } from "react-router-dom";

/**
 * Fetches a work order based on the provided ID and displays its details on the page.
 *
 * @param {void} None
 * @return {JSX.Element} The Work Order Page component
 */
function WorkOrderPage(){
   
    const { id } = useParams();
    const [workOrder, setWorkOrder] = useState({
        title: "",
        description: "",
        workOrderStatus: "",
        unitId: ""
    });

    /**
     * Navigates to the work order page.
     *
     */
   

    useEffect(() => {
        fetch("http://localhost:8080/workorder/" + id + '/', { mode: "cors" })
        .then((response) => response.json())
      .then((data) => setWorkOrder(data))
      

      .catch((error) => console.error(error));
    })
    return (
        <>
        <NavbarComponent/>
        <h1>Work Order: {workOrder.title}</h1>
        </>
    )
}
export default WorkOrderPage;