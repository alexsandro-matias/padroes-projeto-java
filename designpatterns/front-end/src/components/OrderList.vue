<template>
    <v-card width="800" title="Resumo do pedido">
        <template #default>
            <v-container class="pt-0">
                <v-row justify="space-between" align="center">
                    <v-col cols="4" class="mr-auto">
                        <v-select
                            v-model="discount"
                            label="Cupom de desconto"
                            density="compact"
                            variant="outlined"
                            style="height: 40px"
                            :items="discounts"
                            item-title="label"
                            item-value="value"
                        />
                    </v-col>
                    <v-col cols="auto" class="text-right">
                        <p
                            v-if="hasDiscount"
                            class="text-caption text-grey-lighten-1"
                        >
                            De: <s>{{ order.getPrice() }}</s>
                        </p>
                        <p class="text-h6 text-blue-lighten-3">
                            {{ price }}
                        </p>
                    </v-col>
                </v-row>
            </v-container>
            <v-divider />
            <v-list>
                <template
                    v-for="(hardware, index) in order.getHardwareList()"
                    :key="index"
                >
                    <order-item :hardware="hardware" :desktop="desktop" />
                    <v-divider
                        v-if="index < order.getHardwareList().length - 1"
                        inset
                    />
                </template>
            </v-list>
        </template>
    </v-card>
</template>

<script setup lang="ts">
    import { computed, ref, watch } from 'vue';
    import { DesktopOrder } from '@/entities/desktop-order';
    import { DISCOUNTS } from '@/entities/discounts';
    import { Desktop } from '@/entities/desktop';
    import { KitUpgradeStrategy } from '@/strategy/kit-upgrade-strategy';
    import { AmdStrategy } from '@/strategy/amd-strategy';
    import { GigabyteAsusStrategy } from '@/strategy/gigabyte-asus-strategy';
    import { CorsairStrategy } from '@/strategy/corsair-strategy';
    import { ProgressiveStrategy } from '@/strategy/progressive-strategy';
    import OrderItem from './OrderItem.vue';

    interface Props {
        order: Readonly<DesktopOrder>;
    }

    const discounts = [
        {
            value: DISCOUNTS.CPU_MOTHERBOARD_RAM_10_OFF,
            label: '10% OFF em processador, placa-mãe e memória',
        },
        {
            value: DISCOUNTS.CPU_GPU_AMD_20_OFF,
            label: '20% OFF em processador e placa de vídeo AMD',
        },
        {
            value: DISCOUNTS.GIGABYTE_ASUS_15_OFF,
            label: '15% OFF nas marcas Gigabyte e Asus',
        },
        {
            value: DISCOUNTS.CORSAIR_10_OFF,
            label: '10% OFF na marca Corsair',
        },
        {
            value: DISCOUNTS.PROGRESSIVE,
            label: 'Desconto progressivo',
        },
    ];

    const props = defineProps<Props>();

    const discount = ref<DISCOUNTS>();
    const desktop = ref<Desktop>(props.order.applyDiscountStrategy());

    const hasDiscount = computed(() => {
        return (
            props.order.getDesktop().getTotalPrice() >
            desktop.value.getTotalPrice()
        );
    });

    const price = computed(() => {
        if (hasDiscount.value) {
            return `Por: ${desktop.value.getPriceFormatted()}`;
        }

        return props.order.getPrice();
    });

    watch(discount, () => {
        switch (discount.value) {
            case DISCOUNTS.CPU_MOTHERBOARD_RAM_10_OFF:
                props.order.setDiscountStrategy(new KitUpgradeStrategy());
                break;
            case DISCOUNTS.CPU_GPU_AMD_20_OFF:
                props.order.setDiscountStrategy(new AmdStrategy());
                break;
            case DISCOUNTS.GIGABYTE_ASUS_15_OFF:
                props.order.setDiscountStrategy(new GigabyteAsusStrategy());
                break;
            case DISCOUNTS.CORSAIR_10_OFF:
                props.order.setDiscountStrategy(new CorsairStrategy());
                break;
            case DISCOUNTS.PROGRESSIVE:
                props.order.setDiscountStrategy(new ProgressiveStrategy());
                break;
        }

        desktop.value = props.order.applyDiscountStrategy();
    });
</script>
