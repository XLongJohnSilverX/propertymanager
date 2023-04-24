<template>
  <v-card>
    <v-layout>
      <v-navigation-drawer permanent color="teal-lighten-2"
        >
        <v-app-bar-title > <v-icon icon="mdi-domain"></v-icon> Appfolio++ </v-app-bar-title>
        <v-list>
          <v-list-item prepend-avatar="https://media.licdn.com/dms/image/C5603AQF0zo94cmtOVQ/profile-displayphoto-shrink_100_100/0/1658019243483?e=1686787200&v=beta&t=r4ZEW0IvCOoWxpLfEXEEBbZQjCDEOQiDqK8HUbRMYB8" title="Jason Della Penna"
            subtitle="delpenjason@gmailcom"></v-list-item>
        </v-list>

        <v-divider></v-divider>

        <v-list density="compact" nav>
          <router-link style="text-decoration: none; color: inherit;" to="/property"> 
          <v-list-item prepend-icon="mdi-domain" title="Properties"
              value="myfiles" active-color="teal-accent-1"></v-list-item>
              </router-link>
              <router-link style="text-decoration: none; color: inherit;" to="/workorder"> 
          <v-list-item prepend-icon="mdi-account-multiple" title="Work Orders" value="shared"></v-list-item>
        </router-link>
          <v-list-item prepend-icon="mdi-star" title="Messages" value="starred"></v-list-item>
        </v-list>
      </v-navigation-drawer>

      <v-main></v-main>
    </v-layout>
  </v-card>
</template>

<script>
export default {
  name: 'NavBar',
  data: () => ({
    tab: null,
  }),
}
</script>
  
<style>
.flex-grow {
  flex-grow: 1;
}
</style>
  