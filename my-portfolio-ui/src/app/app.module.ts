import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

/* AUTH */
import { LoginComponent } from './features/auth/login/login.component';

/* PUBLIC */
import { HomeComponent } from './features/public/home/home.component';
import { ProjectsComponent } from './features/public/projects/projects.component';
import { SkillsComponent } from './features/public/skills/skills.component';
import { ExperienceComponent } from './features/public/experience/experience.component';
import { ContactComponent } from './features/public/contact/contact.component';

/* ADMIN */
import { AdminLayoutComponent } from './features/admin/admin-layout/admin-layout.component';
import { SidebarComponent } from './features/admin/sidebar/sidebar.component';

import { DashboardComponent } from './features/admin/pages/dashboard/dashboard.component';
import { ProjectListComponent } from './features/admin/pages/project/project-list/project-list.component';
import { ProjectFormComponent } from './features/admin/pages/project/project-form/project-form.component';
import { ProfileComponent } from './features/admin/pages/profile/profile.component';
import {NavbarComponent} from "./layout/navbar/navbar.component";
import { HeaderComponent } from './features/admin/header/header.component';
import { ExperienceListComponent } from './features/admin/pages/experience/experience-list/experience-list.component';
import { ExperienceFormComponent } from './features/admin/pages/experience/experience-form/experience-form.component';
import { SkillListComponent } from './features/admin/pages/skill/skill-list/skill-list.component';
import { SkillFormComponent } from './features/admin/pages/skill/skill-form/skill-form.component';
import { ContactListComponent } from './features/admin/pages/contact/contact-list/contact-list.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,

    /* auth */
    LoginComponent,

    /* public */
    HomeComponent,
    ProjectsComponent,
    SkillsComponent,
    ExperienceComponent,
    ContactComponent,

    /* admin */
    AdminLayoutComponent,
    SidebarComponent,
    DashboardComponent,
    ProjectListComponent,
    ProjectFormComponent,
    ProfileComponent,
    ExperienceListComponent,
    ExperienceFormComponent,
    HeaderComponent,
    ExperienceListComponent,
    ExperienceFormComponent,
    SkillListComponent,
    SkillFormComponent,
    ContactListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
