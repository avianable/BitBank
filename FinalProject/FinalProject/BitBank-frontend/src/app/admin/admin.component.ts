import { Component, OnInit } from '@angular/core';
import { Beneficiary } from '../beneficiary.model';
import {Customer} from '../customer.model';
import { BenfserviceService } from '../services/benfservice.service';
import { FormsModule } from '@angular/forms';
import { CustomerService } from '../services/customer.service';
import {Inject} from '@angular/core';
import {DOCUMENT} from '@angular/common';
import { CustomerDetail } from '../customerDetail.model';
import { CustomerdetailsService } from '../services/customerdetails.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  id: number;
  testBenf : Beneficiary;
  testCust : Customer;
  testAddCust = new Customer; 
  testCustList: Customer[] = [];
  testActiveCustList: Customer[] = [];
  testPendingCustList: Customer[] = [];
  testCustDetail:CustomerDetail;
  testCustDetaillist : CustomerDetail[] = [];
  admin : boolean = false;
  all : boolean;
  pending : boolean;
  active : boolean;
  inactive : boolean;
  count : number;  
  // this.testCustList.length;
  constructor(private service: BenfserviceService,private custservice:CustomerService,@Inject(DOCUMENT)private document:Document,private custdetailservice:CustomerdetailsService) { }

  ngOnInit() {
    // this.showPendingCustomers();
    this.showCustomers("pending",false,true,false,false);
  } 
  refreshpage()
{
   this.document.location.reload();
   
}
setAllPendingActive(all:boolean,pending:boolean,active:boolean,inactive:boolean){
  this.all=all;
  this.pending=pending;
  this.active=active;
  this.inactive=inactive;
}


  // showAllCustomers(){
  //   this.all=true;
  //   this.active=false;
  //   this.pending=false;
  //   console.log(this.testCustList);
  //   this.custservice.fetchcustomers().subscribe(data => this.testCustList=data);
  //   this.count = this.testCustList.length;
  //   // this.testCustList.length;
  // }
  



  //   showActiveCustomers(){
  //     this.active = true;
  //     this.all=false;
  //     this.pending=false;
  //       this.custservice.getActiveCustomerList().subscribe(data => this.testCustList = data);
  //   }

  //  showPendingCustomers(){
  //    this.pending = true;
  //    this.all = false;
  //    this.active = false;
  //    this.custservice.getPendingCustomerList().subscribe(data=>this.testCustList=data);
     
  //  }

  //  searchBenf()
  //  {       
  //    this.service.searchCustomer(this.id).subscribe(data => this.testCust = data);
  //  }

  // saveCustomer(){
  //   this.service.addCustomer(this.testAddCust);
  //   this.showAllCustomers();
   
  // }

  setCustomerStatus(accountNumber : number,status : string)
    {
     this.custservice.setStatus(accountNumber,status).subscribe(data => this.testCust=data);
     this.refreshpage();
    }
  // approvedcustomer(accountNumber:number)
  // {
  //   // this.custservice.searchcustomer(accountNumber).subscribe(data=>this.testCust=data);
  //     this.custservice.approvePendingCustomer(accountNumber).subscribe(data =>this.testCust=data);
  //     this.refreshpage();
  // }
  deletecustomer(accountNumber:number)
  {
    this.custservice.deletecustomer(accountNumber).subscribe();
    this.refreshpage();
  }

  // onholdcustomer(accountNumber:number)
  // {
  //   // this.custservice.searchcustomer(accountNumber).subscribe(data=>this.testCust=data);
  //     this.custservice.pendingcustomer(accountNumber).subscribe(data =>this.testCust=data);
  //     this.refreshpage();
  // }
  showCustomers(theListType : string,allFlag:boolean,pendingFlag:boolean,activeFlag:boolean,inactiveFlag:boolean){
    this.custservice.getCustomers(theListType).subscribe(data => this.testCustList = data);
    this.setAllPendingActive(allFlag,pendingFlag,activeFlag,inactiveFlag);
    this.count = this.testCustList.length;  
  }
}  