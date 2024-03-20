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

    
    /** 
     * @return List<WorkOrder>
     */
    public List<WorkOrder> getAllWorkOrders() {
        return WORKORDERREPOSITORY.findAll();
    }

    public WorkOrder getWorkOrderById(Long id) {
        return WORKORDERREPOSITORY.findById(id).get();
    }

    public WorkOrder newWorkOrder(WorkOrder workOrder) {
        return WORKORDERREPOSITORY.save(workOrder);
    }

    public WorkOrder updateWorkOrder(WorkOrder workOrder) {
        return WORKORDERREPOSITORY.save(workOrder);
    }

    public List<WorkOrder> getWorkOrdersByPropertyId(Long id) {
        return WORKORDERREPOSITORY.getWorkOrdersByPropertyId(id);
    }
    public List<WorkOrder> getWorkOrdersByUnitId(Long id) {
        return WORKORDERREPOSITORY.getWorkOrdersByUnitId(id);
    }
}
