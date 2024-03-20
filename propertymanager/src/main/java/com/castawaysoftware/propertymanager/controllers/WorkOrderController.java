package com.castawaysoftware.propertymanager.controllers;


import com.castawaysoftware.propertymanager.data.WorkOrder;
import com.castawaysoftware.propertymanager.services.WorkOrderService;
import org.hibernate.jdbc.Work;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkOrderController {

    private final WorkOrderService WORKORDERSERVICE;

    public WorkOrderController(WorkOrderService WORKORDERSERVICE) {
        this.WORKORDERSERVICE = WORKORDERSERVICE;
    }

   
   /** 
    * @return List<WorkOrder>
    */
   @CrossOrigin
    @GetMapping("/workorder/")
    public List<WorkOrder> getAllWorkOrders(){
        return WORKORDERSERVICE.getAllWorkOrders();
    }

    /**
     * A description of the entire Java function.
     *
     * @param  id	description of parameter
     * @return         	description of return value
     */
    @CrossOrigin
    @GetMapping("/workorder/{id}/")
    public WorkOrder getWorkOrderById(@PathVariable Long id){
        return WORKORDERSERVICE.getWorkOrderById(id);
    }

    /**
     * Retrieves a list of work orders by property ID.
     *
     * @param  id  the ID of the property
     * @return     a list of work orders associated with the property
     */
    @CrossOrigin
    @GetMapping("/workorder/byproperty/{id}/")
    public List<WorkOrder> getWorkOrdersByPropertyId(@PathVariable Long id){
        return WORKORDERSERVICE.getWorkOrdersByPropertyId(id);
    }
    /**
     * Retrieves a list of work orders by unit ID.
     *
     * @param  id   the unit ID
     * @return      a list of work orders
     */
    @CrossOrigin
    @GetMapping("/workorder/byunit/{id}/")
    public List<WorkOrder> getWorkOrdersByUnitId(@PathVariable Long id){
        return WORKORDERSERVICE.getWorkOrdersByUnitId(id);
    }
}
