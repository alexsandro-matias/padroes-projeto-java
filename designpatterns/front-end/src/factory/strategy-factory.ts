import { HARDWARE_TYPES } from "@/entities/hardware-type";
import { Strategy } from "@/strategy/strategy";
import { Factory } from "./factory";
import { CpuStrategy } from "@/strategy/cpu-strategy";
import { MotherboardStrategy } from "@/strategy/motherboard-strategy";
import { Builder } from "@/builder/builder";
import { RamStrategy } from "@/strategy/ram-strategy";
import { GpuStrategy } from "@/strategy/gpu-strategy";
import { StorageStrategy } from "@/strategy/storage-strategy";
import { PsuStrategy } from "@/strategy/psu-strategy";
import { CaseStrategy } from "@/strategy/case-strategy";

export class StrategyFactory extends Factory {
    private builder: Builder;

    constructor(builder: Builder) {
        super();
        this.builder = builder;
    }

    create(type: HARDWARE_TYPES): Strategy {
        const desktop = this.builder.getDesktop()
        const strategies = {
            [HARDWARE_TYPES.CPU]: new CpuStrategy(),
            [HARDWARE_TYPES.MOTHERBOARD]: new MotherboardStrategy(desktop),
            [HARDWARE_TYPES.RAM]: new RamStrategy(desktop),
            [HARDWARE_TYPES.GPU]: new GpuStrategy(),
            [HARDWARE_TYPES.STORAGE]: new StorageStrategy(),
            [HARDWARE_TYPES.PSU]: new PsuStrategy(desktop),
            [HARDWARE_TYPES.CASE]: new CaseStrategy()
        }

        return strategies[type];
    }
}