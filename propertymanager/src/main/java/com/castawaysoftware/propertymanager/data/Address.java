package com.castawaysoftware.propertymanager.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.Type;

/**
 * <h1>Address</h1>
 * A basic object to hold all relevant data for an Address
 * this to insure we can validate Addresses and use them in the future
 */
@Entity
public class Address {
    /**
     * Id of Address
     * @see <a href="https://docs.oracle.com/javaee/6/api/javax/persistence/GeneratedValue.html">@GeneratedValue</a>
     */
    private @Id @GeneratedValue Long id;
    /**
     * Street Address ex: 435 E 18th St
     */
    private String streetAddress;
    /**
     * City of Address
     */
    private String city;
    /**
     * State of Address
     */
    private String state;
    /**
     * Zip Code
     */
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

    /**
     * Sends Address as a JSON object in a String format to whoever requested it
     * @return String of Address
     */
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
