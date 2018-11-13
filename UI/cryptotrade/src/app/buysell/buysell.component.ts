import { Component, OnInit, OnChanges } from '@angular/core';
import { BuySellDetials } from '../common/BuySellDetails';
import { BuySellServicesService } from './buy-sell-services.service';
import { ActivatedRoute } from '@angular/router';
import { AlertService } from '../alert/alert.service';

@Component({
  selector: 'app-buysell',
  templateUrl: './buysell.component.html',
  styleUrls: ['./buysell.component.css']
})
export class BuysellComponent implements OnInit {

  toSym: string;
  fromSym: string;
  toSymAmount: number;
  fromSymAmount: number;
  buyVolume: number;
  sellVolume: number;
  buyselldetail: BuySellDetials;
  rate: number;

  constructor(private buySellService: BuySellServicesService,
        private route: ActivatedRoute, private alertService: AlertService) {
      this.route.params.subscribe( params => {
        this.toSym = params['toSym'];
        this.fromSym = params['fromSym'];
        this.rate = params['rate'];
      });
  }

  ngOnInit() {
    this.toSymAmount = 0;
    this.fromSymAmount = 0;
    this.buyVolume = 0;
    this.sellVolume = 0;
    this.getCoinAmount();
  }

  buy() {
    this.alertService.clear();
    const userId = localStorage.getItem('currentUser');
    this.buySellService.buyOrder(userId, this.fromSym, this.toSym, this.buyVolume.toString()).subscribe(res => {
      this.alertService.success(res['_body']);
      this.getCoinAmount();
    });
  }

  sell() {
    this.alertService.clear();
    const userId = localStorage.getItem('currentUser');
    this.buySellService.sellOrder(userId, this.fromSym, this.toSym, this.sellVolume.toString()).subscribe(res => {
      this.alertService.success(res['_body']);
      this.getCoinAmount();
    });
  }

  getCoinAmount() {
    const userId = localStorage.getItem('currentUser');
    this.buySellService.getCoinAmount(userId, this.toSym).subscribe(res =>
      this.toSymAmount = res['_body']);
    this.buySellService.getCoinAmount(userId, this.fromSym).subscribe(res =>
      this.fromSymAmount = res['_body']);
  }

}
