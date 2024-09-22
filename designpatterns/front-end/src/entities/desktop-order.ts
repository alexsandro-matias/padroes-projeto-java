import { State } from '@/state/state';
import { Desktop } from './desktop';
import { CpuState } from '@/state/cpu-state';
import { HardwareModel } from './hardware-model';
import { HARDWARE_TYPES } from './hardware-type';
import { Strategy } from '@/strategy/strategy';
import { DefaultStrategy } from '@/strategy/default-strategy';

export class DesktopOrder {
    private state: State;
    private desktop: Desktop;
    private discountStrategy: Strategy;

    constructor() {
        this.state = new CpuState(this);
        this.desktop = new Desktop();
        this.discountStrategy = new DefaultStrategy();
    }

    // Manipulação da estratégias de desconto

    public setDiscountStrategy(strategy: Strategy): void {
        this.discountStrategy = strategy;
    }

    public applyDiscountStrategy(): Desktop {
        return this.discountStrategy.calculate(this);
    }

    // Manipulação do computador

    public getDesktop(): Desktop {
        return this.desktop;
    }

    public getHardware(type: HARDWARE_TYPES): HardwareModel | undefined {
        return this.desktop.toObject()[type];
    }

    public getHardwareList(): HardwareModel[] {
        return this.desktop
            .toList()
            .filter((hardware) => hardware !== undefined);
    }

    public addHardware(hardware: HardwareModel): Desktop {
        this.desktop.addHardware(hardware);
        return this.desktop;
    }

    public getPrice(): string {
        return this.desktop.getPriceFormatted();
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

    public isFinalState(): boolean {
        return this.getCurrentStatus() === HARDWARE_TYPES.CASE;
    }
}
