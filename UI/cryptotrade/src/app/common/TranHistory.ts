export class TranHistory {
    coinName: string;
    paymentDate: Date;
    amount: number;
    deposit: boolean;

    constructor(coinName: string, paymentDate: any, amount: any, deposit: any) {
        this.coinName = coinName;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.deposit = deposit;
    }
}
