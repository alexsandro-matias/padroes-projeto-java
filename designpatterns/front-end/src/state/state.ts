import { AxiosHttpClient } from '@/adapter/axios-http-client';
import { Hardware } from '@/entities/hardware';
import { HardwareModel } from '@/entities/hardware-model';
import { HARDWARE_TYPES } from '@/entities/hardware-type';
import { DesktopOrder } from '@/entities/desktop-order';

export abstract class State {
    protected abstract name: HARDWARE_TYPES;
    protected order: DesktopOrder;
    protected hardwareList: HardwareModel[] = [];

    constructor(order: DesktopOrder) {
        this.order = order;
    }

    protected abstract filter(hardwareList: Hardware[]): void;

    public abstract nextState(): void;

    public abstract prevState(): void;

    public async fetchHardware(): Promise<void> {
        const client = new AxiosHttpClient();
        const url = 'http://localhost:3000/database/hardware.json';

        const response = await client.get<Hardware[]>({ url });

        const hardwareList = Array.isArray(response.data) ? response.data : [];

        this.filter(hardwareList);
    }

    public getHardwareList(): HardwareModel[] {
        return this.hardwareList;
    }

    public getStatus(): HARDWARE_TYPES {
        return this.name;
    }
}
