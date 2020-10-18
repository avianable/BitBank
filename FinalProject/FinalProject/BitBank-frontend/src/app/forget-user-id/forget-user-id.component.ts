import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer.model';
import { OTP } from '../OTP.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-forget-user-id',
  templateUrl: './forget-user-id.component.html',
  styleUrls: ['./forget-user-id.component.css']
})
export class ForgetUserIdComponent implements OnInit {
  testcust = new Customer;
  
  flag:boolean;
  signup:boolean;
  otp=new OTP;
  otpserve=new OTP;
  message="";
  errormessage="";

  constructor(private userservice:UserService,private router:Router) { }

  ngOnInit(): void {
    this.flag=true;
    this.signup=false;
  }

  async sendOTP()
 {
   console.log("Send OTP");
   await this.userservice.sendOTP(this.testcust.accountNumber).then(
      data=> {this.otpserve=data;},
      error => {
        console.log("exception");
        this.errormessage="Invalid Account Number";
      }
    );
    

    
    this.flag=false;
    
    this.message="OTP Has been sent";
    this.signup=true;
 }

update()
{
  console.log(this.otpserve.otpMessage);
  if(this.otp.otpMessage==this.otpserve.otpMessage)
  {
  this.userservice.updatepassword(this.testcust.accountNumber,this.testcust).then(
    data=>{this.testcust=data;},
    error=>{
      console.log("exception");

      
    }
  );
  alert("Updated Password")
}
else
{
  this.message="Invalid OTP";
}
}




}
