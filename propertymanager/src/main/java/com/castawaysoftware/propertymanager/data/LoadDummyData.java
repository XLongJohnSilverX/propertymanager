package com.castawaysoftware.propertymanager.data;

import com.castawaysoftware.propertymanager.repositories.PropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Load Dummy Data
 *
 * Creates Dummy data for API testing
 */
@Configuration
public class LoadDummyData {

    private static final Logger log = LoggerFactory.getLogger(LoadDummyData.class);

    @Bean
    CommandLineRunner initDatabase(PropertyRepository repository) {

        return args -> {
            Address address = new Address("435 E 18th St", "Tucson", "AZ", "85743");
            Tenant emma = new Tenant("Emma", "Rose", "emmarose02@icloud.com", "909-270-9561");
            List<Tenant> tenantList = new ArrayList<>();
            tenantList.add(emma);
            Pet toby = new Pet("Toby", "Dog");
            List<Pet> petList = new ArrayList<>();
            petList.add(toby);
            Unit unit1 = new Unit("Unit 10", tenantList,petList);
            List<Unit> unitList = new ArrayList<>();
            unitList.add(unit1);

            log.info("Preloading " + repository.save(new Property("Bel Air", address, unitList, 5000)));

        };
    }
}
