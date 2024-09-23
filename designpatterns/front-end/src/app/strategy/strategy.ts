import { Desktop } from '@/app/entities/desktop';
import { DesktopOrder } from '@/app/entities/desktop-order';

export interface Strategy {
    calculate(order: DesktopOrder): Desktop;
}
