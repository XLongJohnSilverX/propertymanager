<template>

  
       {{ workOrder.title }}
   

      {{ workOrder.workOrderStatus }}
 

        {{ workOrder.description  }}


</template>
<script>
export default {
  name: 'WorkOrderView',
  data() {
        return {
            workOrder: Object,
            editMode: false,

        }
    },
    mounted() {
        fetch("http://localhost:8080/workorder/" + this.$route.params.id + "/")
            .then((res => res.json()))
            .then(data => this.workOrder = data)
            .catch(err => console.log(err.message));
    }
}
</script>