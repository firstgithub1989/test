import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { InrDetails } from '../../common/INRDetails';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable()
export class InrwalletService {

  constructor(private http: HttpClient) { }

  public getINRWallet(userName: string): Observable<string> {
    return this.http.get<string>('http://localhost:8087/pay/getINRAmount/1/');
  }

  public withDrawAmount(userName: string, amount: string): Observable<string> {
    console.log(amount);
    const params = new HttpParams().set('user', '1').set('coinName', 'INR').set('amount', amount);

    return this.http.post<string>('http://localhost:8087/pay/withdraw', null, {params});
  }

  public depositAmount(userName: string, amount: number): Observable<string> {
    return this.http.post<string>('http://localhost:8087/pay/deposit/1/' + amount, {
      responseType: 'text'});
  }
}
