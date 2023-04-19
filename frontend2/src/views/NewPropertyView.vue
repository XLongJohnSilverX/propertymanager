<template>
    <div class="propertySingle" style="padding: 1.5%;">

    <v-btn class=" text-whitetext-none" color="teal-darken-1" rounded="xl" variant="outlined" @click=saveProperty()>

        Save
        </v-btn>
        <v-btn class="text-whitetext-none" color="teal-darken-1" rounded="xl" variant="outlined" @click=cancelEdit()>

            Cancel
        </v-btn>

        <v-text-field v-model="propertyName"  label="Name" :model-value=property.name
            @update:model-value="updateName()" variant="outlined"></v-text-field>
        <v-text-field v-model="streetAddress" label="Street Address"
            :model-value=Address.streetAddress @update:model-value="updateStreetAddress()"
            variant="outlined"></v-text-field>
        <v-text-field v-model="city"  label="City" :model-value=Address.city
            @update:model-value="updateCity()" variant="outlined"></v-text-field>
        <v-text-field v-model="state"  label="State" :model-value=Address.state
            @update:model-value="updateState()" variant="outlined"></v-text-field>
        <v-text-field v-model="zipCode"  label="Zip Code" :model-value=Address.zipCode
            @update:model-value="updateZipCode()" variant="outlined"></v-text-field>
        <v-text-field v-model="maintenanceLimit"  label="Maintenance Limit" prefix="$"
            :model-value=property.maintenanceLimit @update:model-value="updateMaintenanceLimit()"
            variant="outlined"></v-text-field>





    </div>
</template>
<script>
    export default{
        name: "NewPropertyView",
        data() {
    return {
      property: {},
      Address: {},
      propertyName: '',
            streetAddress: '',
            city: '',
            state: '',
            zipCode: '',
            maintenanceLimit: ''
     
    }},
    methods:{
        saveProperty() {
            this.property.address = this.Address;
            const requestOptions = {
                method: 'POST',
                 headers: {'Accept': 'application/json', 'Content-Type': 'application/json' },
                body: JSON.stringify(this.property)
            };
           
             fetch("http://localhost:8080/property/", requestOptions)
             .then((res => res.json()))
            .then(data => this.$router.push({ name: 'propertySingle', params: { id: data } })) // Manipulate the data retrieved back, if we want to do something with it
            .catch(err => console.log(err))
            
              
            

        },
        updateName() {
            this.property.name = this.propertyName;
        },
        updateStreetAddress() {
            this.Address.streetAddress = this.streetAddress;
        },
        updateCity() {
            this.Address.city = this.city;
        },
        updateState() {
            this.Address.state = this.state;
        }
        ,
        updateZipCode() {
            this.Address.zipCode = this.zipCode;
        },
        updateMaintenanceLimit() {
          if(this.maintenanceLimit.match(/^[0-9]+$/) != null){
                this.property.maintenanceLimit = this.maintenanceLimit;

            }else{
                alert("ONLY NUMBERS ALLOWED!")
            }        
        },
        cancelEdit(){
            this.$router.push({ name: 'property' });
        }
    }
    }

</script>