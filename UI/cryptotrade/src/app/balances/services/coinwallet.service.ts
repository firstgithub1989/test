import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { AppSetting } from '../../common/appsettings';

@Injectable()
export class CoinwalletService {

  constructor(private http: HttpClient) { }

  public getCoinWallet(userName: string, coinName: string): Observable<string> {
    return this.http.get<string>(AppSetting.PAYMENT + 'getBalanceAmount/1/' + coinName);
  }

  public withDrawAmount(userName: string, coinName: string, amount: string): Observable<string> {
    console.log(amount);
    const params = new HttpParams().set('user', '1').set('coinName', coinName)
      .set('amount', amount);

    return this.http.post<string>(AppSetting.PAYMENT + 'withdraw', null, {params});
  }

  public depositAmount(userName: string, coinName: string, amount: string): Observable<string> {
    const params = new HttpParams().set('user', '1').set('coinName', coinName)
      .set('amount', amount);

    return this.http.post<string>(AppSetting.PAYMENT + 'deposit', null, {params});
  }
}
