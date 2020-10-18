import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  customer =new Customer;
  updatedcustomer =new Customer;
  message:string;
  constructor(private userservice:UserService) { }

  ngOnInit(): void {
    this.message="";
  this.customer=JSON.parse(localStorage.getItem("Customer"));
  }

  updatepassword()
  {
    console.log(this.customer.password);
    console.log(this.updatedcustomer.password);
    if(this.customer.password==this.updatedcustomer.password)
    {
      this.userservice.updatepassword(this.customer.accountNumber,this.updatedcustomer).then(
        data=>{this.customer=data;},
        error=>{
          console.log("exception");
    
          
        }
      );

      alert("Password Updated");
    }
    else{
      
    }
  }

}
