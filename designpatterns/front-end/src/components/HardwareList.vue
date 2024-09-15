<template>
    <v-container>
        <v-row>
            <template v-if="loading">
                <v-col cols="12" md="6">
                    <hardware-skeleton />
                </v-col>
            </template>
            <template v-else-if="items.length === 0">
                <v-col cols="12">
                    <v-alert
                        title="Nenhuma peça encontrada."
                        color="grey-darken-2"
                        variant="outlined"
                    />
                </v-col>
            </template>
            <template v-else>
                <v-col v-for="item in items" :key="item.id" cols="12" md="6">
                    <hardware-item
                        :hardware="item"
                        @on-select="selectHardware"
                    />
                </v-col>
            </template>
        </v-row>
    </v-container>
</template>

<script setup lang="ts">
    import { onMounted, reactive, ref } from 'vue';
    import { AxiosHttpClient } from '@/adapter/axios-http-client';
    import { RemoteHardware } from '@/service/remote-hardware';
    import { Builder } from '@/builder/builder';
    import { StrategyFactory } from '@/factory/strategy-factory';
    import { HARDWARE_TYPES } from '@/entities/hardware-type';
    import { HardwareModel } from '@/entities/hardware-model';
    import HardwareItem from './HardwareItem.vue';
    import HardwareSkeleton from './HardwareSkeleton.vue';

    interface Emits {
        (e: 'on-select', value: HardwareModel): void;
    }

    interface Props {
        type: HARDWARE_TYPES;
        builder: Builder;
    }

    const emits = defineEmits<Emits>();
    const props = defineProps<Props>();

    const items = ref<HardwareModel[]>([]);
    const loading = ref(false);
    const error = reactive({
        show: false,
        message: '',
    });

    function selectHardware(id: number) {
        const hardware = items.value.find((item) => item.id === id);
        emits('on-select', hardware as HardwareModel);
    }

    onMounted(async () => {
        const httpClient = new AxiosHttpClient();
        const factory = new StrategyFactory(props.builder);
        const strategy = factory.create(props.type);
        const service = new RemoteHardware(httpClient, strategy);

        try {
            items.value = await service.loadAll();
        } catch (err) {
            error.message = (err as Error).message;
            error.show = true;
        }
    });
</script>
