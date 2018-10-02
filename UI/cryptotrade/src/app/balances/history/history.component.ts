import { Component, OnInit } from '@angular/core';
import { HistoryService } from '../services/history.service';
import { TranHistory } from '../../common/TranHistory';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  tranHistoryD: TranHistory[];
  tranHistoryW: TranHistory[];
  totalD: number;
  totalW: number;
  pW: number;
  pD: number;
  option: string;
  curOptions: string[];

  constructor(private historyService: HistoryService) { }

  ngOnInit() {
    this.curOptions = ['BTC', 'XRP', 'LTC', 'INR'];
    this.option = 'LTC';
    this.pW = 0;
    this.pD = 0;
    this.tranHistoryD = [];
    this.tranHistoryW = [];
    this.getWithdrawTnxHistory(1);
    this.getDepositTnxHistory(1);
  }

  onOptionSelect(event) {
    this.option = event.target.value;
    this.getDepositTnxHistory(1);
    this.getWithdrawTnxHistory(1);
  }

  getDepositTnxHistory(page: number) {
    this.historyService.getTranHistory('', this.option, page - 1, true).subscribe(res => {
      console.log(res);
      this.pD = page;
      this.totalD = res.total;
      this.tranHistoryD = [];
      res.data.forEach(re => {
          this.tranHistoryD.push(new TranHistory(re['coinName'], re['paymentDate'], re['amount'], re['deposit']));
        });
      }
    );
  }

  getWithdrawTnxHistory(page: number) {
    this.historyService.getTranHistory('', this.option, page - 1, false).subscribe(res => {
      console.log(res);
      this.pW = page;
      this.totalW = res.total;
      this.tranHistoryW = [];
      res.data.forEach(re => {
          this.tranHistoryW.push(new TranHistory(re['coinName'], re['paymentDate'], re['amount'], re['deposit']));
        });
      }
    );
  }
}
