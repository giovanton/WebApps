import { Injectable } from '@angular/core';
import { from } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from './../../../environments/environment';

const AUTH_API = environment.apiURL + '/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(userlogin: string, password: string): Promise<any>{
    return this.http.post(AUTH_API + 'signin', {
       userlogin, password
      }).toPromise();
  }

  register(username: string, userlogin: string, email: string, password: string): Promise<any>{
    return this.http.post(AUTH_API + 'signup', {
      username, userlogin, email, password
    }, httpOptions).toPromise();
  }
}
