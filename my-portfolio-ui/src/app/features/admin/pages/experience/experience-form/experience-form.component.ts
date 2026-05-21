import {
  Component,
  OnInit
} from '@angular/core';

import {
  ActivatedRoute,
  Router
} from '@angular/router';

import {
  ExperienceService
} from 'src/app/core/services/experience.service';

import {
  Experience
} from 'src/app/core/models/experience.model';

@Component({
  selector: 'app-experience-form',
  templateUrl: './experience-form.component.html',
  styleUrls: ['./experience-form.component.scss']
})
export class ExperienceFormComponent
  implements OnInit {

  isEditMode = false;

  experienceId!: number;

  isSaving = false;

  experience: Experience = {

    companyName: '',

    position: '',

    startDate: '',

    endDate: '',

    currentlyWorking: false,

    description: ''

  };

  constructor(
    private experienceService: ExperienceService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {

    const id =
      this.route.snapshot.paramMap.get('id');

    if (id) {

      this.isEditMode = true;

      this.experienceId = +id;

      this.loadExperience();

    }

  }

  loadExperience(): void {

    this.experienceService
      .getExperienceById(
        this.experienceId
      )
      .subscribe({

        next: (response) => {

          this.experience =
            response.data;

        },

        error: (error) => {

          console.log(error);

        }

      });

  }

  saveExperience(): void {

    this.isSaving = true;

    const request =
      this.isEditMode
        ? this.experienceService
          .updateExperience(
            this.experienceId,
            this.experience
          )
        : this.experienceService
          .createExperience(
            this.experience
          );

    request.subscribe({

      next: () => {

        this.isSaving = false;

        alert(
          this.isEditMode
            ? 'Experience updated successfully!'
            : 'Experience created successfully!'
        );

        this.router.navigate([
          '/admin/experience'
        ]);

      },

      error: (error) => {

        this.isSaving = false;

        console.log(error);

        alert(
          'Something went wrong!'
        );

      }

    });

  }

}
