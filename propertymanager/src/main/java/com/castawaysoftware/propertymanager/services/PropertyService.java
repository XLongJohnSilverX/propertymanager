package com.castawaysoftware.propertymanager.services;

import com.castawaysoftware.propertymanager.data.Property;
import com.castawaysoftware.propertymanager.repositories.PropertyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Property Service
 * This is the middle man between PropertyController and Property Repository
 * This translates the request into tasks to send to the repository.
 */
@Service
public class PropertyService {

    private final PropertyRepository PROPERTY_REPOSITORY;

    /**
     * This constructor allows us to call the repository to make changes to the database.
     * @param propertyRepository Repository for Property Object
     */
    public PropertyService(PropertyRepository propertyRepository) {
        this.PROPERTY_REPOSITORY = propertyRepository;
    }

    /**
     * when called, it will tell the Property Repository to grab all properties and send them back to the controller
     * @return
     */
    public List<Property> getAllProperties(){
        return PROPERTY_REPOSITORY.findAll();
    }

    /**
     * Uses PropertyRepository to get a single Property from database by Id.
     * @param id
     * @return
     */
    public Property getPropertyById(Long id){
        return PROPERTY_REPOSITORY.findById(id).get();
    }
    /**
     *
     * Client sends newProperty without an id, the program checks for other properties using PropertyRepository existsByName with the same name.
     * If there are no properties with the same name, it uses PropertyRepository to save newProperty\
     * After save, it sends back the created Property
     * @param newProperty
     * @return Property
     * */

   public Property addProperty( Property newProperty) {
        /**check to see if name already exists, if it does return Null */
        if (PROPERTY_REPOSITORY.existsByName(newProperty.getName())) {
            return null;
        }
        /**
         * If Property does not have the same name as another property in the database,
         * it will call the Repository to save that property into the database.
         */
        PROPERTY_REPOSITORY.save(newProperty);
        /**
         * After saving the New Property, the repository will send back the newly created property.
         */
        return PROPERTY_REPOSITORY.findById(newProperty.getId()).get();
    }

    /**
     * Updates Property by checking to see which values were changed and updating them accordingly.
     * @param id -Id of Property to be changed
     * @param updatedProperty -Property with changes
     * @return
     */
    public Property updateProperty(Long id, Property updatedProperty){
        if (PROPERTY_REPOSITORY.existsById(id)) {
            /**
             * If Property exists then it will check every field and update accordingly.
             */
            if (PROPERTY_REPOSITORY.findById(id).get().getName() != updatedProperty.getName()){
                PROPERTY_REPOSITORY.findById(id).get().setName(updatedProperty.getName());
            }
            if (PROPERTY_REPOSITORY.findById(id).get().getAddress() != updatedProperty.getAddress()){
                PROPERTY_REPOSITORY.findById(id).get().setAddress(updatedProperty.getAddress());
            }
            if (PROPERTY_REPOSITORY.findById(id).get().getUnitList() != updatedProperty.getUnitList()){
                PROPERTY_REPOSITORY.findById(id).get().setUnitList(updatedProperty.getUnitList());
            }
            if (PROPERTY_REPOSITORY.findById(id).get().getMaintenanceLimit() != updatedProperty.getMaintenanceLimit()){
                PROPERTY_REPOSITORY.findById(id).get().setMaintenanceLimit(updatedProperty.getMaintenanceLimit());
            }

        }
        return updatedProperty;
    }

    /**
     * Sends ID of property to be deleted to repository to delete
     * @param id ID of property to be deleted
     */
    public void deleteProperty(long id){
        PROPERTY_REPOSITORY.deleteById(id);
    }


}
