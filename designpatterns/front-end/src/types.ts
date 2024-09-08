import { HARDWARE_TYPES } from './enum';

export type Etapa = {
    value: HARDWARE_TYPES;
    title: string;
};

export type Hardware = {
    id: number;
    name: string;
    description: string;
    price: number;
    image: string;
};
