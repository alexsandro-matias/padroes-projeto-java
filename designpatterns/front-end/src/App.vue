<template>
    <v-app>
        <v-main>
            <v-toolbar title="Monte seu PC" />
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
                <v-stepper-window
                    style="height: calc(100vh - 268px); overflow-y: auto"
                >
                    <v-stepper-window-item
                        v-for="e in etapas"
                        :key="e.value"
                        :value="e.value"
                    >
                        <hardware-list :type="e.value" />
                    </v-stepper-window-item>
                </v-stepper-window>
                <v-stepper-actions>
                    <template #prev>
                        <v-btn
                            variant="outlined"
                            @click="prev"
                            :disabled="isStart"
                            >Voltar</v-btn
                        >
                    </template>
                    <template #next>
                        <v-btn
                            variant="elevated"
                            color="primary"
                            @click="next"
                            :disabled="isEnd"
                            >Avançar</v-btn
                        >
                    </template>
                </v-stepper-actions>
            </v-stepper>
        </v-main>
    </v-app>
</template>

<script setup lang="ts">
    import { ref, computed } from 'vue';
    import HardwareList from './components/HardwareList.vue';
    import { HARDWARE_TYPES } from './enum';
    import { Etapa } from './types';

    const etapas: Etapa[] = [
        { value: HARDWARE_TYPES.CPU, title: 'Processador' },
        { value: HARDWARE_TYPES.MOTHERBOARD, title: 'Placa-mãe' },
        { value: HARDWARE_TYPES.RAM, title: 'Memória' },
        { value: HARDWARE_TYPES.GPU, title: 'Placa de vídeo' },
        { value: HARDWARE_TYPES.STORAGE, title: 'Armazenamento' },
        { value: HARDWARE_TYPES.TOWER, title: 'Gabinete' },
    ];

    const etapa = ref(HARDWARE_TYPES.CPU);
    const etapaIndex = computed(() =>
        etapas.findIndex((e) => e.value === etapa.value),
    );
    const isEnd = computed(() => etapaIndex.value === etapas.length - 1);
    const isStart = computed(() => etapaIndex.value === 0);

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
