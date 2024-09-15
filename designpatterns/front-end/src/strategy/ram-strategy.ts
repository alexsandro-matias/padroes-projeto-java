import { Hardware } from '@/entities/hardware';
import { Desktop } from '@/entities/desktop';
import { Strategy } from './strategy';
import { MANUFACTURERS } from '@/entities/manufacurers';
import { HARDWARE_TYPES } from '@/entities/hardware-type';

export class RamStrategy implements Strategy {
    private chipsets = [
        'B760M-A',
        'B760-Plus',
        'B760M-Plus',
        'B760',
        'B760M',
        'H610',
        'Z790-A',
    ];

    constructor(private readonly desktop: Desktop) {}

    filter(items: Hardware[]): Hardware[] {
        let type: string = '';

        if (this.desktop.getCpu()?.manufacturer === MANUFACTURERS.AMD) {
            type = 'DDR5';
        }

        if (this.desktop.getCpu()?.manufacturer === MANUFACTURERS.INTEL) {
            const mb = this.desktop.getMotherboard();

            const isDdr4 = this.chipsets.some((chipset) => {
                if (chipset === 'B760M' || chipset === 'Z790-A') {
                    return (
                        mb?.title.includes(chipset) &&
                        !mb?.title.includes('DDR5')
                    );
                }

                return mb?.title.includes(chipset);
            });

            type = isDdr4 ? 'DDR4' : 'DDR5';
        }

        return items.filter((item) => {
            return (
                item.type === HARDWARE_TYPES.RAM && item.title.includes(type)
            );
        });
    }
}
