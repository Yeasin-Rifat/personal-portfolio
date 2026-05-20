import {
  Component,
  OnInit
} from '@angular/core';

import {
  Router
} from '@angular/router';

import {
  ProjectService
} from 'src/app/core/services/project.service';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.scss']
})
export class ProjectListComponent
  implements OnInit {

  projects: any[] = [];

  constructor(
    private projectService: ProjectService,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.loadProjects();
  }

  loadProjects(): void {

    this.projectService
      .getProjects()
      .subscribe({

        next: (response) => {

          this.projects =
            response.data.content;
        }

      });
  }

  editProject(
    id: number
  ): void {

    this.router.navigate([
      `/admin/projects/edit/${id}`
    ]);
  }

  deleteProject(
    id: number
  ): void {

    const confirmed =
      confirm(
        'Delete this project?'
      );

    if (!confirmed) {

      return;
    }

    this.projectService
      .deleteProject(id)
      .subscribe({

        next: () => {

          this.loadProjects();
        }

      });
  }

}
