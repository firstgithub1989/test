import { Component, OnInit } from '@angular/core';
import { InrDetails } from '../../common/INRDetails';
import { InrwalletService } from './inrwallet.service';

@Component({
  selector: 'app-inrwallet',
  templateUrl: './inrwallet.component.html',
  styleUrls: ['./inrwallet.component.css']
})
export class InrwalletComponent implements OnInit {

  inrAmount: string;
  message: string;
  amountD: number;
  amountW: number;

  constructor(private inrWalletService: InrwalletService) { }

  ngOnInit() {
    this.message = 'hi';
    this.getInrWallet();
  }

  getInrWallet() {
    this.inrWalletService.getINRWallet('').subscribe(res => {
      console.log(res);
      this.inrAmount = res;
      }
      // this.koinWallets.push(new KoinWallets(res["coinName"],
      //   res["total"], res["inOrders"], res["available"]
    );
  }


  withdrawAmount() {
    console.log('withdrawing');
    console.log(this.amountW);
    this.inrWalletService.withDrawAmount('', '').subscribe(res => this.message = res);
    this.getInrWallet();
  }

  depositAmount() {
    console.log('depositing');
    console.log(this.amountD);
    this.inrWalletService.depositAmount('', this.amountD).subscribe(res => this.message = res);
    this.getInrWallet();
  }

}
