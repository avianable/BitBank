import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer.model';
import { OTP } from '../OTP.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {  
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
 async signUp()
 {
    
   if(this.otp.otpMessage==this.otpserve.otpMessage)
   {
     console.log(this.testcust.accountNumber);
     console.log(this.testcust.userName);
     console.log(this.testcust.password);
     await this.userservice.updateuser(this.testcust.accountNumber,this.testcust).subscribe(
        data=> {data=>this.testcust=data},
        error => {
          console.log("exception");
          this.errormessage="User not Active";
        }
      );
      alert("user sucessfully registered");
      this.router.navigate(['home']);
   }
   else
   {
     this.message="Invalid OTP Please retry"
   }
 }


 

}
