<template>
   
   <v-card width="400">
      <template v-slot:title>
        {{tenant.firstName}} {{ tenant.lastName }}
      </template>

      <template v-slot:subtitle>
       <span>{{ tenant.phoneNumber}} </span> &nbsp;
       <span>{{ tenant.email}}</span> 
      </template>
      <div>
        <v-btn
            class="text-whitetext-none"
            color="teal-lighten-1"
            rounded="0"
            prepend-icon="mdi-phone"
            @click=showContactInfo()
            >
          
            Contact
          </v-btn> 
          <v-btn
            class="text-whitetext-none"
            color="teal-lighten-1"
            rounded="0"
            
            @click=goToSelectedTenant()
            >
          
            View
          </v-btn>
        </div>
         
      
      
    </v-card>
   

</template>
<script>
  export default {
    name: 'TenantListItem',
    props:{
      tenant: Object
    },
    methods:{
      showContactInfo(){
        alert(this.tenant.phoneNumber)
      },
      goToSelectedTenant(){
        this.$router.push({ name: 'tenantView', params: { id: this.tenant.id } })
      }
    }
  }
</script>