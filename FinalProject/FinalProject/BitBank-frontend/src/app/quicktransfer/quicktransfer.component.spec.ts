import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuicktransferComponent } from './quicktransfer.component';

describe('QuicktransferComponent', () => {
  let component: QuicktransferComponent;
  let fixture: ComponentFixture<QuicktransferComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuicktransferComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuicktransferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
