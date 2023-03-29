package com.castawaysoftware.propertymanager.repositories;

import com.castawaysoftware.propertymanager.data.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {


     boolean existsByName(String name);


}
