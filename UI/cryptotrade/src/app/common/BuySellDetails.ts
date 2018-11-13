export class BuySellDetials {
    public coinName: string;
    public volume: number;
    public rate: number;
    public fromSym: string;
    public purchaseDate: Date;

    constructor(coinName: any,
                volume: any,
                rate: any,
                fromSym: any,
                purchaseDate: any) {
        this.coinName = coinName;
        this.volume = volume;
        this.rate = rate;
        this.fromSym = fromSym;
        this.purchaseDate = purchaseDate;
    }
}
