import { Desktop } from '@/app/entities/desktop';
import { DesktopOrder } from '@/app/entities/desktop-order';
import { Strategy } from './strategy';
import { Hardware } from '@/app/entities/hardware';
import { HardwareModel } from '@/app/entities/hardware-model';

export class ProgressiveStrategy implements Strategy {
    calculate(order: DesktopOrder): Desktop {
        const desktop = order.getDesktop();
        const discountDesktop = new Desktop();
        const total = order.getDesktop().getTotalPrice();

        let discount = 1;

        if (total > 5000) {
            discount = 0.9; // 10% OFF
        } else if (total > 7500) {
            discount = 0.8; // 20% OFF
        } else if (total > 10000) {
            discount = 0.7; // 30% OFF
        }

        desktop.toList().forEach((hardware) => {
            if (hardware !== undefined) {
                const rawHardware: Hardware = {
                    type: hardware.type,
                    title: hardware.title,
                    id: hardware.id,
                    image: hardware.image,
                    manufacturer: hardware.manufacturer,
                    price: hardware.price * discount,
                };

                discountDesktop.addHardware(new HardwareModel(rawHardware));
            }
        });

        return discountDesktop;
    }
}
