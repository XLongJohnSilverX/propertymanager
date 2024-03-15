package com.castawaysoftware.propertymanager.controllers;

import com.castawaysoftware.propertymanager.data.Tenant;
import com.castawaysoftware.propertymanager.services.TenantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h1>Tenant Controller</h1>
 * REST Endpoint for all things related to Tenant Entity
 * <p>Request: "/tenant/ or "/tenant/{id}" </p>
 */
@RestController
public class TenantController {

    private final TenantService TENANT_SERVICE;

    public TenantController(TenantService tenantService) {
        TENANT_SERVICE = tenantService;
    }

    /**
     * <b>GetMapping: All Properties</b>
     * @return<code>List<Tenant></code>
     */
    @CrossOrigin
    @GetMapping("/tenant/")
    public List<Tenant> getAllTenants(){
    return TENANT_SERVICE.getAllTenants();
    }

    /**
     * Uses TenantService to get a single Tenant from Repository by Id
     * @param id Long Id of Tenant client requests
     * @return Tenant
     */
    @CrossOrigin
    @GetMapping("/tenant/{id}/")
    public Tenant getTenantById(@PathVariable Long id){
       return TENANT_SERVICE.getTenantById(id);
    }

    @CrossOrigin
    @PutMapping("/tenant/{id}/")
    public Tenant updateTenant(@PathVariable Long id, @RequestBody Tenant updatedTenant){
        return TENANT_SERVICE.updateTenant(updatedTenant);
    }
}
