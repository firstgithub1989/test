import { Component, OnInit } from '@angular/core';
import { ProfileService } from './profile.service';
import { UserDetails } from '../common/UserDetails';
import { Signup } from '../common/SignUp';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  userDetails: Signup;

  constructor(public profileService: ProfileService) {
    this.userDetails = new Signup();
   }

  ngOnInit() {
    const userId = localStorage.getItem('currentUser');
    this.profileService.getUserDetails(userId).subscribe(res => {
      this.userDetails = res['_body'];
    });
  }
}
