package com.castawaysoftware.propertymanager.services;

import com.castawaysoftware.propertymanager.data.WorkOrder;
import com.castawaysoftware.propertymanager.repositories.WorkOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderService {

    private final WorkOrderRepository WORKORDERREPOSITORY;

    public WorkOrderService(WorkOrderRepository WORKORDERREPOSITORY) {
        this.WORKORDERREPOSITORY = WORKORDERREPOSITORY;
    }

    public List<WorkOrder> getAllWorkOrders(){
        return WORKORDERREPOSITORY.findAll();
    }

    public WorkOrder getWorkOrderById(Long id){
        return WORKORDERREPOSITORY.findById(id).get();
    }

    public WorkOrder newWorkOrder(WorkOrder workOrder){
        return WORKORDERREPOSITORY.save(workOrder);
    }

    public WorkOrder updateWorkOrder(WorkOrder workOrder){
        return WORKORDERREPOSITORY.save(workOrder);
    }
}
