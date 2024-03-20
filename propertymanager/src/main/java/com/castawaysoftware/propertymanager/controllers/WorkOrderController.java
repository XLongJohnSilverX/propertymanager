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

   @CrossOrigin
    @GetMapping("/workorder/")
    public List<WorkOrder> getAllWorkOrders(){
        return WORKORDERSERVICE.getAllWorkOrders();
    }

    @CrossOrigin
    @GetMapping("/workorder/{id}/")
    public WorkOrder getWorkOrderById(@PathVariable Long id){
        return WORKORDERSERVICE.getWorkOrderById(id);
    }

    @CrossOrigin
    @GetMapping("/workorder/byproperty/{id}/")
    public List<WorkOrder> getWorkOrdersByPropertyId(@PathVariable Long id){
        return WORKORDERSERVICE.getWorkOrdersByPropertyId(id);
    }
    @CrossOrigin
    @GetMapping("/workorder/byunit/{id}/")
    public List<WorkOrder> getWorkOrdersByUnitId(@PathVariable Long id){
        return WORKORDERSERVICE.getWorkOrdersByUnitId(id);
    }
}
