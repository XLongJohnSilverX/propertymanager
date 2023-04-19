<template>
  <v-card
    class="mx-auto"
    width="250px"
    prepend-icon="mdi-home"
    
  >
    <template v-slot:title>
      {{unit.unitIdentifier}}
    </template>

 
      <span v-for="tenant in unit.tenantList" class="d-flex flex-wrap">
        {{tenant.firstName}} {{ tenant.lastName }}
      </span>
    
    <v-card-actions>
        
        <v-btn
            class="text-whitetext-none"
            color="teal-lighten-1"
            rounded="0"
            
            @click=goToSelectedUnit(unit)
            >
          
            View
          </v-btn> 
          </v-card-actions> 
  </v-card>
</template>
<script>
// import { property } from 'lodash';

 export default {
  name: 'UnitCard',
  props:{
    unit: Object
  },
  methods:{
    
        goToSelectedUnit(){
            this.$router.push({ name: 'unitSingle', params: { id: this.unit.id } })
        }
  }
 
}


</script>
