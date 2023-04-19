<template>
   <v-card width="400"  class="ma-3  text-subtitle-2" density="compact">
      <template v-slot:title>
       {{ property.name }}
      </template>

      <template v-slot:subtitle>
        {{property.address.streetAddress}}
      </template>

      <v-card-actions>
        
          <v-btn
              class="text-whitetext-none"
              color="teal-darken-1"
              rounded="xl"
              variant="outlined"
              @click=goToSelectedProperty(property)
              >
            
              View
            </v-btn>  
        
        
    </v-card-actions>
    </v-card>
   
   
      
  
  

<router-view/>
</template>
<script>
// import { property } from 'lodash';

 export default {
  name: 'PropertyCard',
  props: {
    property: Object
  },
  methods:{
    goToSelectedProperty(property){
      this.$router.push({ name: 'propertySingle', params: { id: property.id } })
    }
  }
 
}

</script>