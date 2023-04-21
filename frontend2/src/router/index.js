import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import PropertyListView from '../views/PropertyListView.vue'
import PropertySingleView from '../views/PropertySingleView.vue'
import EditPropertyView from '../views/EditPropertyView.vue'
import UnitView from '../views/UnitView.vue'
import NewPropertyView from '../views/NewPropertyView.vue'
import TenantView from '../views/TenantView.vue'
import NewUnitView from '../views/NewUnitView.vue'
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
    }
  },
  {
    path: '/property',
    name: 'property',
    component: PropertyListView
  },
  
  {
    path: '/property/:id',
    name: 'propertySingle',
    component: PropertySingleView
  },
  
  {
    path: '/property/:id/edit',
    name: 'propertySingleEdit',
    component: EditPropertyView
  },
  
  {
    path: '/unit/:id',
    name: 'unitSingle',
    component: UnitView
  }
  ,
  
  {
    path: '/property',
    name: 'newProperty',
    component: NewPropertyView
  },
  {
    path: '/tenant/:id',
    name: 'tenantView',
    component: TenantView
  },
  {
    path: '/unit',
    
    name: 'newUnit',
    component: NewUnitView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
