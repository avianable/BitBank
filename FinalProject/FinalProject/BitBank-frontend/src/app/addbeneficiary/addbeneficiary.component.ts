import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Beneficiary } from '../beneficiary.model';
import { Customer } from '../customer.model';
import { BenfserviceService } from '../services/benfservice.service';

@Component({
  selector: 'app-addbeneficiary',
  templateUrl: './addbeneficiary.component.html',
  styleUrls: ['./addbeneficiary.component.css']
})
export class AddbeneficiaryComponent implements OnInit {
  benef=new Beneficiary;
  accountNumber:number;
  customer:Customer;
   
  constructor(private benefservice:BenfserviceService,private router:Router) {
    this.benef.cust=JSON.parse(localStorage.getItem("Customer"));
  }

  ngOnInit() {
   this.accountNumber=Number(localStorage.getItem("AccountNumber"));
  }
  
  addBeneficiary()
  {
    this.benefservice.save(this.benef);
    alert("Beneficiary Added !!");
    this.router.navigate(['fundtransfer']);
  }

}
