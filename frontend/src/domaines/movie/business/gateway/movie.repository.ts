export interface Movie {
  id: number;
  title: string;
  voteAverage: number;
  posterPath: string;
  releaseDate: string;
  originalLanguage: string;
}

export interface MovieRepository {
  fetchMovies(): Promise<Movie[]>;
}
