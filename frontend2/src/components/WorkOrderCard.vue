<template>
<v-card @click="goToWorkOrder()"
      width="400"
      
    >
    <template v-slot:title>
       {{ WorkOrder.title }}
       <v-chip
      class="ma-2"
    >
      {{ WorkOrder.workOrderStatus }}
    </v-chip>
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

    },
    methods :{
      goToWorkOrder(){
        console.log(this.WorkOrder.id)
        this.$router.push({ name: 'WorkOrderView', params: { id: this.WorkOrder.id } })

      }
    }
}



</script>
