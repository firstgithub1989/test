import { Injectable } from '@angular/core';
import { ITranHistory } from '../../common/ITranHistory';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { AppSetting } from '../../common/appsettings';

@Injectable()
export class HistoryService {

  constructor(private http: HttpClient) { }

  public getTranHistory(userName: string, coinName: string, page: number, isDeposit: boolean): Observable<ITranHistory> {
    return this.http.get<ITranHistory>(
      AppSetting.PAYMENT + 'getPayTranHistory/1/' + coinName + '/' + page + '/' + isDeposit);
  }
}
