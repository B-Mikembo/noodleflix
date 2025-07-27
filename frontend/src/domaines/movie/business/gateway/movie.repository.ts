import { Movie } from "../rules/entity/movie";

export interface MovieRepository {
  fetchMovies(): Promise<Movie[]>;
}
