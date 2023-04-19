<template>
    <div v-if="!editMode" style="padding: 1.5%;">
       <div class="text-h4">
        Tenant Information
        
       </div> 
       <v-btn
              class="text-whitetext-none"
              color="teal-darken-1"
              rounded="xl"
              variant="outlined"
              @click=editTenant()
              >
            
              Edit
            </v-btn>
       <div class="text-subtitle-1">
        {{ tenant.firstName }} {{ tenant.lastName }}
       </div>
       <div class="text-subtitle-1">
        Phone Number: {{ tenant.phoneNumber }}
       </div>
       <div class="text-subtitle-1">
        Email: {{ tenant.email }}
       </div>
    </div>

    <div v-if="editMode" style="padding: 1.5%;">
       <div class="text-h4">
        Tenant Information Edit
       </div> 
       <div>
        <v-btn
              class="text-whitetext-none"
              color="teal-darken-1"
              rounded="xl"
              variant="outlined"
              @click=saveTenant()
              >
            
              Save
            </v-btn>
            <v-btn
              class="text-whitetext-none"
              color="teal-darken-1"
              rounded="xl"
              variant="outlined"
              @click=cancelEdit()
              >
            
              Cancel
            </v-btn>
       </div>
       <div class="text-subtitle-1">
        <v-text-field v-model="tenant.firstName" v-if="tenant" label="First Name" :model-value=tenant.firstName
        ></v-text-field>
       </div>
       <div class="text-subtitle-1">
        <v-text-field v-model="tenant.lastName" v-if="tenant" label="Last Name" :model-value=tenant.lastName
        ></v-text-field>

       </div>
       <div class="text-subtitle-1">
        <v-text-field v-model="tenant.phoneNumber" v-if="tenant" label="Phone Number" :model-value=tenant.phoneNumber
        ></v-text-field>
       </div>
       <div class="text-subtitle-1">
        <v-text-field v-model="tenant.email" v-if="tenant" label="Email Address" :model-value=tenant.email ></v-text-field>
       </div>
    </div>
</template>
<script>
import { toHandlers } from 'vue';



export default {
    name: "TenantView",
    data() {
        return {
            tenant: [],
            editMode : false,
            firstName : '',
            lastName : '',
            email: '',
            phoneNumber : ''
        };
    },
    mounted() {
        fetch("http://localhost:8080/tenant/" + this.$route.params.id + "/")
            .then((res => res.json()))
            .then(data => this.tenant = data)
            .catch(err => console.log(err.message));
    },
    methods: {
        editTenant(){
            this.firstName = this.tenant.firstName;
            this.lastName = this.tenant.lastName;
            this.phoneNumber = this.tenant.phoneNumber;
            this.email = this.tenant.email;
            this.editMode = true;
        },
        cancelEdit(){
            this.tenant.firstName = this.firstName;
            this.tenant.lastName = this.lastName;
            this.tenant.phoneNumber = this.phoneNumber;
            this.tenant.email = this.email;
            this.editMode = false;
        },
        saveTenant(){
            const requestOptions = {
                method: 'PUT',
                 headers: {'Accept': 'application/json', 'Content-Type': 'application/json' },
                body: JSON.stringify(this.tenant)
            };
           
             fetch("http://localhost:8080/tenant/" + this.tenant.id + "/", requestOptions)
             .then(response => response.json())
            .then(data => console.log("goo" + data)) // Manipulate the data retrieved back, if we want to do something with it
            .catch(err => console.log(err))
              this.editMode = false 
        }
    }
}

</script>