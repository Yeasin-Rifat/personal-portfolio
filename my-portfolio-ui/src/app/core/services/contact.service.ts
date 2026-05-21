import {
  Injectable
} from '@angular/core';

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
export class ContactService {

  private apiUrl =
    `${environment.apiBaseUrl}/contacts`;

  constructor(
    private http: HttpClient
  ) { }

  /* CREATE MESSAGE */

  createContact(
    contact: any
  ): Observable<any> {

    return this.http.post(
      this.apiUrl,
      contact
    );

  }

  /* GET ALL */

  getContacts(): Observable<any> {

    return this.http.get(
      this.apiUrl
    );

  }

  /* DELETE */

  deleteContact(
    id: number
  ): Observable<any> {

    return this.http.delete(
      `${this.apiUrl}/${id}`
    );

  }

}
