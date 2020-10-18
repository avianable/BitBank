import { TestBed } from '@angular/core/testing';

import { BenfserviceService } from './benfservice.service';

describe('BenfserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BenfserviceService = TestBed.get(BenfserviceService);
    expect(service).toBeTruthy();
  });
});
