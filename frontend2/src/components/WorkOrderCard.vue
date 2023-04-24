<template>
<v-card
      width="400"
      
    >
    <template v-slot:title>
       {{ WorkOrder.title }}
      </template>

      <template v-slot:subtitle>
        {{ WorkOrder.description  }}
      </template></v-card>
</template>
<script>
export default{

    name: 'WorkOrderCard',
    props: {
        WorkOrder: Object,
        
        
    }
}



</script>
