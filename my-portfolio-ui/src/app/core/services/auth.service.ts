import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';

import { LoginRequest } from '../models/login-request.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl =
    `${environment.apiBaseUrl}/auth`;

  constructor(
    private http: HttpClient
  ) { }

  login(
    request: LoginRequest
  ): Observable<any> {

    return this.http.post(
      `${this.apiUrl}/login`,
      request
    );
  }

  saveToken(
    token: string
  ): void {

    localStorage.setItem(
      'token',
      token
    );
  }

  getToken(): string | null {

    return localStorage.getItem(
      'token'
    );
  }

  isLoggedIn(): boolean {

    return !!this.getToken();
  }

  logout(): void {

    localStorage.removeItem(
      'token'
    );
  }

}
