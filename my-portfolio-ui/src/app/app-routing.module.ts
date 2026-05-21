import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './features/auth/login/login.component';

import { HomeComponent } from './features/public/home/home.component';
import { ProjectsComponent } from './features/public/projects/projects.component';
import { SkillsComponent } from './features/public/skills/skills.component';
import { ExperienceComponent } from './features/public/experience/experience.component';
import { ContactComponent } from './features/public/contact/contact.component';

import {DashboardComponent} from "./features/admin/pages/dashboard/dashboard.component";
import {ProjectListComponent} from "./features/admin/pages/project/project-list/project-list.component";
import {ProjectFormComponent} from "./features/admin/pages/project/project-form/project-form.component";
import {ProfileComponent} from "./features/admin/pages/profile/profile.component";
import {AdminLayoutComponent} from "./features/admin/admin-layout/admin-layout.component";
import {AuthGuard} from "./core/guards/auth.guard";
import {ExperienceFormComponent} from "./features/admin/pages/experience/experience-form/experience-form.component";
import {ExperienceListComponent} from "./features/admin/pages/experience/experience-list/experience-list.component";

const routes: Routes = [

  {
    path: '',
    component: HomeComponent
  },

  {
    path: 'projects',
    component: ProjectsComponent
  },

  {
    path: 'skills',
    component: SkillsComponent
  },

  {
    path: 'experience',
    component: ExperienceComponent
  },

  {
    path: 'contact',
    component: ContactComponent
  },

  {
    path: 'login',
    component: LoginComponent
  },

  {
    path: 'admin',
    component: AdminLayoutComponent,
    canActivate: [AuthGuard],
    children: [

      { path: 'dashboard', component: DashboardComponent },

      { path: 'projects', component: ProjectListComponent },
      { path: 'projects/create', component: ProjectFormComponent },
      { path: 'projects/edit/:id', component: ProjectFormComponent },

      { path: 'profile', component: ProfileComponent },

      { path: 'experience', component: ExperienceListComponent },
      { path: 'experience/create', component: ExperienceFormComponent },
      { path: 'experience/edit/:id', component: ExperienceFormComponent },

      { path: '', redirectTo: 'dashboard', pathMatch: 'full' }
    ]
  },

  {
    path: '**',
    redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
