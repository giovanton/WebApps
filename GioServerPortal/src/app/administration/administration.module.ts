import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { AdministrationComponent } from '../administration/administration.component';
import { AdministrationRoutingModule } from './administration-routing.module';
import { UsersComponent } from '../administration/users/users.component';
import { UserEditComponent } from '../administration/users/user-edit/user-edit.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

@NgModule({
  declarations: [
    AdministrationComponent,
    UsersComponent,
    UserEditComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    FontAwesomeModule,
    AdministrationRoutingModule,
  ]
})
export class AdministrationModule { }
