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
export class SkillService {

  private apiUrl =
    `${environment.apiBaseUrl}/skills`;

  constructor(
    private http: HttpClient
  ) { }

  getSkills(): Observable<any> {

    return this.http.get(
      this.apiUrl
    );

  }

  getSkillById(
    id: number
  ): Observable<any> {

    return this.http.get(
      `${this.apiUrl}/${id}`
    );

  }

  createSkill(
    skill: any
  ): Observable<any> {

    return this.http.post(
      this.apiUrl,
      skill
    );

  }

  updateSkill(
    id: number,
    skill: any
  ): Observable<any> {

    return this.http.put(
      `${this.apiUrl}/${id}`,
      skill
    );

  }

  deleteSkill(
    id: number
  ): Observable<any> {

    return this.http.delete(
      `${this.apiUrl}/${id}`
    );

  }

}
