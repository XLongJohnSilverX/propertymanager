package com.castawaysoftware.propertymanager.repositories;

import com.castawaysoftware.propertymanager.data.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RentRepository extends JpaRepository<Rent, Long>{

    void deleteById(long id);

}
