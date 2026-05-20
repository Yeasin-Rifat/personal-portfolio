import { Component, OnInit } from '@angular/core';

import { Skill } from 'src/app/core/models/skill.model';

import { SkillService } from 'src/app/core/services/skill.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.scss']
})
export class SkillsComponent
  implements OnInit {

  skills: Skill[] = [];

  constructor(
    private skillService: SkillService
  ) { }

  ngOnInit(): void {

    this.loadSkills();
  }

  loadSkills(): void {

    this.skillService.getSkills()
      .subscribe({

        next: (response) => {

          this.skills = response.data.content;

          console.log(this.skills);
        },

        error: (error) => {

          console.log(error);
        }

      });
  }

}
