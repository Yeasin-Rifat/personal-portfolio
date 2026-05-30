import {
  Component,
  OnInit
} from '@angular/core';

import {
  ProjectService
} from 'src/app/core/services/project.service';

import {
  SkillService
} from 'src/app/core/services/skill.service';

import {
  ExperienceService
} from 'src/app/core/services/experience.service';

import {
  ContactService
} from 'src/app/core/services/contact.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent
  implements OnInit {

  totalProjects = 0;

  totalSkills = 0;

  totalExperiences = 0;

  totalMessages = 0;

  recentProjects: any[] = [];

  recentMessages: any[] = [];

  loading = true;

  constructor(
    private projectService: ProjectService,
    private skillService: SkillService,
    private experienceService: ExperienceService,
    private contactService: ContactService
  ) { }

  ngOnInit(): void {

    this.loadDashboard();

  }

  loadDashboard(): void {

    /* PROJECTS */

    this.projectService
      .getProjects()
      .subscribe({

        next: (response) => {

          this.totalProjects =
            response.data.content.length;

          this.recentProjects =
            response.data.content.slice(0, 5);

        }

      });

    /* SKILLS */

    this.skillService
      .getSkills()
      .subscribe({

        next: (response) => {

          this.totalSkills =
            response.data.content.length;

        }

      });

    /* EXPERIENCE */

    this.experienceService
      .getExperiences()
      .subscribe({

        next: (response) => {

          this.totalExperiences =
            response.data.content.length;

        }

      });

    /* CONTACTS */

    this.contactService
      .getContacts()
      .subscribe({

        next: (response) => {

          this.totalMessages =
            response.data.content.length;

          this.recentMessages =
            response.data.content.slice(0, 5);

          this.loading = false;

        }

      });

  }

}
