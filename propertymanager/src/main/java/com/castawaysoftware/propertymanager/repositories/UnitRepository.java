package com.castawaysoftware.propertymanager.repositories;

import com.castawaysoftware.propertymanager.data.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    boolean existsByUnitIdentifier(String name);

    void deleteById(Long id);
}
