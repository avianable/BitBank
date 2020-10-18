import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { Customer } from '../customer.model';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent implements OnInit {
customer:Customer;
accountNumber:number;
  constructor(private custservice:CustomerService) { }

  ngOnInit(): void {
    this.accountNumber=Number(localStorage.getItem("AccountNumber"));
   this.fetchcustomer();
  }

  fetchcustomer()
 {
   this.custservice.searchcustomer(this.accountNumber).subscribe(data=>this.customer=data);
   
 }
}
