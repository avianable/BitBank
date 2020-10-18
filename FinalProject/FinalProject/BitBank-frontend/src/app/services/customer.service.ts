import { Injectable } from '@angular/core';
import {Customer} from '../customer.model';
import { HttpClient, HttpParams } from '@angular/common/http';
import { timeStamp } from 'console';



@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customer : Customer;
  private baseUrl: string = "http://localhost:8080/emp-rest/rest/bit/";
  constructor(private http:HttpClient) { }


  public fetchcustomers() {
      
      return this.http.get<Customer[]>(this.baseUrl + "cust/fetchall");
}

public getPendingCustomerList()
   {
     return this.http.get<Customer[]>(this.baseUrl+"cust/listpending");
   }

 public getActiveCustomerList()
    {
      return this.http.get<Customer[]>(this.baseUrl+"cust/listactive");
    }

    public searchcustomer(accNo: number)
    {
           return this.http.get<Customer>(this.baseUrl+"cust/fetch/"+accNo);
    }

    // public approvePendingCustomer(accountNumber:number)
    // {
      
    //   return this.http.put<Customer>(this.baseUrl+"updatestatus/"+accountNumber+"/active",this.customer);
    // }

    public deletecustomer(accountNumber:number)
    {
      
      return this.http.delete(this.baseUrl+"/cust/delete/"+accountNumber);
    }

    // public pendingcustomer(accountNumber:number)
    // {
    //   return this.http.put<Customer>(this.baseUrl+"updatestatus/"+accountNumber+"/pending",this.customer);
    // }

    setStatus(accountNumber:number,theStatus : string)
  {
      return this.http.put<Customer>(this.baseUrl + "updatestatus/"+accountNumber+"/"+theStatus,this.customer);
  }


  addCustomer(customer:Customer)
    {
      this.http.post(this.baseUrl + "/register/savingsacc",customer).subscribe(data => data = customer);
    }

    getCustomers(listType : string){
      return this.http.get<Customer[]>(this.baseUrl+"cust/list/"+listType); 
  }  


  
}
