import { Desktop } from '@/entities/desktop';
import { Strategy } from './strategy';
import { DesktopOrder } from '@/entities/desktop-order';
import { HardwareModel } from '@/entities/hardware-model';
import { HARDWARE_TYPES } from '@/entities/hardware-type';
import { MANUFACTURERS } from '@/entities/manufacurers';

export class AmdStrategy implements Strategy {
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

                const isCpu =
                    hardware.type === HARDWARE_TYPES.CPU &&
                    hardware.manufacturer === MANUFACTURERS.AMD;

                const isGpu =
                    hardware.type === HARDWARE_TYPES.GPU &&
                    hardware.title.includes(MANUFACTURERS.AMD);

                if (isCpu || isGpu) {
                    rawHardware.price = hardware.price * 0.8; // 20% OFF
                }

                discountDesktop.addHardware(new HardwareModel(rawHardware));
            }
        });

        return discountDesktop;
    }
}
