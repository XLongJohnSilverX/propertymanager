package com.castawaysoftware.propertymanager.repositories;
import java.util.List;
import com.castawaysoftware.propertymanager.data.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RentRepository extends JpaRepository<Rent, Long>{

    void deleteById(Long id);
    List<Rent> getRentsByUnitId(Long id);

}
