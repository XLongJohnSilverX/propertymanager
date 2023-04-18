package com.castawaysoftware.propertymanager.controllers;

import com.castawaysoftware.propertymanager.data.Tenant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class TenantController {

    @GetMapping("/tenant/")
    public List<Tenant> getAllTenants(){

    }
}
