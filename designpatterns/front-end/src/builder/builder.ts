import { Desktop } from '@/entities/desktop';
import { HardwareModel } from '@/entities/hardware-model';

export interface Builder {
    addCpu(item: HardwareModel): Builder;
    addMotherboard(item: HardwareModel): Builder;
    addRam(item: HardwareModel): Builder;
    addGpu(item: HardwareModel): Builder;
    addStorage(item: HardwareModel): Builder;
    addPsu(item: HardwareModel): Builder;
    addCase(item: HardwareModel): Builder;

    getDesktop(): Desktop;
}
