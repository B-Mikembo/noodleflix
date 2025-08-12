import { AxiosFactory } from '../../../axios.factory';
import { MovieRepository } from '../business/gateway/movie.repository';
import { Movie } from '../business/rules/entity/movie';

interface MovieApiModel {
  id: number;
  title: string;
  voteAverage: number;
  posterPath: string;
  releaseDate: string;
  originalLanguage: string;
}

export interface MoviesApiModel {
  movies: MovieApiModel[];
}

export class MoviesRepositoryAxios implements MovieRepository {
  async fetchMovies(): Promise<Movie[]> {
    const axios = AxiosFactory.getAxios();
    const response = await axios.get<MoviesApiModel>('/movies');
    return this.transformMoviesApiModelToMovies(response.data);
  }

  private transformMoviesApiModelToMovies(
    moviesApiModel: MoviesApiModel
  ): Movie[] {
    return moviesApiModel.movies.map(
      (movie) =>
        new Movie(
          movie.id,
          movie.title,
          movie.voteAverage,
          movie.posterPath,
          movie.releaseDate,
          movie.originalLanguage
        )
    );
  }
}
