import { DISCOUNTS } from '@/entities/discounts';
import { DefaultStrategy } from '@/strategy/default-strategy';
import { Strategy } from '@/strategy/strategy';

export abstract class StrategyFactory {
    protected strategy: Strategy = new DefaultStrategy();

    public getStrategy(): Strategy {
        return this.strategy;
    }

    abstract create(type: DISCOUNTS): void;
}
