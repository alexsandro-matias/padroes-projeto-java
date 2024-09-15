import { HTTP_STATUS_CODE } from '@/adapter/enums';
import { HttpGetClient } from '@/adapter/interface';
import { Hardware } from '@/entities/hardware';
import { HardwareModel } from '@/entities/hardware-model';
import { Strategy } from '@/strategy/strategy';

export class RemoteHardware {
    private readonly url: string =
        'http://localhost:3000/database/hardware.json';
    private readonly strategy: Strategy;
    private readonly client: HttpGetClient<Hardware[]>;

    constructor(client: HttpGetClient<Hardware[]>, strategy: Strategy) {
        this.client = client;
        this.strategy = strategy;
    }

    async loadAll(): Promise<HardwareModel[]> {
        const { statusCode, data } = await this.client.get({
            url: this.url,
        });

        if (statusCode !== HTTP_STATUS_CODE.SUCCESS) {
            const error = new Error('Error on load hardware');
            error.name = `${statusCode}`;

            throw error;
        }

        const hardwareList = Array.isArray(data) ? data : [];

        return this.strategy
            .filter(hardwareList)
            .map((hardware) => new HardwareModel(hardware));
    }
}
