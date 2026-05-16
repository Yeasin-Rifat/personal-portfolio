import { Component, OnInit } from '@angular/core';

import { ProjectService } from 'src/app/core/services/project.service';

import { Project } from 'src/app/core/models/project.model';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.scss']
})
export class ProjectsComponent
  implements OnInit {

  projects: Project[] = [];

  constructor(
    private projectService: ProjectService
  ) { }

  ngOnInit(): void {

    this.loadProjects();
  }

  loadProjects(): void {

    this.projectService.getProjects()
      .subscribe({

        next: (response) => {

          this.projects = response.data.content;

          console.log(this.projects);
        },

        error: (error) => {

          console.log(error);
        }

      });
  }

}
