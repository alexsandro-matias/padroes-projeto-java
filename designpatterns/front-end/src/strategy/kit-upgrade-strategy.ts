import { Desktop } from '@/entities/desktop';
import { Strategy } from './strategy';
import { DesktopOrder } from '@/entities/desktop-order';
import { HARDWARE_TYPES } from '@/entities/hardware-type';
import { HardwareModel } from '@/entities/hardware-model';

export class KitUpgradeStrategy implements Strategy {
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
                    hardware.type === HARDWARE_TYPES.CPU ||
                    hardware.type === HARDWARE_TYPES.MOTHERBOARD ||
                    hardware.type === HARDWARE_TYPES.RAM
                ) {
                    rawHardware.price = hardware.price * 0.9; // 10% OFF
                }

                discountDesktop.addHardware(new HardwareModel(rawHardware));
            }
        });

        return discountDesktop;
    }
}
