import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { CATCH_ERROR_VAR } from '@angular/compiler/src/output/output_ast';
import { Injectable } from '@angular/core';
import { accTransaction } from '../accTransaction.model';
import {catchError, retry} from 'rxjs/operators';
import { error } from 'console';
import { Observable, throwError } from 'rxjs';
import { $ } from 'protractor';


@Injectable({
  providedIn: 'root'
})
export class AccounttransactionService {
  private baseUrl: string = "http://localhost:8080/emp-rest/rest/bit/";
  acctxn:accTransaction;
  message:string="";

  constructor(private http:HttpClient) { }

public sendmoney(customer_accountNumber,benef_accountNumber,amount)
{
  // console.log(amount);
  // console.log(benef_accountNumber);
  // console.log(customer_accountNumber);
      //  console.log(this.acctxn.remarks);
      this.message="";
      
        return this.http.post(this.baseUrl+"transfer/"+customer_accountNumber+"/"+benef_accountNumber+"/"+amount,null).pipe(catchError(this.handleError));
  //    {
  //      response=>alert('Incorect Amount');
  //    }
  //  );
   
}


public showtransactions(accountNumber:Number)
{
  console.log()
 return this.http.get<accTransaction[]>(this.baseUrl + "statement/"+accountNumber);
}
 
handleError(error:HttpErrorResponse){
  let errorMessage="";
  if(error.error instanceof ErrorEvent)
  {
     errorMessage=`Error : ${error.error.message}`;
     
  } else{
    errorMessage=`ErrorCode : ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage||'Insufficients Fund');

  }
  

 

}
