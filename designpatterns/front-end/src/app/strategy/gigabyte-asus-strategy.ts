import { DesktopOrder } from '@/app/entities/desktop-order';
import { Strategy } from './strategy';
import { Desktop } from '@/app/entities/desktop';
import { MANUFACTURERS } from '@/app/entities/manufacurers';
import { HardwareModel } from '@/app/entities/hardware-model';

export class GigabyteAsusStrategy implements Strategy {
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

                if (
                    hardware.manufacturer === MANUFACTURERS.GIGABYTE ||
                    hardware.manufacturer === MANUFACTURERS.ASUS
                ) {
                    rawHardware.price = hardware.price * 0.85; // 15% OFF
                }

                discountDesktop.addHardware(new HardwareModel(rawHardware));
            }
        });

        return discountDesktop;
    }
}
