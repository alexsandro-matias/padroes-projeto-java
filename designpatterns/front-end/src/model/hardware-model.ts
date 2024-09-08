import { CURRENCIES } from '@/enum';
import { Hardware } from '@/types';

export class HardwareModel {
    constructor(private readonly hardware: Hardware) {}

    get id(): number {
        return this.hardware.id;
    }

    get name(): string {
        return this.hardware.name;
    }

    get description(): string {
        return this.hardware.description;
    }

    get image(): string {
        return this.hardware.image;
    }

    getPriceCurrency(currency = CURRENCIES['pt-br']): string {
        const { format } = new Intl.NumberFormat(currency, {
            style: 'currency',
            currency,
        });

        return format(this.hardware.price / 100);
    }
}
