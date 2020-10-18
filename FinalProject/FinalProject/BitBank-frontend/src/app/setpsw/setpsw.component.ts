import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-setpsw',
  templateUrl: './setpsw.component.html',
  styleUrls: ['./setpsw.component.css']
})
export class SetpswComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  submitted():void{
    alert("Password sucessfully Updated");
    this.router.navigate(['/login']);
  }
}
