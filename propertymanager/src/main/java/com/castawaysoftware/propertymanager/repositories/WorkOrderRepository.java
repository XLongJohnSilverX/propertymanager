package com.castawaysoftware.propertymanager.repositories;

import com.castawaysoftware.propertymanager.data.WorkOrder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {

    List<WorkOrder> getWorkOrdersByPropertyId(Long id);

    List<WorkOrder> getWorkOrdersByUnitId(Long id);
}
