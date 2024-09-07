<template>
  <v-container>
    
  </v-container>
</template>

<script setup lang="ts">
  import { ETAPAS } from './../enum'
  type Props = {
    title: string;
    step: ETAPAS
  }

  defineProps<Props>();
</script>