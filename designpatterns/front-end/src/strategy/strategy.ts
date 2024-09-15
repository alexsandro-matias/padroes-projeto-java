import { Hardware } from '@/entities/hardware';

export interface Strategy {
    filter(items: Hardware[]): Hardware[];
}
