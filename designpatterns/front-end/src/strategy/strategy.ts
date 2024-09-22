import { Desktop } from '@/entities/desktop';
import { DesktopOrder } from '@/entities/desktop-order';

export interface Strategy {
    calculate(order: DesktopOrder): Desktop;
}
