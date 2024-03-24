package com.castawaysoftware.propertymanager.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.castawaysoftware.propertymanager.data.Lease;

public interface LeaseRepository extends JpaRepository<Lease, Long>{

    List<Lease> getLeaseByUnitId(Long unitId);
    
}
