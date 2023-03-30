package com.castawaysoftware.propertymanager.controllers;

import com.castawaysoftware.propertymanager.data.Property;
import com.castawaysoftware.propertymanager.repositories.PropertyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <h1>Property Controller</h1>
 * Is the end point for all things related to CRUD of Properties
 * <p>
 *  Request: "/property/" or "/property/{id}" (If request is for a specific Property)
 * </p>
 *  <h2>
 *      Current supported
 *  </h2>
 * <p>
 *     <b>Get</b>
 * </p>
 *
 *
 *
 * */
@RestController
public class PropertyController {
    private final PropertyRepository PROPERTY_REPOSITORY;


    public PropertyController(PropertyRepository propertyRepository) {
        this.PROPERTY_REPOSITORY = propertyRepository;
    }

    /**
     * <b>GetMapping all properties</b>
     * Uses PropertyRepository to get all Properties in database
     * @return <code>List<Property></code>
     */
    @GetMapping("/property/")
   public List<Property> getAllProperties() {
        return PROPERTY_REPOSITORY.findAll();
    }

    /**
     * Uses PropertyRepository to get a single Property from database by Id.
     * @return List<Property>
     **/
    @GetMapping("/property/{id}")
    Property getPropertyById(@PathVariable Long id) {
        return PROPERTY_REPOSITORY.findById(id).get();
    }

    /**
     * <b>Add Property</b>
     * Client sends newProperty without an id, the program checks for other properties using PropertyRepository existsByName with the same name.
     * If there are no properties with the same name, it uses PropertyRepository to save newProperty\
     * After save, it sends back the created Property
     * @param newProperty
     * @return Property
     * */
    @PostMapping("/property/")
    Property addProperty(@RequestBody Property newProperty) {
        //check to see if name already exsits if it does return Null
        if (PROPERTY_REPOSITORY.existsByName(newProperty.getName())) {
            return null;
        }

        PROPERTY_REPOSITORY.save(newProperty);
        return PROPERTY_REPOSITORY.findById(newProperty.getId()).get();

    }

}
