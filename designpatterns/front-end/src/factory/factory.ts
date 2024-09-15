import { HARDWARE_TYPES } from "@/entities/hardware-type";
import { Strategy } from "@/strategy/strategy";

export abstract class Factory {
    abstract create(type: HARDWARE_TYPES): Strategy;
}