import { Component, OnInit } from '@angular/core';
import { User } from '../../Common/Models/user';
import { UserService } from '../users/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  name = '';

  constructor(public userService: UserService) { }

  ngOnInit(): void {
    this.retrieveUsers();
  }

  async retrieveUsers(): Promise<void>{
    this.userService.users = await this.userService.getUsers();
  }

  setSelectedUser(user: User): void{
    this.userService.selectedUser = user;
    this.userService.opened = true;
  }

  newUser(): void{
    const selectedUser = new User();
    selectedUser.createdBy = '0000-0000-0000-0000';
    selectedUser.modifiedBy = '0000-0000-0000-0000';
    this.userService.selectedUser = selectedUser;
    this.userService.opened = true;
  }

  async search(): Promise<void>{
    this.userService.users = await this.userService.searchUser(this.name);
  }
}
