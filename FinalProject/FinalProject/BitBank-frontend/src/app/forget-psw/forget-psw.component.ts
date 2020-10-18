import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forget-psw',
  templateUrl: './forget-psw.component.html',
  styleUrls: ['./forget-psw.component.css']
})
export class ForgetPswComponent implements OnInit {
  public otp="";
  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  myFunction():void {
    this.otp="OTP has been sent to your registered mobile number"
    }
    btnClick= function () {
      this.router.navigate(['/login']);
    }
  submitted():void{
    alert("Pass");
    this.router.navigate(['/setpsw']);
  }
}
