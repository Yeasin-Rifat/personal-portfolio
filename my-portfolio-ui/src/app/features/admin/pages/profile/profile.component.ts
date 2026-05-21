import {
  Component,
  OnInit
} from '@angular/core';

import {
  Profile
} from 'src/app/core/models/profile.model';

import {
  ProfileService
} from 'src/app/core/services/profile.service';

import {
  UploadService
} from 'src/app/core/services/upload.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent
  implements OnInit {

  isSaving = false;

  profile: Profile = {

    fullName: '',

    title: '',

    bio: '',

    profileImage: '',

    resumeUrl: '',

    githubLink: '',

    linkedinLink: '',

    facebookLink: '',

    email: '',

    phone: '',

    location: ''

  };

  constructor(
    private profileService: ProfileService,
    private uploadService: UploadService
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

        },

        error: (error) => {

          console.log(error);

        }

      });

  }

  saveProfile(): void {

    if (!this.profile.id) {

      alert(
        'Profile ID not found!'
      );

      return;

    }

    this.isSaving = true;

    this.profileService
      .updateProfile(
        this.profile.id,
        this.profile
      )
      .subscribe({

        next: () => {

          this.isSaving = false;

          alert(
            'Profile updated successfully!'
          );

        },

        error: (error) => {

          this.isSaving = false;

          console.log(error);

          alert(
            'Something went wrong!'
          );

        }

      });

  }

  onFileSelected(
    event: any
  ): void {

    const file =
      event.target.files[0];

    if (file) {

      const formData =
        new FormData();

      formData.append(
        'file',
        file
      );

      this.uploadService
        .uploadImage(formData)
        .subscribe({

          next: (response) => {

            this.profile.profileImage =
              response.imageUrl;

          },

          error: (error) => {

            console.log(error);

          }

        });

    }

  }

}
