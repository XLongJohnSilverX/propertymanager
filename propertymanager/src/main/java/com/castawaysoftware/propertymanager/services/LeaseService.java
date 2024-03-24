package com.castawaysoftware.propertymanager.services;

import org.springframework.stereotype.Service;
import java.util.List;

import com.castawaysoftware.propertymanager.data.Lease;
import com.castawaysoftware.propertymanager.repositories.LeaseRepository;

/**
 * Service class for managing lease-related operations.
 */
@Service
public class LeaseService {

    private final LeaseRepository LEASE_REPOSITORY;

    /**
     * Constructs a LeaseService with the provided LeaseRepository.
     *
     * @param leaseRepository The repository for Lease entities.
     */
    public LeaseService(LeaseRepository leaseRepository) {
        LEASE_REPOSITORY = leaseRepository;
    }

    /**
     * Retrieves a list of all leases.
     *
     * @return A list of Lease entities.
     */
    public List<Lease> getAllLeases() {
        return LEASE_REPOSITORY.findAll();
    }

    /**
     * Retrieves a Lease by its ID.
     *
     * @param id The ID of the Lease to retrieve.
     * @return The Lease entity corresponding to the given ID.
     */
    public Lease getLeaseById(Long id) {
        return LEASE_REPOSITORY.findById(id).orElse(null);
    }
    

    /**
     * Creates a new Lease.
     *
     * @param lease The Lease entity to create.
     * @return The created Lease entity.
     */
    public Lease createLease(Lease lease) {
        return LEASE_REPOSITORY.save(lease);
    }

    /**
     * Updates an existing Lease.
     *
     * @param lease The Lease entity to update.
     * @return The updated Lease entity.
     */
    public Lease updateLease(Lease lease) {
        return LEASE_REPOSITORY.save(lease);
    }

    /**
     * Deletes a Lease by its ID.
     *
     * @param id The ID of the Lease to delete.
     */
    public void deleteLease(Long id) {
        LEASE_REPOSITORY.deleteById(id);
    }

    public List<Lease> getLeaseByUnitId(Long id) {
        return LEASE_REPOSITORY.getLeaseByUnitId(id);
    }
}
