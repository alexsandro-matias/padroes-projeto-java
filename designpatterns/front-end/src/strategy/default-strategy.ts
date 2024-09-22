import { Desktop } from '@/entities/desktop';
import { DesktopOrder } from '@/entities/desktop-order';
import { Strategy } from './strategy';

export class DefaultStrategy implements Strategy {
    calculate(order: DesktopOrder): Desktop {
        return order.getDesktop();
    }
}
