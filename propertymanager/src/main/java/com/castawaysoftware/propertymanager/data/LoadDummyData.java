package com.castawaysoftware.propertymanager.data;

import com.castawaysoftware.propertymanager.repositories.PropertyRepository;
import com.castawaysoftware.propertymanager.repositories.WorkOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    CommandLineRunner initDatabase(PropertyRepository repository, WorkOrderRepository workOrderRepository) {

        return args -> {
            Address address = new Address("435 E 18th St", "Tucson", "AZ", "85743");
            Tenant emma = new Tenant("Emma", "Rose", "emmarose02@icloud.com", "909-270-9561");
            Tenant jason = new Tenant("Jason", "Della Penna", "emmarose02@icloud.com", "909-270-9561");
            List<Tenant> tenantList = new ArrayList<>();
            tenantList.add(emma);
            tenantList.add(jason);
            Pet toby = new Pet("Toby", "Dog");
            List<Pet> petList = new ArrayList<>();
            petList.add(toby);
            List<String> ammenities = new ArrayList<>();
            ammenities.add("Dog Park");
            ammenities.add("Laundry Room");
            ammenities.add("Pool");
            List<String> appliances = new ArrayList<>();
            appliances.add("Washer");
            appliances.add("Dryer");
            appliances.add("Air Conditioning");
            String desc = "This is a beautifully remodeled ground floor 1-Bedroom/1-Bath unit located on 18th St in the Armory Park/Downtown area. ";

            LocalDateTime  date = LocalDateTime.now();
            LocalDateTime date2 = LocalDateTime.now();
            HoursLogged hoursLogged = new HoursLogged(date, date2, "Replaced Filters");
            List<HoursLogged> hoursLoggedList = new ArrayList<>();
            hoursLoggedList.add(hoursLogged);
            WorkOrder workOrder = new WorkOrder("Change Filters", "Change HVAC Filters for each unit", SkillType.HVAC, LocalDate.now(),LocalDate.now(), hoursLoggedList, WorkOrderStatus.SCHEDULED, false );
            List<WorkOrder> workOrderList = new ArrayList<>();
            workOrderList.add(workOrder);
            Unit unit1 = new Unit("Unit 10", tenantList,petList, true, true, 1, 1.5, 680,ammenities,appliances, 750, 35, 500, desc,workOrderList );
            Unit unit2 = new Unit("Unit 11");
            List<Unit> unitList = new ArrayList<>();
            unitList.add(unit1);
            unitList.add(unit2);

            List<Storage> storageList = new ArrayList<>();
            List<Item> itemList = new ArrayList<>();
            List<ItemType> itemTypeList = new ArrayList<>();
            itemTypeList.add(new ItemType("Electric"));
            Item lightbulb = new Item("Light Bulb", itemTypeList);
            Storage shop = new Storage("Shop", itemList);
            storageList.add(shop);

            log.info("Preloading " + repository.save(new Property("Bel Air", address, unitList,storageList,  5000)) + workOrderRepository.save(workOrder));

        };
    }
}
