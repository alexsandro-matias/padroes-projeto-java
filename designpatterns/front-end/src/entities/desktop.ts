import { HardwareModel } from './hardware-model';
import { HARDWARE_TYPES } from './hardware-type';

export class Desktop {
    private _cpu?: HardwareModel;
    private _motherboard?: HardwareModel;
    private _ram?: HardwareModel;
    private _gpu?: HardwareModel;
    private _storage?: HardwareModel;
    private _psu?: HardwareModel;
    private _case?: HardwareModel;

    public getCpu = () => this._cpu;
    public getMotherboard = () => this._motherboard;
    public getRam = () => this._ram;
    public getGpu = () => this._gpu;
    public getStorage = () => this._storage;
    public getPsu = () => this._psu;
    public getCase = () => this._case;

    public getPrice = () =>
        this.components().reduce((acc, component) => {
            acc += component?.price || 0;
            return acc;
        }, 0);

    public setCpu(cpu: HardwareModel) {
        if (cpu.type !== HARDWARE_TYPES.CPU) {
            throw new Error('Invalid hardware type');
        }

        this._cpu = cpu;
    }

    public setMotherboard(motherboard: HardwareModel) {
        if (motherboard.type !== HARDWARE_TYPES.MOTHERBOARD) {
            throw new Error('Invalid hardware type');
        }

        this._motherboard = motherboard;
    }

    public setRam(ram: HardwareModel) {
        if (ram.type !== HARDWARE_TYPES.RAM) {
            throw new Error('Invalid hardware type');
        }

        this._ram = ram;
    }

    public setGpu(gpu: HardwareModel) {
        if (gpu.type !== HARDWARE_TYPES.GPU) {
            throw new Error('Invalid hardware type');
        }

        this._gpu = gpu;
    }

    public setStorage(storage: HardwareModel) {
        if (storage.type !== HARDWARE_TYPES.STORAGE) {
            throw new Error('Invalid hardware type');
        }

        this._storage = storage;
    }

    public setPsu(psu: HardwareModel) {
        if (psu.type !== HARDWARE_TYPES.PSU) {
            throw new Error('Invalid hardware type');
        }

        this._psu = psu;
    }

    public setCase(caseHardware: HardwareModel) {
        if (caseHardware.type !== HARDWARE_TYPES.CASE) {
            throw new Error('Invalid hardware type');
        }

        this._case = caseHardware;
    }

    public getPriceFormatted = () => {
        const { format } = new Intl.NumberFormat('pt-br', {
            style: 'currency',
            currency: 'pt-br',
        });

        return format(this.getPrice() / 100);
    };

    public isMounted() {
        return this.components().every((component) => component !== undefined);
    }

    private components = (): (HardwareModel | undefined)[] => [
        this._cpu,
        this._motherboard,
        this._ram,
        this._gpu,
        this._storage,
        this._psu,
        this._case,
    ];
}
