import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './features/auth/login/login.component';

import { HomeComponent } from './features/public/home/home.component';
import { ProjectsComponent } from './features/public/projects/projects.component';
import { SkillsComponent } from './features/public/skills/skills.component';
import { ExperienceComponent } from './features/public/experience/experience.component';
import { ContactComponent } from './features/public/contact/contact.component';

import { DashboardComponent } from './features/admin/dashboard/dashboard.component';
import {AuthGuard} from "./core/guards/auth.guard";
import {ProjectListComponent} from "./features/admin/project/project-list/project-list.component";
import {ProjectFormComponent} from "./features/admin/project/project-form/project-form.component";

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
    path: 'admin/dashboard',
    component: DashboardComponent,
    canActivate: [AuthGuard]
  },

  {
    path: 'admin/projects',
    component: ProjectListComponent,
    canActivate: [AuthGuard]
  },

  {
    path: 'admin/projects/create',
    component: ProjectFormComponent,
    canActivate: [AuthGuard]
  },

  {
    path: 'admin/projects/edit/:id',
    component: ProjectFormComponent,
    canActivate: [AuthGuard]
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
