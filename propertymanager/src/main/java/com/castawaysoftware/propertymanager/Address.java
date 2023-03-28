package com.castawaysoftware.propertymanager;

public class Address {

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
        
        streetAddress = streetAddr;
        this.city = city;
        this.state = state;
        zipCode = zip;
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


}
