import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  private apiUrl =
    `${environment.apiBaseUrl}/skills`;

  constructor(
    private http: HttpClient
  ) { }

  getSkills(): Observable<any> {

    return this.http.get(this.apiUrl);
  }

}
