import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ExperienceService {

  private apiUrl =
    `${environment.apiBaseUrl}/experiences`;

  constructor(
    private http: HttpClient
  ) { }

  getExperiences(): Observable<any> {

    return this.http.get(this.apiUrl);
  }

}
