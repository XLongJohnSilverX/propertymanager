package com.castawaysoftware.propertymanager.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Unit {

    private @Id
    @GeneratedValue Long id;
    private String unitIdentifier;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tenant> tenantList;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pet> petList;

    public Unit() {
    }

    public Unit(String unitIdentifier, List<Tenant> tenantList, List<Pet> petList) {
        this.unitIdentifier = unitIdentifier;
        this.tenantList = tenantList;
        this.petList = petList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitIdentifier() {
        return unitIdentifier;
    }

    public void setUnitIdentifier(String unitIdentifier) {
        this.unitIdentifier = unitIdentifier;
    }

    public List<Tenant> getTenantList() {
        return tenantList;
    }

    public void setTenantList(List<Tenant> tenantList) {
        this.tenantList = tenantList;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", unitIdentifier='" + unitIdentifier + '\'' +
                ", tenantList=" + tenantList +
                ", petList=" + petList +
                '}';
    }
}
