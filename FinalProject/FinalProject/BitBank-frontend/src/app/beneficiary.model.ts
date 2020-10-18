import { accTransaction } from './accTransaction.model';
import { Customer } from './customer.model';

export class Beneficiary{
    public firstName : string;
    public lastName : string;
    public benefAccountNumber : number;
    public bank:string;
    public branch:string;
    public cust: Customer ;
    public act : accTransaction;
}