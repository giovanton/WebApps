import { Component, OnInit } from '@angular/core';
import { faThermometerThreeQuarters } from '@fortawesome/free-solid-svg-icons';
import { TokenStorageService } from './Common/Services/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private roles: string[] = [];
  title = 'GioServerPortal';
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username?: string;

  constructor(private tokenStorageService: TokenStorageService) {}

  ngOnInit(): void{
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROL_ADMINISTRADOR');
      this.showModeratorBoard = this.roles.includes('ROL_MODERADOR');

      this.username = user.userName;
    }
  }

  logout(): void{
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}
