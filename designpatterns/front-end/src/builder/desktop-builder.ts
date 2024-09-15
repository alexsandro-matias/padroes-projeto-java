import { Desktop } from '@/entities/desktop';
import { HardwareModel } from '@/entities/hardware-model';
import { Builder } from './builder';

export class DesktopBuilder implements Builder {
    private desktop: Desktop = new Desktop();

    public reset() {
        this.desktop = new Desktop();
    }

    public addCpu(cpu: HardwareModel) {
        this.desktop.setCpu(cpu);
        return this;
    }

    public addMotherboard(motherboard: HardwareModel) {
        this.desktop.setMotherboard(motherboard);
        return this;
    }

    public addRam(ram: HardwareModel) {
        this.desktop.setRam(ram);
        return this;
    }

    public addGpu(gpu: HardwareModel) {
        this.desktop.setGpu(gpu);
        return this;
    }

    public addStorage(storage: HardwareModel) {
        this.desktop.setStorage(storage);
        return this;
    }

    public addPsu(psu: HardwareModel) {
        this.desktop.setPsu(psu);
        return this;
    }

    public addCase(pcCase: HardwareModel) {
        this.desktop.setCase(pcCase);
        return this;
    }

    public getDesktop() {
        return this.desktop;
    }
}
