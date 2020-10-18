import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForgetPswComponent } from './forget-psw.component';

describe('ForgetPswComponent', () => {
  let component: ForgetPswComponent;
  let fixture: ComponentFixture<ForgetPswComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForgetPswComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForgetPswComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
