import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TxnsummaryComponent } from './txnsummary.component';

describe('TxnsummaryComponent', () => {
  let component: TxnsummaryComponent;
  let fixture: ComponentFixture<TxnsummaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TxnsummaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TxnsummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
