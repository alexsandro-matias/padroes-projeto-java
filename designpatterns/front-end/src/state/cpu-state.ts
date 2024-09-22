import { HARDWARE_TYPES } from '@/entities/hardware-type';
import { Hardware } from '@/entities/hardware';
import { HardwareModel } from '@/entities/hardware-model';
import { State } from './state';
import { MotherboardState } from './motherboard-state';

export class CpuState extends State {
    protected name = HARDWARE_TYPES.CPU;

    public filter(hardwareList: Hardware[]): void {
        this.hardwareList = hardwareList
            .filter((hardware) => hardware.type === HARDWARE_TYPES.CPU)
            .map((hardware) => new HardwareModel(hardware));
    }

    public nextState(): void {
        this.order.setState(new MotherboardState(this.order));
    }

    public prevState(): void {
        console.log('CpuState: No previous state');
        return;
    }
}
