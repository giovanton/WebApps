import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdministrationModule } from './administration/administration.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';

import { authIntercerptorProviders } from './Common/Helpers/auth.interceptor';
import { from } from 'rxjs';
import { LoginComponent } from './login/login.component';
import { UserBoardComponent } from './user-board/user-board.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    PageNotFoundComponent,
    LoginComponent,
    UserBoardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AdministrationModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [authIntercerptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
