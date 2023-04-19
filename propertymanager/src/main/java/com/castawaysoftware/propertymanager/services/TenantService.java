package com.castawaysoftware.propertymanager.services;

import com.castawaysoftware.propertymanager.data.Tenant;
import com.castawaysoftware.propertymanager.repositories.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {

    private final TenantRepository TENANT_REPOSITORY;

    public TenantService(TenantRepository tenantRepository) {
        TENANT_REPOSITORY = tenantRepository;
    }

    public List<Tenant> getAllTenants(){
        return TENANT_REPOSITORY.findAll();
    }

    public Tenant getTenantById(Long id){
            return TENANT_REPOSITORY.findById(id).get();
    }

    public Tenant updateTenant(Tenant updatedTenant){
        TENANT_REPOSITORY.save(updatedTenant);
        return TENANT_REPOSITORY.findById(updatedTenant.getId()).get();
    }

}
