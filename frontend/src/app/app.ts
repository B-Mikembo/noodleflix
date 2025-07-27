import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MovieModel } from './movie/movie-model';
import { Movie } from './movie/movie';

@Component({
  selector: 'app-root',
  imports: [Movie],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App implements OnInit {
  protected readonly title = signal('frontend');

  movies!: MovieModel[];

  ngOnInit(): void {
    this.movies = [
      new MovieModel(
        1311031,
        'Demon Slayer: Kimetsu no Yaiba Infinity Castle',
        6.827,
        '/aFRDH3P7TX61FVGpaLhKr6QiOC1.jpg',
        '2025-07-18',
        'ja'
      ),
      new MovieModel(
        1087192,
        "How to Train Your Dragon",
        8.085,
        "/41dfWUWtg1kUZcJYe6Zk6ewxzMu.jpg",
        "2025-06-06",
        "en"
      )
    ];
  }
}
