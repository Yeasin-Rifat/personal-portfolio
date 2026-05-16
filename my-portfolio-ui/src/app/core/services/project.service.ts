import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { environment } from 'src/environments/environment';

import { Project } from '../models/project.model';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private apiUrl =
    `${environment.apiBaseUrl}/projects`;

  constructor(
    private http: HttpClient
  ) { }

  getProjects(): Observable<any> {

    return this.http.get(this.apiUrl);
  }

}
