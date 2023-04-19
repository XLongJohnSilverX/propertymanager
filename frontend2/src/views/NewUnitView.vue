<template>
    <div style="padding: 1.5%;" >
        <v-btn class="text-whitetext-none" color="teal-darken-1" rounded="xl" variant="outlined" @click=saveUnit()>

            Save
        </v-btn>
        
        <div class="flex-row">
            <v-text-field v-model="unitIdentifier"  label="Unit Identifier" 
              variant="outlined"></v-text-field>
            <v-switch v-model="isVacant" color="teal-lighten-2" inset label="Vacant?"></v-switch>
            <v-switch v-model="allowsPets" color="teal-lighten-2" inset label="Allows Pets?"></v-switch>
            <v-text-field v-model="numberOfBeds"  label="Bedrooms" 
                 variant="outlined"></v-text-field>
            <v-text-field v-model="numberOfBath"  label="Baths" 
                variant="outlined"></v-text-field>
            <v-text-field v-model="squareFeet"  label="Square Feet" 
                variant="outlined"></v-text-field>
            <v-text-field v-model="monthlyRent"  label="Monthly Rent" 
                 variant="outlined"></v-text-field>
            <v-text-field v-model="applicationFee" label="Application Fee" 
                variant="outlined"></v-text-field>
            <v-text-field v-model="securityDeposit"  label="Security Deposit" 
                 variant="outlined"></v-text-field>
            <v-text-field v-model="unitDescription"  label="Description" 
                 variant="outlined"></v-text-field>
            
        </div>
    </div>
</template>
<script>
export default{
    name: 'NewUnitView',
    data(){
        return {
            responseUnit : Object,
            unit : '',
            unitIdentifier : '',
            isVacant : '',
            allowsPets : '',
            numberOfBeds : '',
            numberOfBaths : '',
            squareFeet : '',
            monthlyRent : '',
            applicationFee : '',
            securityDeposit : '',
            unitDescription : ''
        }
    },
    methods:{
        saveUnit(){
            
            this.unit = {id : '',
            unitIdentifier : this.unitIdentifier, 
                isVacant : this.isVacant,
                allowsPets: this.allowsPets,
                numberOfBeds: this.numberOfBeds,
                numberOfBaths: this.numberOfBaths,
                squareFeet: this.squareFeet,
                monthlyRent: this.monthlyRent,
                applicationFee: this.applicationFee,
                securityDeposit: this.securityDeposit,
                unitDescription: this.unitDescription}
            const requestOptions = {
                method: 'POST',
                 headers: {'Accept': 'application/json', 'Content-Type': 'application/json' },
                body: JSON.stringify(this.unit)
            };
           
             fetch("http://localhost:8080/unit/", requestOptions)
             .then(response => response.json())
             .then(data => this.$router.push({ name: 'unitSingle', params: { id: data } }))
            .catch(err => console.log(err))
            
        }
    }
}
</script>