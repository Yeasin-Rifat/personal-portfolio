import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router} from '@angular/router';

import { ProjectService } from 'src/app/core/services/project.service';

import { UploadService } from 'src/app/core/services/upload.service';

@Component({
  selector: 'app-project-form',
  templateUrl: './project-form.component.html',
  styleUrls: ['./project-form.component.scss']
})
export class ProjectFormComponent
  implements OnInit {

  isEditMode = false;

  projectId!: number;

  project = {

    title: '',

    description: '',

    imageUrl: '',

    githubLink: '',

    liveLink: '',

    techStack: '',

    featured: false
  };

  constructor(
    private projectService: ProjectService,
    private route: ActivatedRoute,
    private uploadService: UploadService,
    private router: Router

  ) { }

  ngOnInit(): void {

    const id =
      this.route.snapshot.paramMap.get('id');

    if (id) {

      this.isEditMode = true;

      this.projectId = +id;

      this.loadProject();
    }
  }

  loadProject(): void {

    this.projectService
      .getProjectById(this.projectId)
      .subscribe({

        next: (response) => {

          this.project =
            response.data;
        }

      });
  }

  saveProject(): void {

    if (this.isEditMode) {

      this.projectService
        .updateProject(
          this.projectId,
          this.project
        )
        .subscribe({

          next: () => {

            this.router.navigate([
              '/admin/projects'
            ]);
          }

        });

    } else {

      this.projectService
        .createProject(this.project)
        .subscribe({

          next: () => {

            this.router.navigate([
              '/admin/projects'
            ]);
          }

        });
    }

  }

  onFileSelected(event: any): void {

    const file = event.target.files[0];

    if (file) {

      const formData = new FormData();

      formData.append('file', file);

      this.uploadService
        .uploadImage(formData)
        .subscribe({

          next: (response) => {

            console.log(response);

            this.project.imageUrl =
              response.imageUrl;

            console.log(
              this.project.imageUrl
            );
          },

          error: (error) => {

            console.log(error);
          }
        });
    }
  }

}
