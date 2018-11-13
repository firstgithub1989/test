import { Component, OnInit, Input, Output, EventEmitter, ViewEncapsulation, ViewChild } from '@angular/core';
import { AuthService } from './auth.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Signup } from '../common/SignUp';


@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
  encapsulation: ViewEncapsulation.Native
})
export class AuthenticationComponent implements OnInit {

  user: string;
  @ViewChild('f') form: any;


  model: Signup ;

  logIn: Signup ;

  constructor(private authService: AuthService, private route: ActivatedRoute,
    private router: Router) {
    console.log('AuthComponent Contructor');
  }

  ngOnInit() {
    this.model = new Signup();
  }

  login() {
    if (this.form.valid) {
      console.log('login request' + this.model.password + this.model.userName);
      this.authService.login(this.model.userName, this.model.password)
      .subscribe(response => {
        localStorage.setItem('currentUser', response['_body']);
        window.location.reload();
        this.router.navigate(['/marketplace']);
      });
    }
     // window.location.reload();
  }
}
