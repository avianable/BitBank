import { Injectable } from '@angular/core';
// import { Beneficiary } from '../beneficiary.model';
import { Customer } from '../customer.model';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http'; 
import { Observable } from 'rxjs';
import { Beneficiary } from '../beneficiary.model';

@Injectable({
  providedIn: 'root'
})
export class BenfserviceService {

  private baseUrl: string = "http://localhost:8080/emp-rest/rest/bit/";

  constructor(private router: Router, private http: HttpClient) { }

  // searchCustomer(id: number): Observable<Customer>
  // {
  //   return this.http.get<Customer>(this.baseUrl+"/fetchactive/"+id); 
  // }
  // getCustomerList()
  // {
  //   return this.http.get<Customer[]>(this.baseUrl+"/cust/fetchall/");
  // }
  // getActiveCustomerList()
  // {
  //   return this.http.get<Customer[]>(this.baseUrl+"/cust/listactive");
  // }
  // 
  // addCustomer(customer:Customer)
  //   {
  //     this.http.post(this.baseUrl + "/add",customer).subscribe(data => data = customer);
  //   }
  public fetchbeneficiaires(accountNumebr:Number) {
      
    return this.http.get<Beneficiary[]>(this.baseUrl + "fetchbenef/"+accountNumebr);
}
save(benef:Beneficiary) {
  this.http.post(this.baseUrl + "addbenef", benef).subscribe(data => data = benef);
}


}


