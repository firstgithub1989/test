import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { HttpModule} from '@angular/http';
import { AppComponent } from './app.component';
import { TickerComponent } from './ticker/ticker.component';
import { TickerService } from './ticker.service';
import {Ticker} from './common/Ticker';
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
import { BalancesComponent } from './balances/balances.component';
import { BalancesService } from './balances/balances.service';
import { InrwalletComponent } from './balances/inrwallet/inrwallet.component';
import { CoinwalletComponent } from './balances/coinwallet/coinwallet.component';
import { HistoryComponent } from './balances/history/history.component';
import { InrwalletService } from './balances/services/inrwallet.service';
import { BuySellServicesService } from './buysell/buy-sell-services.service';
import { ProfileComponent } from './profile/profile.component';
import { ProfileService } from './profile/profile.service';
import { AuthGuard } from './auth/auth.guard';
import { HistoryService } from './balances/services/history.service';
import { NgxPaginationModule } from 'ngx-pagination';
import { CoinwalletService } from './balances/services/coinwallet.service';


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
    ProfileComponent
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
        path: 'inrwallet',
        component: InrwalletComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'buysell/:fromSym/:toSym',
        component: BuysellComponent,
        canActivate: [AuthGuard]
      },
      {
        path: 'app-profile' ,
        component: ProfileComponent,
        canActivate: [AuthGuard]
      }
   ])
  ],
  providers: [TickerService, CoinwalletService, AuthService, BalancesService, InrwalletService, HistoryService,
    BuySellServicesService, ProfileService, AuthGuard],
  bootstrap: [AppComponent]
})

export class AppModule {

}
