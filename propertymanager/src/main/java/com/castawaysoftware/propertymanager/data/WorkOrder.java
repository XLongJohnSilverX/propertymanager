package com.castawaysoftware.propertymanager.data;


import java.time.LocalDate;

import jakarta.persistence.*;


@Entity
public class WorkOrder {
    private @Id @GeneratedValue Long id;

    private String title;

    private String description;

    private SkillType skillType;

    private LocalDate dateCreated;

    private LocalDate dateScheduled;

    private Long propertyId;

    private Long unitId;


    public WorkOrder(){

    }

    public WorkOrder(String title, String description, SkillType skillType, LocalDate dateCreated, LocalDate dateScheduled, Long propertyId, Long unitId) {
        this.title = title;
        this.description = description;
        this.skillType = skillType;
        this.dateCreated = dateCreated;
        this.dateScheduled = dateScheduled;
        this.propertyId = propertyId;
        this.unitId = unitId;
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

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    @Override
    public String toString() {
        return "WorkOrder{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", skillType=" + skillType +
                ", dateCreated=" + dateCreated +
                ", dateScheduled=" + dateScheduled +
                ", propertyId=" + propertyId +
                ", unitId=" + unitId +
                '}';
    }
}
