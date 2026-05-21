import { Component, OnInit } from '@angular/core';
import { ContactService } from 'src/app/core/services/contact.service';
import { Contact } from 'src/app/core/models/contact.model';
import { ProfileService } from 'src/app/core/services/profile.service';
import { Profile } from 'src/app/core/models/profile.model';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {

  profile!: Profile;

  isSending = false;
  successMessage = '';
  errorMessage = '';

  contactForm: Contact = {
    name: '',
    email: '',
    subject: '',
    message: ''
  };

  constructor(
    private contactService: ContactService,
    private profileService: ProfileService
  ) {}

  ngOnInit(): void {
    this.loadProfile();
  }

  loadProfile(): void {
    this.profileService.getProfile().subscribe({
      next: (res) => {
        this.profile = res?.data;
      }
    });
  }

  // ✅ EMAIL VALIDATION
  private isValidEmail(email: string): boolean {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
  }

  sendMessage(): void {

    // ❌ required validation
    if (!this.contactForm.name ||
      !this.contactForm.email ||
      !this.contactForm.subject ||
      !this.contactForm.message) {
      this.errorMessage = 'All fields are required!';
      return;
    }

    // ❌ email validation
    if (!this.isValidEmail(this.contactForm.email)) {
      this.errorMessage = 'Please enter a valid email address!';
      return;
    }

    this.isSending = true;
    this.successMessage = '';
    this.errorMessage = '';

    this.contactService.createContact(this.contactForm).subscribe({

      next: (res) => {

        this.isSending = false;
        this.successMessage = res?.message || 'Message sent successfully!';

        alert(this.successMessage);

        // reset form
        this.contactForm = {
          name: '',
          email: '',
          subject: '',
          message: ''
        };

      },

      error: (err) => {

        this.isSending = false;

        console.log(err);

        this.errorMessage =
          err?.error?.message || 'Something went wrong!';

        alert(this.errorMessage);

      }

    });

  }

}
