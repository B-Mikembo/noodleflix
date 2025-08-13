import { MovieRepository } from "../../gateway/movie.repository";

export class SearchMoviesUsecase {
  constructor(private readonly movies: MovieRepository) {}

  async execute(searchTerm: string) {
    return this.movies.searchMovies(searchTerm);
  }
}