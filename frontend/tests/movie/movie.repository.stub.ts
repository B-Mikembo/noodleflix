import { MovieRepository } from '../../src/domaines/movie/business/gateway/movie.repository';

import { Movie } from '../../src/domaines/movie/business/rules/entity/movie';

export class InMemoryMovieRepository implements MovieRepository {
  constructor(private movies: Movie[]) {}

  async fetchMovies(): Promise<Movie[]> {
    return Promise.resolve(this.movies);
  }

  async searchMovies(searchTerm: string): Promise<Movie[]> {
    const correspondingMovies = this.movies.filter((movie) =>
      movie.title.toLowerCase().includes(searchTerm.toLowerCase())
    );
    return Promise.resolve(correspondingMovies);
  }

  async save(movie: Movie): Promise<void> {
    this.movies.push(movie);
  }

  async clear(): Promise<void> {
    this.movies = [];
  }
}
