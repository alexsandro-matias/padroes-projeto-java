<template>
  <v-app>
    <v-main>
      <v-toolbar title="Monte seu PC"/>
      <v-stepper v-model="etapa" alt-labels>
        <v-stepper-header>
          <v-stepper-item
            v-for="e in etapas"
            :key="e.value"
            :title="e.title"
            :value="e.value"
            color="primary"
            icon="mdi-check"
          />
        </v-stepper-header>
        <v-stepper-window >
          <v-stepper-window-item style="height: calc(100vh - 268px)" v-for="e in etapas" :key="e.value" :value="e.value">
            <peca-lista :title="e.title" :step="e.value"/>
          </v-stepper-window-item>
        </v-stepper-window>
        <v-stepper-actions>
          <template #prev>
            <v-btn variant="outlined" @click="prev" :disabled="isStart">Voltar</v-btn>
          </template>
          <template #next>
            <v-btn variant="elevated" color="primary" @click="next" :disabled="isEnd">Avançar</v-btn>
          </template>
        </v-stepper-actions>
      </v-stepper>
    </v-main>
  </v-app>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import PecaLista from './components/PecaLista.vue';
import { ETAPAS } from './enum'
import { Etapa } from './types'

const etapas: Etapa[] = [
  { value: ETAPAS.PROCESSADOR, title: 'Processador' },
  { value: ETAPAS.PLACA_MAE, title: 'Placa-mãe' },
  { value: ETAPAS.MEMORIA, title: 'Memória' },
  { value: ETAPAS.PLACA_VIDEO, title: 'Placa de vídeo' },
  { value: ETAPAS.ARMAZENAMENTO, title: 'Armazenamento' },
  { value: ETAPAS.GABINETE, title: 'Gabinete' },
]

const etapa = ref(ETAPAS.PROCESSADOR);
const etapaIndex = computed(() => etapas.findIndex(e => e.value === etapa.value))
const isEnd = computed(() => etapaIndex.value === etapas.length - 1)
const isStart = computed(() => etapaIndex.value === 0)

function next() {
  if (isEnd.value) {
    return;
  }

  etapa.value = etapas[etapaIndex.value + 1].value;
}

function prev() {
  if (isStart.value) {
    return;
  }

  etapa.value = etapas[etapaIndex.value - 1].value;
}
</script>
