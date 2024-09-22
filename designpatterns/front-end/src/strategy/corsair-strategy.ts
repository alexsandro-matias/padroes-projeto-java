import { Desktop } from '@/entities/desktop';
import { DesktopOrder } from '@/entities/desktop-order';
import { Strategy } from './strategy';
import { HardwareModel } from '@/entities/hardware-model';
import { MANUFACTURERS } from '@/entities/manufacurers';

export class CorsairStrategy implements Strategy {
    calculate(order: DesktopOrder): Desktop {
        const desktop = order.getDesktop();
        const discountDesktop = new Desktop();

        desktop.toList().forEach((hardware) => {
            if (hardware !== undefined) {
                const rawHardware = {
                    type: hardware.type,
                    title: hardware.title,
                    id: hardware.id,
                    image: hardware.image,
                    manufacturer: hardware.manufacturer,
                    price: hardware.price,
                };

                if (hardware.manufacturer === MANUFACTURERS.CORSAIR) {
                    rawHardware.price = hardware.price * 0.9; // 10% OFF
                }

                discountDesktop.addHardware(new HardwareModel(rawHardware));
            }
        });

        return discountDesktop;
    }
}
