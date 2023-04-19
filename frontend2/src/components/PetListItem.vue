<template>
   
    <v-card width="400">
       <template v-slot:subtitle>
         {{pet.name}} | {{ pet.petType }}
       </template>
 
       
       
          
       
       
     </v-card>
    
 
 </template>
 <script>
   export default {
     name: 'PetListItem',
     props:{
       pet: Object
     },
     methods:{
       
     }
   }
 </script>