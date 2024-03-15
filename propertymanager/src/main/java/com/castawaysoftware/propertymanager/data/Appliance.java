package com.castawaysoftware.propertymanager.data;

import jakarta.persistence.*;

/**
 * The `Appliance` class represents an appliance with details such as make, model, serial number, and other information.
 */
@Entity
 public class Appliance {

   /**
     * Id of Appliance that is generated
     * @see <a href="https://docs.oracle.com/javaee/6/api/javax/persistence/GeneratedValue.html">@GeneratedValue</a>
     */
    private @Id @GeneratedValue Long id;

    /**
     * The make of the appliance
     */
    private String make;
    /**
     * The model of the appliance
     */
    private String model;
    /** The serial number of the appliance */
    private String serialNumber;
    /** The type of the appliance  @see ApplianceType*/
    private ApplianceType applianceType;
    /** The power type of the appliance @see AppliancePowerType  */
    private AppliancePowerType appliancePowerType;
    /** Any other additional information about the appliance */
    private String otherInformation;


        public Appliance(){

        }    
        /**
     * Constructs a new Appliance object with the provided details.
     * @param make The make of the appliance
     * @param model The model of the appliance
     * @param serialNumber The serial number of the appliance
     * @param applianceType The type of the appliance
     * @param appliancePowerType The power type of the appliance
     * @param otherInformation Any other additional information about the appliance
     */
    
    // Constructor
        public Appliance(String make, String model, String serialNumber, ApplianceType applianceType, AppliancePowerType appliancePowerType, String otherInformation) {
            
            this.make = make;
            this.model = model;
            this.serialNumber = serialNumber;
            this.applianceType = applianceType;
            this.appliancePowerType = appliancePowerType;
            this.otherInformation = otherInformation;
        }
    
        /** Get Id of Appliance 
        */
        public Long getId() {
            return id;
        }
        /**
         * Set Id of Appliance
         * @param id
         */
        public void setId(Long id) {
            this.id = id;
        }
        /**
         * Get make of Appliance
         * @return
         */
        public String getMake() {
            return make;
        }
        /**
         * Set make of Appliance
         * @param make
         */
        public void setMake(String make) {
            this.make = make;
        }
        /**
         * Get model of Appliance
         * @return
         */
        public String getModel() {
            return model;
        }
        /**
         * Set model of Appliance
         * @param model
         */
        public void setModel(String model) {
            this.model = model;
        }
        /**
         * Get serial number of Appliance
         * @return
         */
        public String getSerialNumber() {
            return serialNumber;
        }
        /**
         * Set serial number of Appliance
         * @param serialNumber
         */
        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }
        /**
         * Get type of Appliance
         * @see ApplianceType
         * @return
         */
        public ApplianceType getApplianceType() {
            return applianceType;
        }
        /**
         * Set type of Appliance
         @see ApplianceType
         * @param applianceType
         */
        public void setApplianceType(ApplianceType applianceType) {
            this.applianceType = applianceType;
        }
        /**
         * Get power type of Appliance @see AppliancePowerType
         * @return
         */
        public AppliancePowerType getAppliancePowerType() {
            return appliancePowerType;
        }
        /**
         * Set power type of Appliance @see AppliancePowerType
         * @param appliancePowerType
         */
        public void setAppliancePowerType(AppliancePowerType appliancePowerType) {
            this.appliancePowerType = appliancePowerType;
        }
        /**
         * Get other information of Appliance
         * @return
         */
        public String getOtherInformation() {
            return otherInformation;
        }
        /**
         * Set other information of Appliance
         * @param otherInformation
         */
        public void setOtherInformation(String otherInformation) {
            this.otherInformation = otherInformation;
        }
    /** 
     * Creates a String Representation of Appliance
     */
        // ToString method
        @Override
        public String toString() {
            return "Appliance{" +
                    "id=" + id +
                    ", make='" + make + '\'' +
                    ", model='" + model + '\'' +
                    ", serialNumber='" + serialNumber + '\'' +
                    ", applianceType=" + applianceType +
                    ", appliancePowerType=" + appliancePowerType +
                    ", otherInformation='" + otherInformation + '\'' +
                    '}';
        }




}
