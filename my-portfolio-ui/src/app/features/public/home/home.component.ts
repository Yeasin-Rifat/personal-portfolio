import {
  Component,
  OnInit
} from '@angular/core';

import {
  ProfileService
} from 'src/app/core/services/profile.service';

import {
  Profile
} from 'src/app/core/models/profile.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent
  implements OnInit {

  profile!: Profile;

  isLoading = true;

  constructor(
    private profileService: ProfileService
  ) { }

  ngOnInit(): void {

    this.loadProfile();

  }

  loadProfile(): void {

    this.profileService
      .getProfile()
      .subscribe({

        next: (response) => {

          this.profile =
            response.data;

          this.isLoading = false;

        },

        error: (error) => {

          console.log(error);

          this.isLoading = false;

        }

      });

  }

}
