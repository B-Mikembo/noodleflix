import { MovieRepository } from '../../src/domaines/movie/business/gateway/movie.repository';

import { Movie } from '../../src/domaines/movie/business/rules/entity/movie';

export class InMemoryMovieRepository implements MovieRepository {
  constructor(private readonly movies: Movie[] = []) {}

  async fetchMovies(): Promise<Movie[]> {
    return Promise.resolve(this.movies);
  }

  async save(movie: Movie): Promise<void> {
    this.movies.push(movie);
  }
}
