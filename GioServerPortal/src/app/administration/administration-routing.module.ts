import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserEditComponent } from '../administration/users/user-edit/user-edit.component';
import { UsersComponent } from '../administration/users/users.component';
import { AdministrationComponent } from './administration.component';

const adminRoutes: Routes = [
  { 
    path: 'admin', 
    component: AdministrationComponent,
    children: [
      { path: 'users', component: UsersComponent },
      { path: 'user-edit', component: UserEditComponent },
      { path: '', redirectTo:'/admin/users', pathMatch: 'full' }
    ]
   },
];

@NgModule({
  imports: [RouterModule.forChild(adminRoutes)],
  exports: [RouterModule]
})
export class AdministrationRoutingModule { }
