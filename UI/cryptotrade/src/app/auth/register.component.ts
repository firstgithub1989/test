import { Component, ViewEncapsulation, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { AuthService } from './auth.service';
import { Signup } from '../common/SignUp';
import { AlertService } from '../alert/alert.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
    selector: 'app-register',
    templateUrl: './register.component.html',
    styleUrls: ['./auth.component.css'],
    encapsulation: ViewEncapsulation.Native
  })

export class RegisterComponent implements OnInit {

    model: Signup = new Signup();

    hiddenValue: string;
    @ViewChild('f') form: any;
    constructor(private authService: AuthService, private alertService: AlertService,
        private route: ActivatedRoute, private router: Router) {
    }

    ngOnInit() {

    }

    register() {
        if (this.form.valid) {
            console.log(this.model);
            this.authService.register(this.model).subscribe(response => {
                console.log(response['_body']);
                this.alertService.success(response['_body'] +  '. Redirecting to Login Page... '
                    + 'in 3 seconds', true);
                this.hiddenValue = 'hidden';
                setTimeout(() => {
                    this.router.navigate(['/app-auth']);
                }, 3000);
            });
        }
    }
}
