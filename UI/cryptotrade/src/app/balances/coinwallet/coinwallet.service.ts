import { Injectable } from '@angular/core';
import { Http, RequestOptions, Response, URLSearchParams } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { AppSetting } from '../../common/appsettings';

@Injectable()
export class CoinwalletService {

  constructor(private http: Http) { }

  public getCoinWallet(userId: string, coinName: string): Observable<Response> {
    const params = new URLSearchParams();
      params.set('user', userId);
      params.set('coinName', coinName);
      const options = new RequestOptions();
      options.params = params;
    return this.http.get(AppSetting.PAYMENT + 'getBalanceAmount/', {params});
  }

  public withDrawAmount(userId: string, coinName: string, amount: string): Observable<Response> {
    const params = new URLSearchParams();
      params.set('user', userId);
      params.set('coinName', coinName);
      params.set('amount', amount);
      const options = new RequestOptions();
      options.params = params;

    return this.http.post(AppSetting.PAYMENT + 'withdraw', null, {params});
  }

  public depositAmount(userId: string, coinName: string, amount: string): Observable<Response> {
    const params = new URLSearchParams();
      params.set('user', userId);
      params.set('coinName', coinName);
      params.set('amount', amount);
      const options = new RequestOptions();
      options.params = params;

    return this.http.post(AppSetting.PAYMENT + 'deposit', null, {params});
  }
}
