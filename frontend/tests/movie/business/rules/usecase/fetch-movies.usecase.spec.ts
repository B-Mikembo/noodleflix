import { beforeEach, describe, expect, it } from 'vitest';
import { InMemoryMovieRepository } from '../../../movie.repository.stub';
import { FetchMoviesUsecase } from '../../../../../src/domaines/movie/business/rules/usecase/fetch-movieRepository.usecase';
import { FetchMoviesUsecaseContext } from './fetch-movieRepository.usecase.context';
import { MovieFixture } from '../entity/movie.fixture';

describe('Fetch Movies test', () => {
  let context: FetchMoviesUsecaseContext;

  beforeEach(() => {
    context = new FetchMoviesUsecaseContext();
  });

  it('should return empty movie list when fetch movieRepository', async () => {
    context.withNoMovies();
    const fetchMoviesUsecase = context.buildUsecase();

    const movieRepository = await fetchMoviesUsecase.execute();

    expect(movieRepository).toEqual([]);
  });

  it('should return movie list when fetch movieRepository', async () => {
    const fetchMoviesUsecase = context.buildUsecase();

    const movieRepository = await fetchMoviesUsecase.execute();

    expect(movieRepository).toStrictEqual([
      MovieFixture.theDragon(),
      MovieFixture.theM3gan(),
      MovieFixture.theLiloAndStitch(),
      MovieFixture.theDemonSlayer(),
      MovieFixture.theManWithNoPast(),
    ]);
  });
});
