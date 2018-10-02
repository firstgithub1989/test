import { Component, OnInit } from '@angular/core';
import { CoinwalletService } from '../services/coinwallet.service';

@Component({
  selector: 'app-coinwallet',
  templateUrl: './coinwallet.component.html',
  styleUrls: ['./coinwallet.component.css']
})

export class CoinwalletComponent implements OnInit {

  curOptions: {};
  option: string;
  coinAmount: string;
  message: string;
  amountD: string;
  amountW: string;

  constructor(private coinWalletService: CoinwalletService) {

  }

  ngOnInit() {
    this.curOptions = ['BTC', 'XRP', 'LTC', 'INR'];
    this.option = 'LTC';
  }

  onOptionSelect(event) {
    this.option = event.target.value;
    this.getCoinWallet();
  }

  getCoinWallet() {
    this.coinWalletService.getCoinWallet('', this.option).subscribe(res => {
      console.log(res);
      this.coinAmount = res;
      }
      // this.koinWallets.push(new KoinWallets(res["coinName"],
      //   res["total"], res["inOrders"], res["available"]
    );
  }

  withdrawAmount() {
    console.log('withdrawing');
    console.log(this.amountW);
    this.coinWalletService.withDrawAmount('', this.option, this.amountW).subscribe(res => this.message = res);
    this.getCoinWallet();
  }

  depositAmount() {
    console.log('depositing');
    console.log(this.amountD);
    this.coinWalletService.depositAmount('',  this.option, this.amountD).subscribe(res => this.message = res);
    this.getCoinWallet();
  }
}
