<template>
    <h1>
        Work Orders
        </h1>
<div v-if="WorkOrders" v-for="workorder in WorkOrders" class="d-flex flex-wrap" >
          <WorkOrderCard :WorkOrder="workorder"></WorkOrderCard>
          
        </div>

</template>
<script>
import WorkOrderCard from '@/components/WorkOrderCard.vue';
export default{
    name: 'WorkOrderListView',
    components : {
        WorkOrderCard
    },
    data() {
    return {
      WorkOrders : []
    }
  },
  mounted(){
    fetch("http://localhost:8080/workorder/")
    .then((res => res.json()))
    .then(data => this.WorkOrders = data)
    .catch(err => console.log(err.message))
  }
}

</script>