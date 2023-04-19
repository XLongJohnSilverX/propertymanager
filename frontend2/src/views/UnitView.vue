<template>
    <div style="padding: 1.5%;" v-if="!editMode">

        <v-btn class="text-whitetext-none" color="teal-darken-1" rounded="xl" variant="outlined" @click=editSelectedUnit()>

            Edit
        </v-btn>
        <h1 v-if="unit"> {{ unit.unitIdentifier }} </h1>
        <div class="flex-row">
            <div class="flex-row" v-for="tenantViewed in unit.tenantList">
                <TenantListItem :tenant="tenantViewed" />
            </div>
            <div>
                <v-card width="400">
                    <template v-slot:title>
                        Pets
                    </template>
                    <div class="flex-row" v-for="pet in unit.petList">
                        <PetListItem :pet="pet" />
                    </div>
                </v-card>
            </div>

        </div>
    </div>
    <div style="padding: 1.5%;" v-if="editMode">
        <v-btn class="text-whitetext-none" color="teal-darken-1" rounded="xl" variant="outlined" @click=saveEditedUnit()>

            Save
        </v-btn>
        
        <div class="flex-row">
            <v-text-field v-model="unitIdentifier" v-if="unit" label="Unit Identifier" :model-value=unit.unitIdentifier
            @update:model-value="updateUnitIdentifier()"    variant="outlined"></v-text-field>
            <v-switch v-model="unit.isVacant" color="teal-lighten-2" inset label="Vacant?"></v-switch>
            <v-switch v-model="unit.allowsPets" color="teal-lighten-2" inset label="Allows Pets?"></v-switch>
            <v-text-field v-model="numberOfBeds" v-if="unit" label="Bedrooms" :model-value=unit.numberOfBeds
                @update:model-value="" variant="outlined"></v-text-field>
            <v-text-field v-model="numberOfBaths" v-if="unit" label="Baths" :model-value=unit.numberOfBaths
                @update:model-value="" variant="outlined"></v-text-field>
            <v-text-field v-model="squareFeet" v-if="unit" label="Square Feet" :model-value=unit.squareFeet
                @update:model-value="" variant="outlined"></v-text-field>
            <v-text-field v-model="monthlyRent" v-if="unit" label="Monthly Rent" :model-value=unit.monthlyRent
                @update:model-value="" variant="outlined"></v-text-field>
            <v-text-field v-model="applicationFee" v-if="unit" label="Application Fee" :model-value=unit.applicationFee
                @update:model-value="" variant="outlined"></v-text-field>
            <v-text-field v-model="securityDeposit" v-if="unit" label="Security Deposit" :model-value=unit.securityDeposit
                @update:model-value="" variant="outlined"></v-text-field>
            <v-text-field v-model="unitDescription" v-if="unit" label="Description" :model-value=unit.unitDescription
                @update:model-value="" variant="outlined"></v-text-field>
            
        </div>
    </div>
</template>
<script>
// import { property } from 'lodash';
import TenantListItem from '@/components/TenantListItem.vue';
import PetListItem from '@/components/PetListItem.vue';
export default {
    name: 'UnitView',
    components: {
        TenantListItem,
        PetListItem
    },
    data() {
        return {
            unit: Object,
            editMode: false,
            
        }
    },
    mounted() {
        fetch("http://localhost:8080/unit/" +this.$route.params.id +"/")
            .then((res => res.json()))
            .then(data => this.unit = data)
            .catch(err => console.log(err.message));

    },
    methods: {
        editSelectedUnit() {
            this.editMode = true;
        },
        saveEditedUnit() {
            const requestOptions = {
                method: 'PUT',
                 headers: {'Accept': 'application/json', 'Content-Type': 'application/json' },
                body: JSON.stringify(this.unit)
            };
           
             fetch("http://localhost:8080/unit/" + this.unit.id + "/", requestOptions)
             .then(response => response.json())
            .then(data => console.log("goo" + data.isVacant)) // Manipulate the data retrieved back, if we want to do something with it
            .catch(err => console.log(err))
                           
            this.editMode = false;

        },
        updateUnitIdentifier(){
            this.unit.unitIdentifier = this.unitIdentifier;
        }
    }

}


</script>
  