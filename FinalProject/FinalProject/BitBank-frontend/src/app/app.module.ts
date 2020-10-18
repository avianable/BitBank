import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AgmCoreModule } from '@agm/core';
import {RouterModule,Router} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FundstransferComponent } from './fundstransfer/fundstransfer.component';
import { AddbeneficiaryComponent } from './addbeneficiary/addbeneficiary.component';
import { QuicktransferComponent } from './quicktransfer/quicktransfer.component';
import { TxnsummaryComponent } from './txnsummary/txnsummary.component';
import { HomeComponent } from './home/home.component';
import {Dashboard2Component} from './dashboard/dashboard2.component';
import { NavMenuComponent } from './nav-menu/nav-menu.component';
import { SetpswComponent } from './setpsw/setpsw.component';
import { AccountDetailsComponent } from '../app/account-details/account-details.component';
import { AccountStatementsComponent } from '../app/account-statements/account-statements.component';
import { OpenAccountComponent } from '../app/open-account/open-account.component';
import { AdminComponent } from './admin/admin.component';
import { Home2Component } from './home2/home2.component';
import { RegisterComponent } from './register/register.component';
import { PaymentComponent } from './payment/payment.component';
import { FaqComponent } from './faq/faq.component';
import { ForgetUserIdComponent } from './forget-user-id/forget-user-id.component';
import { ProfileComponent } from './profile/profile.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FundstransferComponent,
    AddbeneficiaryComponent,
    QuicktransferComponent,
    TxnsummaryComponent,
    HomeComponent,
    NavMenuComponent,
    SetpswComponent,
    AccountDetailsComponent,
    AccountStatementsComponent,
    OpenAccountComponent,
    Home2Component,
    Dashboard2Component,
    RegisterComponent,
    AdminComponent,
    PaymentComponent,
    ForgetUserIdComponent,
    ProfileComponent,
    FaqComponent,
    AdminloginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
      apiKey:'AIzaSyDoZg2Es_GrQHZf_52j2-xZ3cTfBCR0HII'}),
    HttpClientModule
     
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
