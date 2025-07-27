import { beforeEach, describe, expect, it } from 'vitest';
import { InMemoryMovieRepository } from '../../../movie.repository.stub';
import { FetchMoviesUsecase } from '../../../../../src/domaines/movie/business/rules/usecase/fetch-movies.usecase';
import { FetchMoviesUsecaseContext } from './fetch-movies.usecase.context';

describe('Fetch Movies test', () => {
  let context: FetchMoviesUsecaseContext;

  beforeEach(() => {
    context = new FetchMoviesUsecaseContext();
  });

  it('should show empty movies list', async () => {
    const fetchMoviesUsecase = context.buildUsecase();

    const movies = await fetchMoviesUsecase.execute();

    expect(movies).toEqual([]);
  });
});
