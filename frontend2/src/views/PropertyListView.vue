<template>
  <div class="property" style="padding: 1.5%;">
    
    <div class="text-h3" color="gray">
      Properties
      <v-btn  variant="outlined" @click="newProperty()">
  New Property
</v-btn>
    </div>
    <div v-if="Properties" v-for="property in Properties" class="d-flex flex-wrap" >
          <PropertyCard :property="property" ></PropertyCard>
          
        </div>
  </div>
     
        
        


   
  </template>
  
  <script>

import PropertyCard from "../components/PropertyCard.vue"
  export default {
  name: 'PropertyView',
  components: {
    PropertyCard
  },
  data() {
    return {
      Properties : []
    }
  },
  mounted(){
    fetch("http://localhost:8080/property/")
    .then((res => res.json()))
    .then(data => this.Properties = data)
    .catch(err => console.log(err.message))
  },
  methods:{
    newProperty(){
      this.$router.push({ name: 'newProperty' })
    }
  }
}
  </script>
  
  <style>
  .card-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  
  .text {
    font-size: 14px;
  }
  
  .item {
    margin-bottom: 18px;
  }
  
  .box-card {
    width: 480px;
  }
  </style>