import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response} from '@angular/http';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AuthService {


    isLoggedIn: boolean;

    constructor(public http: Http, public httpHeaders: Http) {

    }

    login(userName: string, password: string): string {
        // console.log(userName + ':' + password);
        // const headers = new Headers();
        let user = null;
        // headers.append('Authorization', 'Basic' + btoa(userName + ':' + password));
        // console.log(headers.toJSON());

        // const options = new RequestOptions();
        // options.headers = headers;
        // options.withCredentials = true;
        this.http.get('http://localhost:8304/login', null)
        .map((response: Response) => {
            console.log(response.text());
            console.log(user);
            }
        )
        .subscribe();
        user = 'user';
        this.isLoggedIn = (user != null);
        console.log(this.isLoggedIn);
        return user;
    }

}