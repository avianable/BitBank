import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { Customer } from '../customer.model';
import { CustomerService } from '../services/customer.service';
import { AccounttransactionService } from '../services/accounttransaction.service';
import { accTransaction } from '../accTransaction.model';

@Component({
  selector: 'app-txnsummary',
  templateUrl: './txnsummary.component.html',
  styleUrls: ['./txnsummary.component.css']
})
export class TxnsummaryComponent implements OnInit {
  accTxnList:accTransaction[]=[];
  accountNumber:number;
  customer =new Customer;
  constructor(private txnservice:AccounttransactionService, private custservice : CustomerService) { }


  ngOnInit() {
    this.accountNumber=Number(localStorage.getItem("AccountNumber"));
   this.fetchcustomer();
  }
  fetchcustomer()
  {
    this.custservice.searchcustomer(this.accountNumber).subscribe(data=>this.customer=data);
    
  }

}
