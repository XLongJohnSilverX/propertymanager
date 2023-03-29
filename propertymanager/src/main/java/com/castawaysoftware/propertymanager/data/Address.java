package com.castawaysoftware.propertymanager.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.Type;

@Entity
public class Address {
    private @Id @GeneratedValue Long id;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    
    /**
     * Create an address with all empty fields.
     *
     */
    public Address ()
    {
        
        streetAddress = "";
        city = "";
        state = "";
        zipCode = "";
    }

    /**
     * Create an address.
     */
    public Address ( String streetAddr, String city, 
            String state, String zip)
    {
        
        this.streetAddress = streetAddr;
        this.city = city;
        this.state = state;
        this.zipCode = zip;
    }

    

    /**
     * @return the streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
