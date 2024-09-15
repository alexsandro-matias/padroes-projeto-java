import { HTTP_STATUS_CODE } from '@/adapter/enums';
import { HttpGetClient } from '@/adapter/interface';
import { HARDWARE_TYPES } from '@/enum';
import { HardwareModel } from '@/model/hardware-model';
import { Hardware } from '@/types';

export class RemoteHardware {
    private readonly url: string =
        'http://localhost:3000/database/hardware.json';

    constructor(private readonly httpClient: HttpGetClient<Hardware[]>) {}

    async loadAll(type: HARDWARE_TYPES): Promise<HardwareModel[]> {
        const { statusCode, data } = await this.httpClient.get({
            url: this.url,
        });

        if (statusCode !== HTTP_STATUS_CODE.SUCCESS) {
            const error = new Error('Error on load hardware');
            error.name = `${statusCode}`;

            throw error;
        }

        const hardwareList = Array.isArray(data) ? data : [];

        return hardwareList.map((hardware) => new HardwareModel(hardware));
    }
}
