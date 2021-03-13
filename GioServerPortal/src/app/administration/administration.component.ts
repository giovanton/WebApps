import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { faArrowLeft } from '@fortawesome/free-solid-svg-icons';
import { UserService } from '../administration/users/user.service';

@Component({
  selector: 'app-administration',
  templateUrl: './administration.component.html',
  styleUrls: ['./administration.component.css']
})
export class AdministrationComponent implements OnInit {
  opened = false;
  faArrowLeft = faArrowLeft;
  constructor(public userService: UserService) { }

  ngOnInit(): void {
  }

  closeSidenav(): void{
    this.userService.opened = false;
  }

}
