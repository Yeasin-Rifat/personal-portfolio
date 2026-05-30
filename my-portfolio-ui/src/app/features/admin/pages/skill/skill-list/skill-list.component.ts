import {
  Component,
  OnInit
} from '@angular/core';

import {
  Router
} from '@angular/router';

import {
  Skill
} from 'src/app/core/models/skill.model';

import {
  SkillService
} from 'src/app/core/services/skill.service';

@Component({
  selector: 'app-skill-list',
  templateUrl: './skill-list.component.html',
  styleUrls: ['./skill-list.component.scss']
})
export class SkillListComponent
  implements OnInit {

  skills: Skill[] = [];

  constructor(
    private skillService: SkillService,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.loadSkills();

  }

  loadSkills(): void {

    this.skillService
      .getSkills()
      .subscribe({

        next: (response) => {

          this.skills =
            response.data.content;

        },

        error: (error) => {

          console.log(error);

        }

      });

  }

  editSkill(
    id: number
  ): void {

    this.router.navigate([
      `/admin/skills/edit/${id}`
    ]);

  }

  deleteSkill(
    id: number
  ): void {

    const confirmed =
      confirm(
        'Delete this skill?'
      );

    if (!confirmed) {

      return;

    }

    this.skillService
      .deleteSkill(id)
      .subscribe({

        next: () => {

          alert(
            'Skill deleted!'
          );

          this.loadSkills();

        },

        error: (error) => {

          console.log(error);

        }

      });

  }

}
