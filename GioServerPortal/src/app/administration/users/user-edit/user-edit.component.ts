import { Component, Input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../../../Common/Models/user';
import { Role } from '../../../Common/Models/role';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {
roles: Role[] = [];
user: User = {};
submitted = false;

  constructor(public userService: UserService, private route: ActivatedRoute,
              private router: Router) { }

  async ngOnInit(): Promise<void> {
    this.roles = await this.userService.getRoles();
  }

  async saveUser(): Promise<void>{
    this.user = this.userService.selectedUser;
    this.user.createdBy = '0000-0000-0000-0000';
    this.user.modifiedBy = '0000-0000-0000-0000';
    let savedUser = new User();
    if (this.user.userGuid){
      savedUser = await this.userService.update(this.user);
    }else{
      savedUser = await this.userService.create(this.user);
    }

    const idx = this.userService.users.findIndex(x => x.userGuid === savedUser.userGuid);
    if (idx > -1){
      this.userService.users.splice(idx, 1, savedUser);
    }else{
      this.userService.users.push(savedUser);
    }
  }

  hasRole(role: Role): boolean {
    let hasRole = false;
    if (this.userService.selectedUser && this.userService.selectedUser.roles){
      hasRole = this.userService.selectedUser.roles.some(x => x.id === role.id);
    }
    return hasRole;
  }

  setRole(role: Role, ev: any): void{
    if (!this.userService.selectedUser.roles) { this.userService.selectedUser.roles = []; }
    if (ev.target.checked && !this.userService.selectedUser.roles.some(r => r.id === role.id)) {
      this.userService.selectedUser.roles.push(role);
    }else{
      const idx = this.userService.selectedUser.roles.findIndex(r => r.id === role.id);
      this.userService.selectedUser.roles.splice(idx, 1);
    }
  }
}
