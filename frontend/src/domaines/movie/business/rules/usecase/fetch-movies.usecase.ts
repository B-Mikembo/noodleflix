import { MovieRepository } from '../../gateway/movie.repository';

export class FetchMoviesUsecase {
  constructor(private readonly movieRepository: MovieRepository) {}

  async execute() {
    return [];
  }
}
