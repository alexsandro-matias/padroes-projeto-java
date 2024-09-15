import { Hardware } from '@/entities/hardware';
import { HARDWARE_TYPES } from '@/entities/hardware-type';
import { Desktop } from '@/entities/desktop';
import { Strategy } from './strategy';

[
    '350W',
    '400W',
    '650W',
    '750W',
    '850W',
    '600W',
    '1200W',
    '500W',
    '1000W',
    '800W',
    '550W',
];
['RX 7900', 'RTX 4060', 'RX 7600', 'RX 7700', 'X 7800', 'RTX 4070', 'RX 7900'];

export class PsuStrategy implements Strategy {
    private psuExcludes: { [key: string]: string[] } = {
        '4060': ['350W', '400W'],
        '7600': ['350W', '400W'],
        '4070': ['350W', '400W', '500W', '550W'],
        '7700': ['350W', '400W', '500W', '550W'],
        '7800': ['350W', '400W', '500W', '550W', '600W', '650W'],
        '7900': [
            '350W',
            '400W',
            '500W',
            '550W',
            '600W',
            '650W',
            '800W',
            '850W',
        ],
    };

    constructor(private readonly desktop: Desktop) {}

    filter(items: Hardware[]): Hardware[] {
        const desktopGpu = this.desktop.getGpu();

        if (!desktopGpu) {
            return items.filter((item) => item.type === HARDWARE_TYPES.PSU);
        }

        const gpuVersion = Object.keys(this.psuExcludes).find((gpu) =>
            desktopGpu.title.includes(gpu),
        );
        const excludes = gpuVersion ? this.psuExcludes[gpuVersion] : [];

        return items.filter((item) => {
            if (item.type !== HARDWARE_TYPES.PSU) {
                return false;
            }

            return !excludes.some((exclude) => item.title.includes(exclude));
        });
    }
}
