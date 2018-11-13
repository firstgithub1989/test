import { Injectable } from '@angular/core';
import { ITranHistory } from '../../common/ITranHistory';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { AppSetting } from '../../common/appsettings';
import { BuySellDetials } from '../../common/BuySellDetails';
import { IBuySellHistory } from '../../common/IBuySellHistory';
import { RequestOptions } from '@angular/http';

@Injectable()
export class HistoryService {

  constructor(private http: HttpClient) { }

  public getTranHistory(userId: string, coinName: string, page: number, isDeposit: boolean): Observable<ITranHistory> {
    return this.http.get<ITranHistory>(
      AppSetting.PAYMENT + 'getPayTranHistory/' + userId + '/' + coinName + '/'
      + page + '/' + isDeposit, {withCredentials: true});
  }

  public getBuySellHistory(userId: string, coinName: string, isBuy: boolean, page: number): Observable<IBuySellHistory> {

    return this.http.get<IBuySellHistory>(
      AppSetting.HISTORY  + userId + '/' + coinName + '/'
       + isBuy + '/' + page, {withCredentials: true});
  }
}
