import { FetchMoviesUsecase } from '../../../../../src/domaines/movie/business/rules/usecase/fetch-movieRepository.usecase';
import { InMemoryMovieRepository } from '../../../movie.repository.stub';
import { MovieFixture } from '../entity/movie.fixture';

export class FetchMoviesUsecaseContext {
  private readonly movieRepository: InMemoryMovieRepository =
    new InMemoryMovieRepository([]);

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
    ].forEach((movie) => this.movieRepository.save(movie));
  }

  buildUsecase(): FetchMoviesUsecase {
    return new FetchMoviesUsecase(this.movieRepository);
  }

  withNoMovies() {
    this.movieRepository.clear();
  }
}
