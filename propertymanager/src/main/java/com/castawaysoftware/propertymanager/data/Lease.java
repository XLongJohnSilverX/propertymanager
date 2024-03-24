package com.castawaysoftware.propertymanager.data; 
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;

import com.castawaysoftware.propertymanager.services.RentService;

@Entity
public class Lease {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isSigned;

    @ElementCollection
    private List<Rent> rentList; // Assuming rent payments are represented as strings (e.g., "01/01", "02/01", etc.)

    private Long unitId;

    @ElementCollection
    private List<Long> tenantIdList; // List of tenant IDs

    @ElementCollection
    private List<Long> petIdList; // List of pet IDs

    private LocalDate startDate; // Assuming date format (e.g., "2024-03-01")

    private LocalDate endDate; // Assuming date format (e.g., "2024-08-31")

    private int rentAmount; // Rent amount

    private int depositAmount; // Deposit amount
    @Autowired @Transient
    private  RentService RENT_SERVICE;
    // Constructors
    public Lease() {
        // Default constructor
        
    }

    public Lease(boolean isSigned, List<Rent> rentList, Long unitId,
                 List<Long> tenantIdList, List<Long> petIdList,
                 LocalDate startDate, LocalDate endDate,
                 int rentAmount, int depositAmount) {
        this.isSigned = isSigned;
        this.rentList = rentList;
        this.unitId = unitId;
        this.tenantIdList = tenantIdList;
        this.petIdList = petIdList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
        this.depositAmount = depositAmount;
    }
    public Lease(Long unitId, LocalDate startDate, LocalDate endDate, int rentAmount, int depositAmount, RentService RENT_SERVICE) {
        this.unitId = unitId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
        this.depositAmount = depositAmount;
        this.rentList = RENT_SERVICE.generateRentListForNewLease(unitId, startDate, endDate, rentAmount, depositAmount);

        
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean signed) {
        isSigned = signed;
    }

    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public List<Long> getTenantIdList() {
        return tenantIdList;
    }

    public void setTenantIdList(List<Long> tenantIdList) {
        this.tenantIdList = tenantIdList;
    }

    public List<Long> getPetIdList() {
        return petIdList;
    }

    public void setPetIdList(List<Long> petIdList) {
        this.petIdList = petIdList;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(int rentAmount) {
        this.rentAmount = rentAmount;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    // Other methods (if needed) go here

    // ...
}
