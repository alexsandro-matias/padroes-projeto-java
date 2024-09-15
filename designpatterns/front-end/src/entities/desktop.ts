import { HardwareModel } from './hardware-model';
import { HARDWARE_TYPES } from './hardware-type';

export class Desktop {
    private cpu?: HardwareModel;
    private motherboard?: HardwareModel;
    private ram?: HardwareModel;
    private gpu?: HardwareModel;
    private storage?: HardwareModel;
    private psu?: HardwareModel;
    private case?: HardwareModel;

    public getCpu = () => this.cpu;
    public getMotherboard = () => this.motherboard;
    public getRam = () => this.ram;
    public getGpu = () => this.gpu;
    public getStorage = () => this.storage;
    public getPsu = () => this.psu;
    public getCase = () => this.case;

    public getPrice = () =>
        this.components().reduce((acc, component) => {
            acc += component?.price || 0;
            return acc;
        }, 0);

    public setCpu(cpu: HardwareModel) {
        if (cpu.type !== HARDWARE_TYPES.CPU) {
            throw new Error('Invalid hardware type');
        }

        this.cpu = cpu;
    }

    public setMotherboard(motherboard: HardwareModel) {
        if (motherboard.type !== HARDWARE_TYPES.MOTHERBOARD) {
            throw new Error('Invalid hardware type');
        }

        this.motherboard = motherboard;
    }

    public setRam(ram: HardwareModel) {
        if (ram.type !== HARDWARE_TYPES.RAM) {
            throw new Error('Invalid hardware type');
        }

        this.ram = ram;
    }

    public setGpu(gpu: HardwareModel) {
        if (gpu.type !== HARDWARE_TYPES.GPU) {
            throw new Error('Invalid hardware type');
        }

        this.gpu = gpu;
    }

    public setStorage(storage: HardwareModel) {
        if (storage.type !== HARDWARE_TYPES.STORAGE) {
            throw new Error('Invalid hardware type');
        }

        this.storage = storage;
    }

    public setPsu(psu: HardwareModel) {
        if (psu.type !== HARDWARE_TYPES.PSU) {
            throw new Error('Invalid hardware type');
        }

        this.psu = psu;
    }

    public setCase(caseHardware: HardwareModel) {
        if (caseHardware.type !== HARDWARE_TYPES.CASE) {
            throw new Error('Invalid hardware type');
        }

        this.case = caseHardware;
    }

    public getPriceFormatted = () => {
        const { format } = new Intl.NumberFormat('pt-BR', {
            style: 'currency',
            currency: 'BRL',
        });

        return format(this.getPrice() / 100);
    };

    public isMounted() {
        return this.components().every((component) => component !== undefined);
    }

    private components = (): (HardwareModel | undefined)[] => [
        this.cpu,
        this.motherboard,
        this.ram,
        this.gpu,
        this.storage,
        this.psu,
        this.case,
    ];
}
