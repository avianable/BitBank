import { Component, OnInit } from '@angular/core';
import { accTransaction } from '../accTransaction.model';
import { Customer } from '../customer.model';
import { AccounttransactionService } from '../services/accounttransaction.service';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-account-statements',
  templateUrl: './account-statements.component.html',
  styleUrls: ['./account-statements.component.css']
})
export class AccountStatementsComponent implements OnInit {
 accTxnList:accTransaction[]=[];
 accountNumber:number;
 customer =new Customer;
  constructor(private txnservice:AccounttransactionService, private custservice : CustomerService) { }

  ngOnInit(): void {
    this.accountNumber=Number(localStorage.getItem("AccountNumber"));
    this.showtransactions();
    this.fetchcustomer();
  }
 showtransactions()
 {
    this.txnservice.showtransactions(this.accountNumber).subscribe(data=> this.accTxnList=data);
    console.log(this.accTxnList.length);
 }
 

 fetchcustomer()
 {
   this.custservice.searchcustomer(this.accountNumber).subscribe(data=>this.customer=data);
   
 }


}
