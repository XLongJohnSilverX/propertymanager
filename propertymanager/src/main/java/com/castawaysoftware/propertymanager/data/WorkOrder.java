package com.castawaysoftware.propertymanager.data;


import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;


@Entity
public class WorkOrder {
    private @Id @GeneratedValue Long id;

    private String title;

    private String description;

    private SkillType skillType;

    private LocalDate dateCreated;

    private LocalDate dateScheduled;


    
    private Long unitId;

 
    private Long propertyId;


    @OneToMany(cascade = CascadeType.ALL)
    private List<HoursLogged> hoursLoggedList;

    private WorkOrderStatus workOrderStatus;

    private boolean isAssigned;

    

    public WorkOrder(){

    }

    public WorkOrder(String title, String description, SkillType skillType, LocalDate dateCreated, LocalDate dateScheduled,  List<HoursLogged> hoursLoggedList, WorkOrderStatus workOrderStatus, boolean isAssigned, Long unitId, Long propertyId) {
        this.title = title;
        this.description = description;
        this.skillType = skillType;
        this.dateCreated = dateCreated;
        this.dateScheduled = dateScheduled;


        this.hoursLoggedList = hoursLoggedList;
        this.workOrderStatus = workOrderStatus;
        this.isAssigned = isAssigned;
        this.unitId = unitId;
        this.propertyId = propertyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateScheduled() {
        return dateScheduled;
    }

    public void setDateScheduled(LocalDate dateScheduled) {
        this.dateScheduled = dateScheduled;
    }




    public List<HoursLogged> getHoursLoggedList() {
        return hoursLoggedList;
    }

    public void setHoursLoggedList(List<HoursLogged> hoursLoggedList) {
        this.hoursLoggedList = hoursLoggedList;
    }

    public WorkOrderStatus getWorkOrderStatus() {
        return workOrderStatus;
    }

    public void setWorkOrderStatus(WorkOrderStatus workOrderStatus) {
        this.workOrderStatus = workOrderStatus;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public Long getUnitId() {
        return unitId;
    }
    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }
    public Long getPropertyId() {
        return propertyId;
    }
    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
}
