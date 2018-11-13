import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BuySellDetials } from '../common/BuySellDetails';
import { Observable } from 'rxjs/Observable';
import { AppSetting } from '../common/appsettings';
import { Http, RequestOptions, Response, URLSearchParams } from '@angular/http';

@Injectable()
export class BuySellServicesService {

  constructor(private http: Http) {

  }

  buyOrder(userId: string, fromSym: string, toSym: string, volume: string): Observable<Response> {
    // const params = new HttpParams().set('userId', '1').set('fromSym', fromSym)
    //     .set('toSym', toSym).set('amount', volume);
    const params = new URLSearchParams();
      params.set('userId', userId);
      params.set('fromSym', fromSym);
      params.set('toSym', toSym);
      params.set('volume', volume);
      const options = new RequestOptions();
      options.params = params;
      options.withCredentials = true;

    return this.http.post(AppSetting.BUY, null, {params});
  }

  sellOrder(userId: string, fromSym: string, toSym: string, volume: string): Observable<Response> {
    const params = new URLSearchParams();
      params.set('userId', userId);
      params.set('fromSym', fromSym);
      params.set('toSym', toSym);
      params.set('volume', volume);
      const options = new RequestOptions();
      options.params = params;
      options.withCredentials = true;

    return this.http.post(AppSetting.SELL, null, {params});
  }

  getInrAmount(userId: string): Observable<Response> {
    return this.http.get(AppSetting.PAYMENT + 'getBalanceAmount/' + userId);
  }

  getCoinAmount(userId: string, coinName: string): Observable<Response> {
    const params = new URLSearchParams();
      params.set('user', userId);
      params.set('coinName', coinName);
      const options = new RequestOptions();
      options.params = params;
      options.withCredentials = true;
    return this.http.get(AppSetting.PAYMENT  + 'getBalanceAmount/', {params});
  }

}
