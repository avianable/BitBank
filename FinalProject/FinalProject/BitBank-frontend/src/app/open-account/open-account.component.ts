import { Component, Inject, OnInit } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { Customer } from '../customer.model';
import { CustomerDetail } from '../customerDetail.model';
import { CustomerdetailsService } from '../services/customerdetails.service';
import { CustomerService } from '../services/customer.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-open-account',
  templateUrl: './open-account.component.html',
  styleUrls: ['./open-account.component.css']
})
export class OpenAccountComponent implements OnInit {
  testAddCust = new Customer;
  testAddCustDetail = new CustomerDetail;
  
   

  constructor(@Inject(DOCUMENT)private document:Document,private custservice:CustomerService,private router:Router){
     
   }

  ngOnInit(): void {
  }

  refreshPage()
  {
    this.document.location.reload();
  }
  saveCustomer(){ 
    
    this.testAddCust.custDetails = this.testAddCustDetail;
    this.custservice.addCustomer(this.testAddCust);
    alert("You have Sucessfully Registered");
    this.router.navigate(['home']);
    
  }
   
}

