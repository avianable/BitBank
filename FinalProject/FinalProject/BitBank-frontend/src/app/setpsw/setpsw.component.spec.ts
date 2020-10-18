import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SetpswComponent } from './setpsw.component';

describe('SetpswComponent', () => {
  let component: SetpswComponent;
  let fixture: ComponentFixture<SetpswComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SetpswComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SetpswComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
