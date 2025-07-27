import {
  Movie,
  MovieRepository,
} from '../../src/domaines/movie/business/gateway/movie.repository';

export class InMemoryMovieRepository implements MovieRepository {
  async fetchMovies(): Promise<Movie[]> {
    return [];
  }
}
