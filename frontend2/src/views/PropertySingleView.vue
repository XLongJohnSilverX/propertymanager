<template>
    <!--EDIT MODE-->
    <div class="propertySingle" style="padding: 1.5%;" v-if="editMode">

        <v-btn class="text-whitetext-none" color="teal-darken-1" rounded="xl" variant="outlined" @click=saveProperty()>

            Save
        </v-btn>
        <v-btn class="text-whitetext-none" color="teal-darken-1" rounded="xl" variant="outlined" @click=cancelEdit()>

            Cancel
        </v-btn>
        <v-btn class="text-whitetext-none" color="teal-darken-1" rounded="xl" variant="outlined" @click=deleteProperty()>

            Delete
        </v-btn>

        <v-text-field v-model="propertyName" v-if="property" label="Name" :model-value=property.name
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
        <v-text-field v-model="maintenanceLimit" v-if="property" label="Maintenance Limit" prefix="$"
            :model-value=property.maintenanceLimit @update:model-value="updateMaintenanceLimit()"
            variant="outlined"></v-text-field>





    </div>
    <!-- VIEW MODE -->
    <div class="propertySingle" style="padding: 1.5%;" v-if="!editMode">

        <v-btn class="text-whitetext-none" color="teal-darken-1" rounded="xl" variant="outlined"
            @click=editSelectedProperty(property)>

            Edit
        </v-btn>

        <h1 v-if="property"> {{ property.name }} </h1>
        <p v-if="property.address">{{ property.address.streetAddress }} {{ property.address.city }}, {{ property.address.state
        }} {{ property.address.zipCode }}</p>
        <p v-if="property">Maintenance Limit: $ {{ property.maintenanceLimit }}</p>
        <div class="flex-row">
            <div class="flex-row" v-for="unit in property.unitList">
                <UnitCard :unit="unit" v-on:removeUnit="removeUnit($event)" />
            </div>
            <v-btn icon="mdi-plus" size="large" @click="addNewUnit()"></v-btn>
        </div>



    </div>
</template>
<script>



import TenantListItem from '@/components/TenantListItem.vue'
import UnitCard from '../components/UnitCard.vue'
import EditPropertyView from './EditPropertyView.vue'
export default {

    name: 'PropertySingleView',
    components: {
        UnitCard,

        EditPropertyView

    },

    data() {
        return {
            property: [],

            editMode: false,
            propertyName: '',
            streetAddress: '',
            city: '',
            state: '',
            zipCode: '',
            maintenanceLimit: ''

        }
    }
    ,
    mounted() {
        fetch("http://localhost:8080/property/" + this.$route.params.id + "/")
            .then((res => res.json()))
            .then(data => this.property = data)
            .catch(err => console.log(err.message));





    },
    methods: {
        editSelectedProperty() {

            this.editMode = true;

            // alert("This feature is still under construction")
            // this.$router.push({ name: 'propertySingleEdit', params: { id: property.id } })
        },
        saveProperty() {
            const requestOptions = {
                method: 'PUT',
                headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },
                body: JSON.stringify(this.property)
            };

            fetch("http://localhost:8080/property/" + this.property.id + "/", requestOptions)
                .then(response => response.json())
                .then(data => console.log("goo" + data)) // Manipulate the data retrieved back, if we want to do something with it
                .catch(err => console.log(err))
            this.editMode = false


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
            if (this.maintenanceLimit.match(/^[0-9]+$/) != null) {
                this.property.maintenanceLimit = this.maintenanceLimit;

            } else {
                alert("ONLY NUMBERS ALLOWED!")
            }
        },
        cancelEdit() {
            fetch("http://localhost:8080/property/1/")
                .then((res => res.json()))
                .then(data => this.property = data)
                .catch(err => console.log(err.message));

            this.editMode = false;

        },
        deleteProperty() {
            const requestOptions = {
                method: 'DELETE',
                headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },

            };

            fetch("http://localhost:8080/property/" + this.property.id + "/", requestOptions)
                // Manipulate the data retrieved back, if we want to do something with it
                .catch(err => console.log(err))
            this.$router.push({ name: 'property' });
        },
        addNewUnit() {
            this.$router.push({ name: 'newUnit', query: { property: this.property.id } });
        },
        removeUnit(unitIdToBeRemoved) {
            for (var i = this.property.unitList.length - 1; i >= 0; --i) {
                if (this.property.unitList[i].id == unitIdToBeRemoved) {
                    this.property.unitList.splice(i, 1);
                }
            }
            this.saveProperty();
            alert("Unit Removed" );
        }
    }



}
</script>