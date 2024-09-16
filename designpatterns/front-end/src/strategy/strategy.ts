import { Hardware } from '@/entities/hardware';

/*
Alterar de Strategy para State
Incluir dentro de cada estado ou hardware, as próximas peças que são compatíveis
*/

export interface Strategy {
    filter(items: Hardware[]): Hardware[];
}
