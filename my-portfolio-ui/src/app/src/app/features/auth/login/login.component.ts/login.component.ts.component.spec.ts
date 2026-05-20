import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponentTsComponent } from './login.component.ts.component';

describe('LoginComponentTsComponent', () => {
  let component: LoginComponentTsComponent;
  let fixture: ComponentFixture<LoginComponentTsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponentTsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginComponentTsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
