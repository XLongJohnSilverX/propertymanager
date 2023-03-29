package com.castawaysoftware.propertymanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyController {
    private final PropertyRepository PROPERTY_REPOSITORY;


    public PropertyController(PropertyRepository propertyRepository) {
        this.PROPERTY_REPOSITORY = propertyRepository;
    }

    @GetMapping("/property")
    List<Property> all(){
        return PROPERTY_REPOSITORY.findAll();
    }

}
