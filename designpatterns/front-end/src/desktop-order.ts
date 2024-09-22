import { State } from './state/state';
import { Desktop } from './entities/desktop';
import { HardwareModel } from './entities/hardware-model';
import { CpuState } from './state/cpu-state';
import { HARDWARE_TYPES } from './entities/hardware-type';

export class DesktopOrder {
    private state: State;
    private desktop: Desktop;

    constructor() {
        this.state = new CpuState(this);
        this.desktop = new Desktop();
    }

    // Manipulação do computador

    public getDesktop(): Desktop {
        return this.desktop;
    }

    public getHardware(type: HARDWARE_TYPES): HardwareModel | undefined {
        return this.desktop.toObject()[type];
    }

    public addHardware(hardware: HardwareModel): Desktop {
        this.desktop.addHardware(hardware);
        return this.desktop;
    }

    public getPrice(): string {
        const { format } = Intl.NumberFormat('pt-BR', {
            style: 'currency',
            currency: 'BRL',
        });

        const totalPrice = this.desktop.toList().reduce((acc, hardware) => {
            if (hardware !== undefined) {
                acc += hardware.price;
            }

            return acc;
        }, 0);

        return format(totalPrice / 100);
    }

    // Manipulações de estado

    public async fetchHardware(): Promise<HardwareModel[]> {
        await this.state.fetchHardware();
        return this.state.getHardwareList();
    }

    public setState(state: State): void {
        this.state = state;
    }

    public nextState(): HARDWARE_TYPES {
        this.state.nextState();
        return this.getCurrentStatus();
    }

    public prevState(): HARDWARE_TYPES {
        this.state.prevState();
        return this.getCurrentStatus();
    }

    public getCurrentStatus(): HARDWARE_TYPES {
        return this.state.getStatus();
    }
}
