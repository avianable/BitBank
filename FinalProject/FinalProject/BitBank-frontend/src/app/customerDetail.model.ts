import { Customer } from './customer.model';

export class CustomerDetail{
    public aadharNumber : string;
	public panNumber : string;
	public mobileNumber : string;  	 
	public age : number; 	
	public occupationType : string;
	public incomeSource : string;
	public annualIncome : string;
    public netBanking : string; 
	public street : string;
	public city : string;
	public state : string;
	public pincode : number;
	public cust : Customer; 
}