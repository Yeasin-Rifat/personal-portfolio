import { Injectable } from '@angular/core';

import {
  HttpClient
} from '@angular/common/http';

import {
  Observable
} from 'rxjs';

import {
  environment
} from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private apiUrl =
    `${environment.apiBaseUrl}/profile`;

  constructor(
    private http: HttpClient
  ) { }

  getProfile(): Observable<any> {

    return this.http.get(
      this.apiUrl
    );

  }

  updateProfile(
    id: number,
    profile: any
  ): Observable<any> {

    return this.http.put(
      `${this.apiUrl}/${id}`,
      profile
    );

  }

}
