import { HttpClientModule } from '@angular/common/http';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../customer.model';
import { Login } from '../login.model';
import { LoginComponent } from '../login/login.component';
import { Observable } from 'rxjs';
import { OTP } from '../OTP.model';



@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl: string = "http://localhost:8080/emp-rest/rest/bit/";
  otpserver=new OTP;
  otpmessage:string;
  customer:Customer;
  constructor(private http:HttpClient) { }


   login(login : Login) : Promise<Customer> {
     const params = new HttpParams().append('username',login.userName)
    .append('password',login.password);
          let result=this.http.get<Customer>(this.baseUrl+"loginvalidate",{params:params}).toPromise();
          return result;
  }

  public loginCustomerFromRemote(customer : Customer): Observable<any>{
    return this.http.post<any>(this.baseUrl+"login",customer);
  }
   
  public sendOTP(accountNumber:number):Promise<OTP>{
    console.log(accountNumber);
    let otp= this.http.get<OTP>(this.baseUrl+"otp-forget-id-pass/"+accountNumber).toPromise();
    console.log(otp);
    return otp;


  }
  
  public updateuser(accountNumber:number,cust:Customer)
  {
  
    return this.http.put<Customer>(this.baseUrl + "register/netbanking/" + accountNumber, cust);
  }


  public updatepassword(accountNumber:number,cust:Customer):Promise<Customer>
  {
    return this.http.put<Customer>(this.baseUrl+"/update-uname-pwd/"+accountNumber,cust).toPromise();
   
  }
}
