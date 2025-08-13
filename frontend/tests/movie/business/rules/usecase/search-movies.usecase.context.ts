import { SearchMoviesUsecase } from '../../../../../src/domaines/movie/business/rules/usecase/searc-movies.usecase';
import { InMemoryMovieRepository } from '../../../movie.repository.stub';
import { MovieFixture } from '../entity/movie.fixture';

export class SearchMoviesUsecaseContext {
  constructor(
    private readonly movies: InMemoryMovieRepository = new InMemoryMovieRepository(
      []
    )
  ) {
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

  buildUsecase(): SearchMoviesUsecase {
    return new SearchMoviesUsecase(this.movies);
  }

  withNoCorrespondingMovies() {
    this.movies.clear();
  }
}
