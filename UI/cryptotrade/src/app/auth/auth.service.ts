import { Injectable, EventEmitter, Output } from '@angular/core';
import { Http, Headers, RequestOptions, Response} from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Signup } from '../common/SignUp';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AuthService {

    @Output() change: EventEmitter<string> = new EventEmitter();
    isLoggedIn: boolean;
    authS: string;

    constructor(public http: Http, public httpHeaders: Http) {

    }

    login(userName: string, password: string): Observable<Response> {
        const headers = new Headers();
        headers.append('Authorization', 'Basic ' + btoa(userName + ':' + password));

        const options = new RequestOptions();
        options.headers = headers;
        options.withCredentials = true;

        return this.http.get('http://localhost:8304/login', options);
    }

    register(model: Signup): Observable<Response> {
        return this.http.post('http://localhost:8304/register', model);
    }

}
