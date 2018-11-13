import { Component, OnInit } from '@angular/core';
import { CoinwalletService } from './coinwallet.service';
import { AlertService } from '../../alert/alert.service';

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

  constructor(private coinWalletService: CoinwalletService,
    private alertService: AlertService) {

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
    const userId = localStorage.getItem('currentUser');
    this.coinWalletService.getCoinWallet(userId, this.option).subscribe(res => {
      console.log(res);
      this.coinAmount = res['_body'] ;
      }
    );
  }

  withdrawAmount() {
    console.log('withdrawing');
    this.alertService.clear();
    const userId = localStorage.getItem('currentUser');
    this.coinWalletService.withDrawAmount(userId, this.option, this.amountW).subscribe(response => {
      this.alertService.success(response['_body']);
      this.getCoinWallet();
    });
  }

  depositAmount() {
    console.log('depositing');
    this.alertService.clear();
    const userId = localStorage.getItem('currentUser');
    this.coinWalletService.depositAmount(userId,  this.option, this.amountD).subscribe(response => {
      console.log(response);
      this.alertService.success(response['_body']);
      this.getCoinWallet();
    });
  }
}
