import { Hardware } from '@/entities/hardware';
import { HARDWARE_TYPES } from '@/entities/hardware-type';
import { Strategy } from './strategy';

export class GpuStrategy implements Strategy {
    filter(items: Hardware[]): Hardware[] {
        return items.filter((item) => item.type === HARDWARE_TYPES.CPU);
    }
}