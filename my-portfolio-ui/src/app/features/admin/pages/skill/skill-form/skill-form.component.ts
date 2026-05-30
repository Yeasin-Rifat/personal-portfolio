import {
  Component,
  OnInit
} from '@angular/core';

import {
  ActivatedRoute,
  Router
} from '@angular/router';

import {
  Skill
} from 'src/app/core/models/skill.model';

import {
  SkillService
} from 'src/app/core/services/skill.service';

@Component({
  selector: 'app-skill-form',
  templateUrl: './skill-form.component.html',
  styleUrls: ['./skill-form.component.scss']
})
export class SkillFormComponent
  implements OnInit {

  isEditMode = false;

  skillId!: number;

  isSaving = false;

  skill: Skill = {

    name: '',

    percentage: 0,

    category: ''

  };

  constructor(
    private skillService: SkillService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {

    const id =
      this.route.snapshot.paramMap.get('id');

    if (id) {

      this.isEditMode = true;

      this.skillId = +id;

      this.loadSkill();

    }

  }

  loadSkill(): void {

    this.skillService
      .getSkillById(this.skillId)
      .subscribe({

        next: (response) => {

          this.skill =
            response.data;

        },

        error: (error) => {

          console.log(error);

        }

      });

  }

  saveSkill(): void {

    this.isSaving = true;

    const request =
      this.isEditMode
        ? this.skillService
          .updateSkill(
            this.skillId,
            this.skill
          )
        : this.skillService
          .createSkill(
            this.skill
          );

    request.subscribe({

      next: () => {

        this.isSaving = false;

        alert(
          this.isEditMode
            ? 'Skill updated!'
            : 'Skill created!'
        );

        this.router.navigate([
          '/admin/skills'
        ]);

      },

      error: (error) => {

        this.isSaving = false;

        console.log(error);

      }

    });

  }

}
