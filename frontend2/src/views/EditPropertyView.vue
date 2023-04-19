<template>
    <div class="propertySingle" style="padding: 1.5%;">

        <v-btn class="text-whitetext-none" color="teal-darken-1" rounded="xl" variant="outlined" @click=saveProperty()>

            Save
        </v-btn>
        <TenantListItem />
        <v-text-field v-model="propertyName" v-if="property.name" label="Name" :model-value=property.name
            @update:model-value="updateName()" variant="outlined"></v-text-field>
        <v-text-field v-model="streetAddress" v-if="property.address" label="Street Address"
            :model-value=property.address.streetAddress @update:model-value="updateStreetAddress()"
            variant="outlined"></v-text-field>
        <v-text-field v-model="city" v-if="property.address" label="City" :model-value=property.address.city
            @update:model-value="updateCity()" variant="outlined"></v-text-field>
        <v-text-field v-model="state" v-if="property.address" label="State" :model-value=property.address.state
            @update:model-value="updateState()" variant="outlined"></v-text-field>
        <v-text-field v-model="zipCode" v-if="property.address" label="Zip Code" :model-value=property.address.zipCode
            @update:model-value="updateZipCode()" variant="outlined"></v-text-field>
        <v-text-field v-model="maintenanceLimit" v-if="property.maintenanceLimit" label="Maintenance Limit" prefix="$"
            :model-value=property.maintenanceLimit type="number" @update:model-value="updateMaintenanceLimit()"
            variant="outlined"></v-text-field>

        <div class="flex-row">
            <div class="flex-row" v-for="unit in property.unitList">
                <UnitCard :unit="unit" />
            </div>
        </div>



    </div>
</template>
<script>



import TenantListItem from '@/components/TenantListItem.vue'
import UnitCard from '../components/UnitCard.vue'

export default {

    name: 'EditPropertyView',
    components: {
        UnitCard,
        TenantListItem
    },props: {
    property: Object
  },
    data() {
        return {
            property: [],
            propertyName: '',
            streetAddress: '',
            city: '',
            state: '',
            zipCode: '',
            maintenanceLimit: ''


        }
    }
    ,
    // mounted() {
    //     fetch("http://localhost:8080/property/1/")
    //         .then((res => res.json()))
    //         .then(data => this.property = data)
    //         .catch(err => console.log(err.message))



    // },
    methods: {

         saveProperty() {
            const requestOptions = {
                method: 'PUT',
                 headers: {'Accept': 'application/json', 'Content-Type': 'application/json' },
                body: JSON.stringify(this.property)
            };
           
             fetch("http://localhost:8080/property/1/", requestOptions)
             .then(response => response.json())
            .then(data => console.log("goo" + data)) // Manipulate the data retrieved back, if we want to do something with it
            .catch(err => console.log(err))

        this.$router.push({ name: 'propertySingle', params: { id: this.property.id } })
                


        },
        updateName() {
            this.property.name = this.propertyName;
        },
        updateStreetAddress() {
            this.property.address.streetAddress = this.streetAddress;
        },
        updateCity() {
            this.property.address.city = this.city;
        },
        updateState() {
            this.property.address.state = this.state;
        }
        ,
        updateZipCode() {
            this.property.address.zipCode = this.zipCode;
        },
        updateMaintenanceLimit() {
            
            if(maintenanceLimit.match(/^[0-9]+$/) != null){
                this.property.maintenanceLimit = this.maintenanceLimit;

            }else{
                alert("ONLY NUMBERS ALLOWED!")
            }
            
            
        }
    }
}



</script>