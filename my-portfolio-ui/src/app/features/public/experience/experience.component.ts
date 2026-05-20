import { Component, OnInit } from '@angular/core';

import { Experience } from 'src/app/core/models/experience.model';

import { ExperienceService } from 'src/app/core/services/experience.service';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.scss']
})
export class ExperienceComponent
  implements OnInit {

  experiences: Experience[] = [];

  constructor(
    private experienceService: ExperienceService
  ) { }

  ngOnInit(): void {

    this.loadExperiences();
  }

  loadExperiences(): void {

    this.experienceService.getExperiences()
      .subscribe({

        next: (response) => {

          this.experiences =
            response.data.content;

          console.log(this.experiences);
        },

        error: (error) => {

          console.log(error);
        }

      });
  }

}
