import { Injectable } from '@angular/core';
import { from } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from './../../../environments/environment';

const PLEX_API = environment.apiURL + '/api/plex/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
    providedIn: 'root'
  })
export class PlexService{
    constructor(private http: HttpClient){}

    getLibraries(): Promise<any> {
        return this.http.get(PLEX_API + 'libraries', httpOptions).toPromise();
    }

    getMovies(): Promise<any> {
        return this.http.get(PLEX_API + 'movies', httpOptions).toPromise();
    }

    getRecentlyAdded(): Promise<any> {
        return this.http.get(PLEX_API + 'recently-added', httpOptions).toPromise();
    }

    getRecentlyViewed(): Promise<any> {
        return this.http.get(PLEX_API + 'recently-viewed', httpOptions).toPromise();
    }

    getTvShows(): Promise<any> {
        return this.http.get(PLEX_API + 'tv-shows', httpOptions).toPromise();
    }

    getMusic(): Promise<any> {
        return this.http.get(PLEX_API + 'music', httpOptions).toPromise();
    }
}
