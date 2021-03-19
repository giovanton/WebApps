import { Component, OnInit } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-user-board',
  templateUrl: './user-board.component.html',
  styleUrls: ['./user-board.component.css'],
  providers: [NgbCarouselConfig]
})
export class UserBoardComponent implements OnInit {
  images = [1, 2, 3].map((n) => `../../assets/img/id/${n}.jpg`
  );

  constructor(config: NgbCarouselConfig) {
    config.interval = 10000;
   }

  ngOnInit(): void {
  }

}
