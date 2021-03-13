import { Injectable } from '@angular/core';
import { from } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../../Common/Models/user';
import { environment } from './../../../environments/environment';
import { Role } from 'src/app/Common/Models/role';

const baseUrl = environment.apiURL + '/api';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  selectedUser: User = {};
  opened = false;
  users: User[] = [];
  constructor(private http: HttpClient) { }

  getUsers(): Promise<User[]>{
    return this.http.get<User[]>( baseUrl + '/users', httpOptions).toPromise();
  }

  create(user: User): Promise<User>{
    return this.http.post<User>(baseUrl + '/users', user, httpOptions).toPromise();
  }

  update(user: User): Promise<User>{
    return this.http.put<User>(`${baseUrl}/users/${user.userGuid}`, user, httpOptions).toPromise();
  }

  searchUser(name: string): Promise<User[]>{
    return this.http.get<User[]>(`${baseUrl}/users?name=${name}`, httpOptions).toPromise();
  }

  getRoles(): Promise<Role[]> {
    return this.http.get<Role[]>(baseUrl + '/roles').toPromise();
  }
}
