package com.castawaysoftware.propertymanager.data;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Rent {

    private @Id @GeneratedValue Long id;

    private Long unitId;

    private LocalDate dueDate;

    private LocalDate paymentDate;

    private boolean isPaid;

    private boolean isOverdue;

    private int rentAmount;

    public Rent() {
        
    }

    public Rent(Long unitId, LocalDate dueDate, LocalDate paymentDate, boolean isPaid, boolean isOverdue, int rentAmount) {
        this.unitId = unitId;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.isPaid = isPaid;
        this.isOverdue = isOverdue;
        this.rentAmount = rentAmount;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUnitId() {
        return unitId;
    }
    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
    public boolean isPaid() {
        return isPaid;
    }
    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
    public boolean isOverdue() {
        return isOverdue;
    }
    public void setOverdue(boolean isOverdue) {
        this.isOverdue = isOverdue;
    }
    public int getRentAmount() {
        return rentAmount;
    }
    public void setRentAmount(int rentAmount) {
        this.rentAmount = rentAmount;
    }
    


}