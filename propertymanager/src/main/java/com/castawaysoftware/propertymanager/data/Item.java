package com.castawaysoftware.propertymanager.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Item {

    private @Id
    @GeneratedValue Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemType> itemTypeList;

    
    /** 
     * @return Long
     */
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

    public List<ItemType> getItemTypeList() {
        return itemTypeList;
    }

    public void setItemTypeList(List<ItemType> itemTypeList) {
        this.itemTypeList = itemTypeList;
    }

    public Item(String name, List<ItemType> itemTypeList) {
        this.name = name;
        this.itemTypeList = itemTypeList;
    }
}
