import { FetchMoviesUsecase } from '../../../../../src/domaines/movie/business/rules/usecase/fetch-movies.usecase';
import { InMemoryMovieRepository } from '../../../movie.repository.stub';
import { MovieFixture } from '../entity/movie.fixture';

export class FetchMoviesUsecaseContext {
  private readonly movies: InMemoryMovieRepository =
    new InMemoryMovieRepository();

  constructor() {
    this.populateRepositoryWithSomeMovies();
  }

  private populateRepositoryWithSomeMovies() {
    [
      MovieFixture.theDragon(),
      MovieFixture.theM3gan(),
      MovieFixture.theLiloAndStitch(),
      MovieFixture.theDemonSlayer(),
      MovieFixture.theManWithNoPast(),
    ].forEach((movie) => this.movies.save(movie));
  }

  buildUsecase(): FetchMoviesUsecase {
    return new FetchMoviesUsecase(this.movies);
  }
}
