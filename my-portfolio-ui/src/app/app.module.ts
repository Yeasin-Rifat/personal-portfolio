import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './features/auth/login/login.component';
import { HomeComponent } from './features/public/home/home.component';
import { ProjectsComponent } from './features/public/projects/projects.component';
import { ExperienceComponent } from './features/public/experience/experience.component';
import { ContactComponent } from './features/public/contact/contact.component';
import { DashboardComponent } from './features/admin/dashboard/dashboard.component';
import { SkillsComponent } from './features/public/skills/skills.component';
import { ProfileComponent } from './features/admin/profile/profile.component';
import { ContactsComponent } from './features/admin/contacts/contacts.component';
import { NavbarComponent } from './layout/navbar/navbar.component';
import { FooterComponent } from './layout/footer/footer.component';
import { SidebarComponent } from './layout/sidebar/sidebar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    ProjectsComponent,
    ExperienceComponent,
    ContactComponent,
    DashboardComponent,
    SkillsComponent,
    ProfileComponent,
    ContactsComponent,
    NavbarComponent,
    FooterComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
