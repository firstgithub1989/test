import { TranHistory } from './TranHistory';
import { BuySellDetials } from './BuySellDetails';

export interface IBuySellHistory {
    data: BuySellDetials[];
    total: number;
}
