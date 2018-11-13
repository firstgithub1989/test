import { Component, ViewChild, OnInit, AfterViewInit, AfterContentInit,
  ContentChild, HostBinding, Input, ViewEncapsulation } from '@angular/core';
import { AuthenticationComponent } from './auth/auth.component';
import { AuthGuard } from './auth/auth.guard';
import { RouterStateSnapshot, ActivatedRouteSnapshot, Router } from '@angular/router';
import { AuthService } from './auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  appTitle = 'Trade here';

  auth: boolean;
  constructor(public router: Router) {
    // authGuard.canActivate(null, null);
  }

  ngOnInit() {

    if (localStorage.getItem('currentUser')) {
      // logged in so return true
      this.auth = true;
    }
  }

  logout() {
        localStorage.removeItem('currentUser');
        window.location.reload();
        this.router.navigate(['/marketplace']);
  }
}

