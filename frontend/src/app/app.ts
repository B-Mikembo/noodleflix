import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MovieModel } from './movie/movie-model';
import { MovieComponent } from './movie/movie';
import { Movie } from '../domaines/movie/business/rules/entity/movie';
import { FetchMoviesUsecase } from '../domaines/movie/business/rules/usecase/fetch-movies.usecase';
import { MoviesRepositoryAxios } from '../domaines/movie/gateway/movies.repository.axios';

@Component({
  selector: 'app-root',
  imports: [MovieComponent],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App implements OnInit {
  protected readonly title = signal('frontend');

  movies!: Movie[];

  async ngOnInit(): Promise<void> {
    const fetchMoviesUsecase = new FetchMoviesUsecase(
      new MoviesRepositoryAxios()
    );

    this.movies = await fetchMoviesUsecase.execute();
  }
}
