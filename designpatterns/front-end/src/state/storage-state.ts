import { HARDWARE_TYPES } from '@/entities/hardware-type';
import { Hardware } from '@/entities/hardware';
import { HardwareModel } from '@/entities/hardware-model';
import { State } from './state';
import { GpuState } from './gpu-state';
import { PsuState } from './psu-state';

export class StorageState extends State {
    protected name = HARDWARE_TYPES.STORAGE;

    public filter(hardwareList: Hardware[]): void {
        this.hardwareList = hardwareList
            .filter((hardware) => hardware.type === HARDWARE_TYPES.STORAGE)
            .map((hardware) => new HardwareModel(hardware));
    }

    public nextState(): void {
        this.order.setState(new PsuState(this.order));
    }

    public prevState(): void {
        this.order.setState(new GpuState(this.order));
    }
}
