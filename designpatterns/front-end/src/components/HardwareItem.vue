<template>
    <v-card color="grey-darken-3">
        <div class="d-flex">
            <v-avatar rounded="0" class="flex-0-0" size="125">
                <v-img :src="hardware.image" />
            </v-avatar>
            <div class="flex-fill">
                <v-card-text
                    class="text-grey-lighten-1"
                    style="
                        height: 72px;
                        display: -webkit-box;
                        -webkit-box-orient: vertical;
                        overflow: hidden;
                        line-clamp: 2;
                    "
                    >{{ hardware.title }}</v-card-text
                >
                <v-card-actions class="justify-space-between">
                    <p class="text-h6 font-weight-medium pl-2">
                        {{ hardware.priceFormatted }}
                    </p>
                    <v-btn
                        class="ms-2"
                        size="small"
                        variant="outlined"
                        color="primary"
                        @click="$emit('on-select', hardware.id)"
                        >Escolher</v-btn
                    >
                </v-card-actions>
            </div>
        </div>
    </v-card>
</template>

<script setup lang="ts">
    import { HardwareModel } from '@/entities/hardware-model';

    type Emits = {
        (e: 'on-select', value: number): void;
    };

    type Props = {
        hardware: HardwareModel;
    };

    defineEmits<Emits>();
    defineProps<Props>();
</script>
