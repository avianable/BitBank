import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ForgetPswComponent } from './forget-psw/forget-psw.component';
import { ForgetUserIdComponent } from './forget-user-id/forget-user-id.component';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import { SetpswComponent } from './setpsw/setpsw.component';
import { RegisterComponent } from './register/register.component';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { OpenAccountComponent } from './open-account/open-account.component';
import { ProfileComponent } from './profile/profile.component';
import { Dashboard2Component } from './dashboard/dashboard2.component';
import { AccountStatementsComponent } from './account-statements/account-statements.component';
import { Home2Component } from './home2/home2.component';
import { AdminComponent } from './admin/admin.component';
import { FundstransferComponent } from './fundstransfer/fundstransfer.component';
import { AddbeneficiaryComponent } from './addbeneficiary/addbeneficiary.component';
import { QuicktransferComponent } from './quicktransfer/quicktransfer.component';
import { TxnsummaryComponent } from './txnsummary/txnsummary.component';
import { FaqComponent } from './faq/faq.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';


const routes: Routes = [
  {path: "home", component: Home2Component},
  {path:"admin" ,component:AdminComponent},
  {path: '', component: Home2Component, pathMatch: 'full'},
  {path: 'login', component: LoginComponent },
  {path:'register',component:RegisterComponent},
  {path:'forgetpsw' ,component: ForgetPswComponent },
  {path:'faq',component:FaqComponent},
  {path:'adminlogin',component:AdminloginComponent},
  {path:'forgetuserid' ,component: ForgetUserIdComponent },
  {path:'setpsw',component:SetpswComponent},
  {path:'addbeneficiary',component:AddbeneficiaryComponent},
  {path:'accountdetails',component:AccountDetailsComponent},
  {path:'accountstatement',component:AccountStatementsComponent},
  {path:'profile',component:ProfileComponent},
  {path:'quicktransfer',component:QuicktransferComponent},
  {path:'txnsummary',component:TxnsummaryComponent},
  {path:'fundtransfer',component:FundstransferComponent},
  {path:'open-account',component:OpenAccountComponent},
  {path:'dashboard2',component:Dashboard2Component}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
