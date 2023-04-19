package com.castawaysoftware.propertymanager.repositories;

import com.castawaysoftware.propertymanager.data.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
    

    void deleteById(long id);
}
