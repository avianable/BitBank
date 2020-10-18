import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer.model';
import { CustomerService } from '../services/customer.service';

@Component({
  selector: 'app-dashboard2',
  templateUrl: './dashboard2.component.html',
  styleUrls: ['./dashboard2.component.css']
})
export class Dashboard2Component implements OnInit {
  username:string;
  custName:string;
  customer:Customer;
  accountnumber:number;
  constructor(private custservice:CustomerService) { }

  ngOnInit(): void {
    this.accountnumber=Number(localStorage.getItem("AccountNumber"));
    this.fetchcustomer();
    this.custName=localStorage.getItem("FirstName");
    this.username=localStorage.getItem("Username");
    this.accountnumber=Number(localStorage.getItem("AccountNumber"));
  }

  fetchcustomer()
 {
   this.custservice.searchcustomer(this.accountnumber).subscribe(data=>this.customer=data);
   
 }

}
