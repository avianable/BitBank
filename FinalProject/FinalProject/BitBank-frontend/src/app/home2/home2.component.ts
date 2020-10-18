import { decimalDigest } from '@angular/compiler/src/i18n/digest';
import { FormsModule } from '@angular/forms';
import {NgForm} from '@angular/forms';

import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { Customer } from '../customer.model';
import { Login } from '../login.model';
import { UserService } from '../services/user.service';

declare const initMap: any;
@Component({
  selector: 'app-home2',
  templateUrl: './home2.component.html',
  styleUrls: ['./home2.component.css']
})
export class Home2Component implements OnInit {
  login:Login;
  customer:Customer;
  message = "";
  
  constructor(private router:Router,private userservice:UserService) { }

  ngOnInit(): void {
    this.login = new Login();
  }

  dashboard()
  {
    this.router.navigate(['/dashboard2']);
  }

  openaccount()
  {
    this.router.navigate(['/open-account'])
  }

  async loggedIn(){
    await this.userservice.login(this.login).then(
      data=> {this.customer= data;},
      error => {
        console.log("exception");
        this.message = "Invalid username and password";
      }
    );
    localStorage.setItem("Customer",JSON.stringify(this.customer));
    localStorage.setItem("FirstName",this.customer.firstName);
    localStorage.setItem("Username",this.customer.userName);
    localStorage.setItem("AccountNumber",String(this.customer.accountNumber));
    this.router.navigate(['/dashboard2']);
    console.log(this.customer.firstName);
  }


  // loginCustomer(){
  //   this.userservice.loginCustomerFromRemote(this.customer).subscribe(
  //     data => {
  //       console.log("response recieved");
  //       this.customer=data;
  //       this.router.navigate(['/dashboard2'])
  //   },
  //   error => {
  //     console.log("exception");
  //     this.message = "Invalid username and password";
  //   }
  // );

    // localStorage.setItem("Customer",JSON.stringify(this.customer));
    // localStorage.setItem("FirstName",this.customer.firstName);
    // localStorage.setItem("Username",this.customer.userName);
    // localStorage.setItem("AccountNumber",String(this.customer.accountNumber));
    // this.router.navigate(['/dashboard2']);
forgetPwd()
{
  this.router.navigate(['/forgetuserid']);
}

  
  
}

