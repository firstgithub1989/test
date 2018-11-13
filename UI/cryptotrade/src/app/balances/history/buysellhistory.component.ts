import { Component, OnInit } from '@angular/core';
import { HistoryService } from './history.service';
import { BuySellDetials } from '../../common/BuySellDetails';

@Component({
  selector: 'app-buysellhist',
  templateUrl: './buysellhistory.component.html',
  styleUrls: ['./history.component.css']
})
export class BuySellHistoryComponent implements OnInit {

  buyHistory: BuySellDetials[];
  sellHistory: BuySellDetials[];
  totalB: number;
  totalS: number;
  pB: number;
  pS: number;
  option: string;
  curOptions: string[];

  constructor(private historyService: HistoryService) { }

  ngOnInit() {
    this.curOptions = ['BTC', 'XRP', 'LTC', 'INR'];
    this.option = 'BTC';
    this.getSellTnxHistory(1);
    this.getBuyTnxHistory(1);
  }

  onOptionSelect(event) {
    this.option = event.target.value;
    this.getSellTnxHistory(1);
    this.getBuyTnxHistory(1);
  }


  getBuyTnxHistory(page: number) {
    const userId = localStorage.getItem('currentUser');
    this.historyService.getBuySellHistory(userId, this.option, true, page - 1).subscribe(res => {
      console.log(res);
      this.pB = page;
      this.totalB = res.total;
      this.buyHistory = [];
      res.data.forEach(re => {
          this.buyHistory.push(new BuySellDetials(
            re['coinName'], re['volume'], re['rate'], re['fromSym'], re['purchaseDate']));
        });
      }
    );
  }

  getSellTnxHistory(page: number) {
    const userId = localStorage.getItem('currentUser');
    this.historyService.getBuySellHistory(userId, this.option, false, page - 1).subscribe(res => {
      console.log(res);
      this.pS = page;
      this.totalS = res.total;
      this.sellHistory = [];
      res.data.forEach(re => {
          this.sellHistory.push(new BuySellDetials(
            re['coinName'], re['volume'], re['rate'], re['fromSym'], re['purchaseDate']));
        });
      }
    );
  }
}
