package com.castawaysoftware.propertymanager.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ItemType {

    private@Id
    @GeneratedValue Long id;

    private String typeName;

    public ItemType(String typeName) {
        this.typeName = typeName;
    }

    
    /** 
     * @return Long
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
