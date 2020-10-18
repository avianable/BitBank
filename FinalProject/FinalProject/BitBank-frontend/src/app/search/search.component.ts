import { Component, OnInit } from '@angular/core';
import { Beneficiary } from '../beneficiary.model';
import { Customer } from '../customer.model';
import { BenfserviceService } from '../services/benfservice.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  id: number;
  testBenf : Beneficiary;
  testCust : Customer;
  testCustList: Customer[] = [];



  b1 : Beneficiary =  
  {
    beneficiaryId:121,
    firstName:"Tushar",
    lastName:"Kadam",
    benef_accountNumber:20345791614,
    act:{
      transactionId:12123,
      amount:11,
      debitAmount:11,
      creditAmount:12,
      transactionDate: new Date(),
      transferMode:"NEFT",
      remarks:"Good transaction"
    }
  };  
  
  constructor(private service: BenfserviceService) { }

  ngOnInit() {
      this.service.getCustomerList().subscribe(data => this.testCustList = data);
  }

  searchBenf()
  {       
    this.service.searchCustomer(this.id).subscribe(data => this.testCust = data);
  }

}
