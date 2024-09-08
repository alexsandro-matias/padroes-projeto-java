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
                    <hardware-item :hardware="item" />
                </v-col>
            </template>
        </v-row>
    </v-container>
</template>

<script setup lang="ts">
    import { onMounted, reactive, ref } from 'vue';
    import { AxiosHttpClient } from '@/adapter/axios-http-client';
    import { HARDWARE_TYPES } from '@/enum';
    import { HardwareModel } from '@/model/hardware-model';
    import { RemoteHardware } from '@/service/remote-hardware';
    import HardwareItem from './HardwareItem.vue';
    import HardwareSkeleton from './HardwareSkeleton.vue';

    type Props = {
        type: HARDWARE_TYPES;
    };

    const props = defineProps<Props>();

    const items = ref<HardwareModel[]>([]);
    const loading = ref(false);
    const error = reactive({
        show: false,
        message: '',
    });

    onMounted(async () => {
        const httpClient = new AxiosHttpClient();
        const service = new RemoteHardware(httpClient);

        try {
            items.value = await service.loadAll(props.type);
        } catch (err) {
            error.message = (err as Error).message;
            error.show = true;
        }
    });
</script>
