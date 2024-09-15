import { Desktop } from '@/entities/desktop';
import { Hardware } from '@/entities/hardware';
import { HARDWARE_TYPES } from '@/entities/hardware-type';
import { Strategy } from './strategy';
import { MANUFACTURERS } from '@/entities/manufacurers';

export class MotherboardStrategy implements Strategy {
    constructor(private readonly desktop: Desktop) {}

    public filter(items: Hardware[]): Hardware[] {
        const manufacturer = this.desktop.getCpu()?.manufacturer;

        if (
            manufacturer !== MANUFACTURERS.INTEL &&
            manufacturer !== MANUFACTURERS.AMD
        ) {
            throw new Error('Invalid CPU manufacturer');
        }

        const chipsets = {
            [MANUFACTURERS.INTEL]: ['LGA1700', 'LGA 1700'],
            [MANUFACTURERS.AMD]: ['AM5'],
        };

        const chipset = chipsets[manufacturer];

        return items.filter((item) => {
            return (
                item.type === HARDWARE_TYPES.MOTHERBOARD &&
                chipset?.some((c) => item.title.includes(c))
            );
        });
    }
}
