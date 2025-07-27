import { beforeEach, describe, expect, it } from 'vitest';
import { InMemoryMovieRepository } from '../../../movie.repository.stub';
import { FetchMoviesUsecase } from '../../../../../src/domaines/movie/business/rules/usecase/fetch-movies.usecase';
import { FetchMoviesUsecaseContext } from './fetch-movies.usecase.context';
import { MovieFixture } from '../entity/movie.fixture';

describe('Fetch Movies test', () => {
  let context: FetchMoviesUsecaseContext;

  beforeEach(() => {
    context = new FetchMoviesUsecaseContext();
  });

  it('should return empty movie list when fetch movies', async () => {
    context.withNoMovies();
    const fetchMoviesUsecase = context.buildUsecase();

    const movies = await fetchMoviesUsecase.execute();

    expect(movies).toEqual([]);
  });

  it('should return movie list when fetch movies', async () => {
    const fetchMoviesUsecase = context.buildUsecase();

    const movies = await fetchMoviesUsecase.execute();

    expect(movies).toStrictEqual([
      MovieFixture.theDragon(),
      MovieFixture.theM3gan(),
      MovieFixture.theLiloAndStitch(),
      MovieFixture.theDemonSlayer(),
      MovieFixture.theManWithNoPast(),
    ]);
  });
});
