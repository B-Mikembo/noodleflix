import { MovieRepository } from '../../src/domaines/movie/business/gateway/movie.repository';

import { Movie } from '../../src/domaines/movie/business/rules/entity/movie';

export class InMemoryMovieRepository implements MovieRepository {
  constructor(private movieRepository: Movie[]) {}

  async fetchMovies(): Promise<Movie[]> {
    return Promise.resolve(this.movieRepository);
  }

  async save(movie: Movie): Promise<void> {
    this.movieRepository.push(movie);
  }

  async clear(): Promise<void> {
    this.movieRepository = [];
  }
}
