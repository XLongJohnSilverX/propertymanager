<template>
  
  
  <v-card
    class="mx-auto"
    width="250px"
    prepend-icon="mdi-home"
    
  >
    <template v-slot:title>
      {{unit.unitIdentifier}}
      
      <div class="text-center" justify="center">
    <v-btn
     
      @click="dialog = true"
      density="compact" icon="mdi-pencil" variant="plain"
    >
      
    </v-btn>

    <v-dialog
      v-model="dialog"
      width="auto"
      height="auto"
    >
      <v-card>
        <v-card-text>
        {{ unit.unitIdentifier }}
        </v-card-text>
        <v-card-actions>
          <v-btn color="primary"  @click="removeUnit()">Remove Unit from Property</v-btn>
          <v-btn color="primary"  @click="dialog = false">Edit Unit</v-btn>
          <v-btn color="primary" icon="mdi-close" @click="dialog = false"></v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
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
  data () {
      return {
        dialog: false,
      }
    },
  methods:{
    
        goToSelectedUnit(){
            this.$router.push({ name: 'unitSingle', params: { id: this.unit.id } })
        },
        removeUnit(){
          this.$emit("removeUnit", this.unit.id);
        }
  }
 
}


</script>
