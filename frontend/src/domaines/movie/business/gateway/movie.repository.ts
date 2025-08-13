import { Movie } from "../rules/entity/movie";

export interface MovieRepository {
  searchMovies(searchTerm: string): Promise<Movie[]>;
  fetchMovies(): Promise<Movie[]>;
}
