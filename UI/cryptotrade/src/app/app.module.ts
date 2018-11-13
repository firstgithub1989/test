import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { HttpModule} from '@angular/http';
import { AppComponent } from './app.component';
import { TickerComponent } from './ticker/ticker.component';
import { TickerService } from './ticker/ticker.service';
import { GraphComponent } from './graph/graph.component';
import {NvD3Module} from 'ngx-nvd3';
import { RouterModule} from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import 'd3';
import 'nvd3';
import 'ngx-pagination';
import { AuthenticationComponent } from './auth/auth.component';
import { AuthService } from './auth/auth.service';
import { BuysellComponent } from './buysell/buysell.component';
import { BalancesComponent } from './balances/balances/balances.component';
import { BalancesService } from './balances/balances/balances.service';
import { InrwalletComponent } from './balances/inrwallet/inrwallet.component';
import { CoinwalletComponent } from './balances/coinwallet/coinwallet.component';
import { HistoryComponent } from './balances/history/history.component';
import { InrwalletService } from './balances/inrwallet/inrwallet.service';
import { BuySellServicesService } from './buysell/buy-sell-services.service';
import { ProfileComponent } from './profile/profile.component';
import { ProfileService } from './profile/profile.service';
import { AuthGuard } from './auth/auth.guard';
import { HistoryService } from './balances/history/history.service';
import { NgxPaginationModule } from 'ngx-pagination';
import { CoinwalletService } from './balances/coinwallet/coinwallet.service';
import { RegisterComponent } from './auth/register.component';
import { AlertComponent } from './alert/alert.component';
import { AlertService } from './alert/alert.service';
import { BuySellHistoryComponent } from './balances/history/buysellhistory.component';


@NgModule({
  declarations: [
    AppComponent,
    TickerComponent,
    GraphComponent,
    AuthenticationComponent,
    BuysellComponent,
    BalancesComponent,
    InrwalletComponent,
    CoinwalletComponent,
    HistoryComponent,
    ProfileComponent,
    RegisterComponent,
    AlertComponent,
    BuySellHistoryComponent
  ],
  imports: [
    HttpModule,
    BrowserModule,
    HttpClientModule,
    NvD3Module,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    RouterModule.forRoot([
      {
        path: 'app-auth',
        component: AuthenticationComponent
      },
      {
         path: 'graph-cmp',
         component: GraphComponent
      },
      {
        path: '', redirectTo: '/marketplace', pathMatch: 'full'
      },
      {
        path: 'marketplace',
        component: TickerComponent
      },
      {
        path: 'coinwallet',
        component: CoinwalletComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'history',
        component: HistoryComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'buysellhistory',
        component: BuySellHistoryComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'buysell/:fromSym/:toSym/:rate',
        component: BuysellComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'app-profile' ,
        component: ProfileComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'app-register' ,
        component: RegisterComponent
      }
   ])
  ],
  providers: [TickerService, CoinwalletService, AuthService, BalancesService, InrwalletService, HistoryService,
    BuySellServicesService, ProfileService, AuthGuard, AlertService],
  bootstrap: [AppComponent]
})

export class AppModule {

}
