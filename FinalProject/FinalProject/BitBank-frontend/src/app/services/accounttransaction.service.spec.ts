import { TestBed } from '@angular/core/testing';

import { AccounttransactionService } from './accounttransaction.service';

describe('AccounttransactionService', () => {
  let service: AccounttransactionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AccounttransactionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
