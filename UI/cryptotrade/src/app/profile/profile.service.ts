import { Injectable } from '@angular/core';
import { Http, RequestOptions, Response} from '@angular/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ProfileService {

  constructor(public http: Http) { }

  getUserDetails(userId: string): Observable<Response> {
    const options = new RequestOptions();
    options.withCredentials = true;

    return this.http.get('http://localhost:8304/profile/' + userId, options);
  }
}
