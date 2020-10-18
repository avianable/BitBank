import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import {CustomerDetail} from '../customerDetail.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerdetailsService {
  private baseUrl: string = "http://localhost:8080/emp-rest/rest/bit/";
  
  constructor(private http:HttpClient) { }


  public fetchcustomerdetails(accountNo:Number) {
      
    return this.http.get<CustomerDetail[]>(this.baseUrl + "cust/fetchdetails/"+accountNo);
}
}
