import { Component, OnInit } from '@angular/core';
import { BuySellDetials } from '../common/BuySellDetails';
import { BuySellServicesService } from './buy-sell-services.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-buysell',
  templateUrl: './buysell.component.html',
  styleUrls: ['./buysell.component.css']
})
export class BuysellComponent implements OnInit {

  toSym: string;
  fromSym: string;
  toSymAmount: string;
  fromSymAmount: string;
  buyVolume: string;
  sellVolume: string;
  buyselldetail: BuySellDetials;

  constructor(private buySellService: BuySellServicesService,
        private route: ActivatedRoute) {
      this.route.params.subscribe( params => {
        this.toSym = params['toSym'];
        this.fromSym = params['fromSym'];
      });
  }

  ngOnInit() {
    this.getCoinAmount();
  }


  buy() {
    this.buySellService.buyOrder('1', this.fromSym, this.toSym, this.buyVolume).subscribe(res => {
      console.log(res);
    });
  }

  sell() {
    this.buySellService.sellOrder('', this.fromSym, this.toSym, this.sellVolume).subscribe(res => {
      console.log(res);
    });
  }

  getCoinAmount() {
    this.buySellService.getCoinAmount('', this.toSym).subscribe(res => this.toSymAmount = res);
    this.buySellService.getCoinAmount('', this.fromSym).subscribe(res => this.fromSymAmount = res);
  }

}
