import {
  Component,
  OnInit
} from '@angular/core';

import {
  Router
} from '@angular/router';

import {
  Experience
} from 'src/app/core/models/experience.model';

import {
  ExperienceService
} from 'src/app/core/services/experience.service';

@Component({
  selector: 'app-experience-list',
  templateUrl: './experience-list.component.html',
  styleUrls: ['./experience-list.component.scss']
})
export class ExperienceListComponent
  implements OnInit {

  experiences: Experience[] = [];

  constructor(
    private experienceService: ExperienceService,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.loadExperiences();

  }

  loadExperiences(): void {

    this.experienceService
      .getExperiences()
      .subscribe({

        next: (response) => {

          this.experiences =
            response.data.content;

        },

        error: (error) => {

          console.log(error);

        }

      });

  }

  editExperience(
    id: number
  ): void {

    this.router.navigate([
      `/admin/experience/edit/${id}`
    ]);

  }

  deleteExperience(
    id: number
  ): void {

    const confirmed =
      confirm(
        'Delete this experience?'
      );

    if (!confirmed) {

      return;

    }

    this.experienceService
      .deleteExperience(id)
      .subscribe({

        next: () => {

          alert(
            'Experience deleted!'
          );

          this.loadExperiences();

        },

        error: (error) => {

          console.log(error);

        }

      });

  }

}
