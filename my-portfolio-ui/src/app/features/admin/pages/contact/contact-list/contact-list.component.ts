import {
  Component,
  OnInit
} from '@angular/core';

import {
  ContactService
} from 'src/app/core/services/contact.service';

import {
  Contact
} from 'src/app/core/models/contact.model';

@Component({
  selector: 'app-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.scss']
})
export class ContactListComponent
  implements OnInit {

  contacts: Contact[] = [];

  constructor(
    private contactService: ContactService
  ) { }

  ngOnInit(): void {

    this.loadContacts();

  }

  loadContacts(): void {

    this.contactService
      .getContacts()
      .subscribe({

        next: (response) => {

          this.contacts =
            response.data.content;

        },

        error: (error) => {

          console.log(error);

        }

      });

  }

  deleteContact(
    id: number
  ): void {

    const confirmed =
      confirm(
        'Delete this message?'
      );

    if (!confirmed) {

      return;

    }

    this.contactService
      .deleteContact(id)
      .subscribe({

        next: () => {

          this.loadContacts();

        },

        error: (error) => {

          console.log(error);

        }

      });

  }

}
