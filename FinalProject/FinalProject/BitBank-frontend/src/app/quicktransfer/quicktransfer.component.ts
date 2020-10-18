import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { send } from 'process';
import { checkServerIdentity } from 'tls';
import { accTransaction } from '../accTransaction.model';
import { Beneficiary } from '../beneficiary.model';
import { AccounttransactionService } from '../services/accounttransaction.service';

@Component({
  selector: 'app-quicktransfer',
  templateUrl: './quicktransfer.component.html',
  styleUrls: ['./quicktransfer.component.css']
})
export class QuicktransferComponent implements OnInit {
 acctxn=new accTransaction;
 beneficiary=new Beneficiary;
 benefAccountNumber:number;
 customer_accountNumber:number;
 message:string;
 

  constructor(private accountservice:AccounttransactionService,private router:Router) { }

  ngOnInit() {
    this.beneficiary=JSON.parse(localStorage.getItem("Beneficiary"));
    console.log(this.beneficiary.benefAccountNumber)
    this.customer_accountNumber=Number(localStorage.getItem("AccountNumber"));
    this.message="";
  }

  async sendmoney()
  {
      //  console.log(this.acctxn.amount);
      //  console.log(this.beneficiary.benef_accountNumber);
      //  console.log(this.customer_accountNumber);
      //  console.log(this.acctxn.remarks);
      await this.accountservice.sendmoney(this.customer_accountNumber,this.beneficiary.benefAccountNumber,this.acctxn.txnAmount).subscribe(
        data=> {
                  this.router.navigate(['/accountstatement']);},
        error => {
          console.log("exception");
          this.message = error;
          ;
        }
      );
       //this.message=localStorage.getItem("Error");
        
       
       
  }
   
 check(input) {
    if (input.value == 0) {
      input.setCustomValidity('The number must not be zero.');
    } else {
      // input is fine -- reset the error message
      input.setCustomValidity('');
    }
  }
 

}
