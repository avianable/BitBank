import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from '../login.model';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {
 login = new Login;

  constructor(private route:Router) { }

  ngOnInit(): void {
  }
  validate()
  {
    if(this.login.userName=="Arnab" && this.login.password=="bithead" || this.login.userName=="Mitshu" && this.login.password=="bithead")
    {
      this.route.navigate(['/admin']);
    }
  }
}
