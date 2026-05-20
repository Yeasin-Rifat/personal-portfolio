import { Component } from '@angular/core';

import { Router } from '@angular/router';

import { AuthService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  email = '';

  password = '';

  errorMessage = '';

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  login(): void {

    const request = {

      email: this.email,

      password: this.password
    };

    this.authService.login(request)
      .subscribe({

        next: (response) => {

          const token =
            response.data.token;

          this.authService
            .saveToken(token);

          this.router.navigate([
            '/admin/dashboard'
          ]);
        },

        error: (error) => {

          this.errorMessage =
            'Invalid Credentials';

          console.log(error);
        }

      });
  }

}
