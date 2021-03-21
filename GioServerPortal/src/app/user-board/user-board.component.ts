import { Component, OnInit } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';
import { PlexService } from '../Common/Services/plex.service';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-user-board',
  templateUrl: './user-board.component.html',
  styleUrls: ['./user-board.component.css'],
  providers: [NgbCarouselConfig]
})
export class UserBoardComponent implements OnInit {
  images = [1, 2, 3].map((n) => `../../assets/img/id/${n}.jpg`);
  recentlyAdded: any[] = [];
  recentlyViewed: any[] = [];
  movies: any[] = [];
  tvShows: any[] = [];
  songs: any[] = [];
  url = 'http://gioserver.giogalnet.es:32400/web/index.html';
  urlSafe!: SafeResourceUrl;

  constructor(config: NgbCarouselConfig, private plexService: PlexService, private sanitizer: DomSanitizer) {
    config.interval = 3000;
  }

  async ngOnInit(): Promise<void> {
    this.urlSafe = this.sanitizer.bypassSecurityTrustResourceUrl(this.url);
    // this.libraries = await this.plexService.getLibraries();
    const addedMediaContainer = await this.plexService.getRecentlyAdded();
    const viewedMediaContainer = await this.plexService.getRecentlyViewed();
    // tslint:disable-next-line: no-string-literal
    this.recentlyViewed = viewedMediaContainer.MediaContainer.Metadata;
    const showsMediaContainer = await this.plexService.getTvShows();
    // const musicMediaContainer = await this.plexService.getMusic();
    addedMediaContainer.MediaContainer.Metadata.forEach((x: any) => {
      if (x.librarySectionID === 1) {
        this.movies.push(x);
      }
      if (x.librarySectionID === 2) {
        this.tvShows.push(x);
      }
      if (x.librarySectionID === 3) {
        this.songs.push(x);
      }
    });
  }
}
