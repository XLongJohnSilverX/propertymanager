package com.castawaysoftware.propertymanager.controllers;


import com.castawaysoftware.propertymanager.data.WorkOrder;
import com.castawaysoftware.propertymanager.services.WorkOrderService;
import org.hibernate.jdbc.Work;
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

    @GetMapping("/workorder/")
    public List<WorkOrder> getAllWorkOrders(){
        return WORKORDERSERVICE.getAllWorkOrders();
    }

    @GetMapping("/workorder/{id}/")
    public WorkOrder getWorkOrderById(@PathVariable Long id){
        return WORKORDERSERVICE.getWorkOrderById(id);
    }
}
