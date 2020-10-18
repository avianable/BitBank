import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { accTransaction } from '../accTransaction.model';
import { Beneficiary } from '../beneficiary.model';
import { Customer } from '../customer.model';
import { AccounttransactionService } from '../services/accounttransaction.service';
import { BenfserviceService } from '../services/benfservice.service';

@Component({
  selector: 'app-fundstransfer',
  templateUrl: './fundstransfer.component.html',
  styleUrls: ['./fundstransfer.component.css']
})
export class FundstransferComponent implements OnInit {
accountNumber:Number;
accountTxn=new accTransaction;
customer = new Customer;
beneficiary= new Beneficiary;
testBenefList: Beneficiary[] = [];
senderaccountNumber:number;
message="";

  constructor(private benefservice:BenfserviceService,private router:Router,private accTxnService:AccounttransactionService) { }

  ngOnInit() {
    this.accountNumber=Number(localStorage.getItem("AccountNumber"));
    
    this.showbeneficiaries();
  }


  showbeneficiaries()
  {
    this.benefservice.fetchbeneficiaires(this.accountNumber).subscribe(data=> this.testBenefList=data);
  }
  // getSelecteditem(){
  //   this.beneficiary = this.testBenefList.find(Beneficiary => Beneficiary.benef_accountNumber === this.radioSelectednumber);
  //   this.radioSelectednumber = Number(JSON.stringify(this.beneficiary));
  //   localStorage.setItem("Benef_AccNumber",String(this.radioSelectednumber));
  // }

  // onItemChange(benef){
  //   this.getSelecteditem();
  // }
  send(benefAccountNumber:number){
    this.beneficiary = this.testBenefList.find(Beneficiary => Beneficiary.benefAccountNumber === benefAccountNumber);
    console.log(this.beneficiary.benefAccountNumber);
    localStorage.setItem("Beneficiary",JSON.stringify(this.beneficiary));
   this.router.navigate(['quicktransfer'])
  }

  sendmoneytoaccount()
  {

    this.accTxnService.sendmoney(this.accountNumber,this.senderaccountNumber,this.accountTxn.txnAmount).subscribe(
      data=> {
                this.router.navigate(['/accountstatement']);
              },
      error => {
        console.log("exception");
        this.message = error;
        ;
      }
    );
     
    alert("Money Sent Sucessful");

  }


}
