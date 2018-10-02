import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BuySellDetials } from '../common/BuySellDetails';
import { Observable } from 'rxjs/Observable';
import { AppSetting } from '../common/appsettings';

@Injectable()
export class BuySellServicesService {

  constructor(private http: HttpClient) {

  }

  buyOrder(userName: string, fromSym: string, toSym: string, volume: string): Observable<string> {
    // const params = new HttpParams().set('userId', '1').set('fromSym', fromSym)
    //     .set('toSym', toSym).set('amount', volume);

    return this.http.post<string>(AppSetting.BUYSELL
      + userName + '/' + volume + '/' + fromSym + '/' + toSym, {
        responseType: 'text'});
  }

  sellOrder(userName: string, fromSym: string, toSym: string, volume: string) {
    // const params = new HttpParams().set('userId', '1').set('fromSym', fromSym)
    //     .set('toSym', toSym).set('amount', volume);

    return this.http.post<string>(AppSetting.BUYSELL
    + userName + '/'  + volume + '/' + fromSym + '/' + toSym, {
      responseType: 'text'});
  }

  getInrAmount(userName: string): Observable<string> {
    return this.http.get<string>(AppSetting.BUYSELL + 'getBalanceAmount/1/');
  }

  getCoinAmount(userName: string, coinName: string): Observable<string> {
    return this.http.get<string>(AppSetting.PAYMENT  + 'getBalanceAmount/1/' + coinName);
  }

}
