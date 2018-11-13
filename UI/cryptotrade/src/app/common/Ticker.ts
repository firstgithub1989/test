export class Ticker {
    currency: string;
    rate: number;
    change: number;
    openDay: number;
    highDay: number;
    lowDay: number;

    constructor(currency: string, rate: number, change: number,
         openDay: number, highDay: number, lowDay: number) {
        this.currency = currency;
        this.rate = rate;
        this.change = change;
        this.openDay = openDay;
        this.lowDay = lowDay;
        this.highDay = highDay;
    }
}
