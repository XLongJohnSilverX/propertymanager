<template>
    <bg-surface-variant style="padding: 1.5%; " v-if="!editMode" >

        <v-btn class="text-whitetext-none" color="teal-darken-1" rounded="xl" variant="outlined" @click=editSelectedUnit()>

            Edit
        </v-btn>
        <div class="text-h3" v-if="unit"> {{ unit.unitIdentifier }} </div>

        <v-row no-gutters>
            <v-col> 
                <v-sheet class="ma-2 pa-2  text-h5 font-weight-medium">
          Work Orders
        </v-sheet>
            <div class="" v-if="unit" v-for="workorder in unit.workOrderList">
                <WorkOrderCard :WorkOrder="workorder"></WorkOrderCard>
            </div>
        </v-col>
      <v-col
     
        cols="12"
        sm="4"
      >
        <v-sheet class="ma-2 pa-2 text-h5 font-weight-medium">
          Tenants
        </v-sheet>
        <v-sheet  class="ma-2 pa-2" v-for="tenantViewed in unit.tenantList">
                <TenantListItem :tenant="tenantViewed" />
            </v-sheet >
        
      </v-col>
      <v-col
     
     cols="12"
     sm="4"
   >
     <v-sheet class="ma-2 pa-2  text-h5 font-weight-medium">
       Pets
     </v-sheet>
    
     <v-card width="400">
                    <template v-slot:title>
                        Pets
                    </template>
                    <div class="" v-for="pet in unit.petList">
                        <PetListItem :pet="pet" />
                    </div>
                </v-card>
   </v-col>
    </v-row>
        <v-col class="ma-2 pa-2">
            
            
                
            </v-col>
            
    </bg-surface-variant >




    <div style="padding: 1.5%;" v-if="editMode">
        <v-btn class="text-whitetext-none" color="teal-darken-1" rounded="xl" variant="outlined" @click=saveEditedUnit()>

            Save
        </v-btn>

        <div class="flex-row">
            <v-text-field v-model="unitIdentifier" v-if="unit" label="Unit Identifier" :model-value=unit.unitIdentifier
                @update:model-value="updateUnitIdentifier()" variant="outlined"></v-text-field>
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
import WorkOrderCard from '../components/WorkOrderCard.vue'
export default {
    name: 'UnitView',
    components: {
        TenantListItem,
        PetListItem,
        WorkOrderCard
    },
    data() {
        return {
            unit: Object,
            editMode: false,

        }
    },
    mounted() {
        fetch("http://localhost:8080/unit/" + this.$route.params.id + "/")
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
                headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },
                body: JSON.stringify(this.unit)
            };

            fetch("http://localhost:8080/unit/" + this.unit.id + "/", requestOptions)
                .then(response => response.json())
                .then(data => console.log("goo" + data.isVacant)) // Manipulate the data retrieved back, if we want to do something with it
                .catch(err => console.log(err))

            this.editMode = false;

        },
        updateUnitIdentifier() {
            this.unit.unitIdentifier = this.unitIdentifier;
        }
    }

}


</script>
  