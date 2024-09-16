<template>
    <v-app>
        <v-main>
            <v-toolbar title="Monte seu PC">
                <template #append>
                    <div class="pr-4">
                        <p class="text-right text-caption text-grey-lighten-1">
                            Valor total
                        </p>
                        <p class="text-right text-h6 text-blue-lighten-3">
                            {{ builder.price }}
                        </p>
                    </div>
                </template>
            </v-toolbar>
            <v-stepper v-model="step" alt-labels>
                <v-stepper-header>
                    <v-stepper-item
                        v-for="e in steps"
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
                        v-for="e in steps"
                        :key="e.value"
                        :value="e.value"
                    >
                        <hardware-list
                            :type="e.value"
                            :builder="builder"
                            @on-select="addHardware"
                        />
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
    import { ref, computed, watch } from 'vue';
    import { DesktopBuilder } from './builder/desktop-builder';
    import { HARDWARE_TYPES } from './entities/hardware-type';
    import { Step } from './entities/step';
    import { HardwareModel } from './entities/hardware-model';
    import HardwareList from './components/HardwareList.vue';

    const builder = new DesktopBuilder();

    const steps: Step[] = [
        { value: HARDWARE_TYPES.CPU, title: 'Processador' },
        { value: HARDWARE_TYPES.MOTHERBOARD, title: 'Placa-mãe' },
        { value: HARDWARE_TYPES.RAM, title: 'Memória' },
        { value: HARDWARE_TYPES.GPU, title: 'Placa de vídeo' },
        { value: HARDWARE_TYPES.STORAGE, title: 'Armazenamento' },
        { value: HARDWARE_TYPES.PSU, title: 'Armazenamento' },
        { value: HARDWARE_TYPES.CASE, title: 'Gabinete' },
    ];

    const step = ref(HARDWARE_TYPES.CPU);
    const disabledNext = ref(true);

    const etapaIndex = computed(() =>
        steps.findIndex((e) => e.value === step.value),
    );
    const isEnd = computed(
        () => disabledNext.value || etapaIndex.value === steps.length - 1,
    );
    const isStart = computed(() => etapaIndex.value === 0);

    function addHardware(hardware: HardwareModel) {
        switch (step.value) {
            case HARDWARE_TYPES.CPU:
                builder.addCpu(hardware);
                break;
            case HARDWARE_TYPES.MOTHERBOARD:
                builder.addMotherboard(hardware);
                break;
            case HARDWARE_TYPES.RAM:
                builder.addRam(hardware);
                break;
            case HARDWARE_TYPES.GPU:
                builder.addGpu(hardware);
                break;
            case HARDWARE_TYPES.STORAGE:
                builder.addStorage(hardware);
                break;
            case HARDWARE_TYPES.PSU:
                builder.addPsu(hardware);
                break;
            case HARDWARE_TYPES.CASE:
                builder.addCase(hardware);
                break;
        }

        disabledNext.value = false;
    }

    function next() {
        if (isEnd.value) {
            return;
        }

        step.value = steps[etapaIndex.value + 1].value;
    }

    function prev() {
        if (isStart.value) {
            return;
        }

        step.value = steps[etapaIndex.value - 1].value;
    }

    watch(step, () => (disabledNext.value = true));
</script>
