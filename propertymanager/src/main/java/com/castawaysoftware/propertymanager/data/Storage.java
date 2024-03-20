package com.castawaysoftware.propertymanager.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Storage {
    private @Id
    @GeneratedValue Long id;
    /**
     * Name of Storage
     */
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itemList;

    public Storage(String name, List<Item> itemList) {
        this.name = name;
        this.itemList = itemList;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Storage() {
    }
}
