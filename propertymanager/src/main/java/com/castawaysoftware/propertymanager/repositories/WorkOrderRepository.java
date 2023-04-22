package com.castawaysoftware.propertymanager.repositories;

import com.castawaysoftware.propertymanager.data.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {


}
