import { logging } from 'protractor';

import { accTransaction } from './accTransaction.model';
import { Beneficiary } from './beneficiary.model';
import { CustomerDetail } from './customerDetail.model';

export class Customer{
  public accountNumber : number;
	public userName : string;
	public password : string;
	public accountBalance : number; 
	public firstName : string;
	public lastName : string;
	public middleName:string;
	public email:string;
	public status : string; 
	public custDetails : CustomerDetail;
    public beneficiaryList : Beneficiary[];
	public txnList : accTransaction[];
}