import { Component, OnInit } from '@angular/core';
import { AuthService } from '../Common/Services/auth.service';
import { TokenStorageService } from '../Common/Services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: any = {
    userlogin: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private authService: AuthService, private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenStorageService.getToken()){
      this.isLoggedIn = true;
      this.roles = this.tokenStorageService.getUser().roles;
    }
  }

  onSubmit(): void{
    const { userlogin, password } = this.form;

    this.authService.login(userlogin, password).then(data => {
      this.tokenStorageService.saveToken(data.accessToken);
      this.tokenStorageService.saveUser(data);

      this.isLoginFailed = false;
      this.isLoggedIn = true;
      this.roles = this.tokenStorageService.getUser().roles;
      this.reloadPage();
    }
    );
  }

  reloadPage(): void{
    window.location.reload();
  }
}
