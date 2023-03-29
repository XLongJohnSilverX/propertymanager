package com.castawaysoftware.propertymanager.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Property {

    private @Id
    @GeneratedValue Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Unit> unitList;

    private int maintenanceLimit;



    public Property() {
    }

    public Property(String name, Address address, List<Unit> unitList, int maintenanceLimit) {
        this.name = name;
        this.address = address;
        this.unitList = unitList;
        this.maintenanceLimit = maintenanceLimit;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Unit> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<Unit> unitList) {
        this.unitList = unitList;
    }

    public int getMaintenanceLimit() {
        return maintenanceLimit;
    }

    public void setMaintenanceLimit(int maintenanceLimit) {
        this.maintenanceLimit = maintenanceLimit;
    }



    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress=" + address +
                ", unitList=" + unitList +
                ", maintenanceLimit=" + maintenanceLimit +

                '}';
    }
}
