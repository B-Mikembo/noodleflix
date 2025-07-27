import { describe, expect, it } from 'vitest';
import { InMemoryMovieRepository } from '../../../movie.repository.stub';
import { FetchMoviesUsecase } from '../../../../../src/domaines/movie/business/rules/usecase/fetch-movies.usecase';

describe('Fetch Movies test', () => {
  it('should show empty movies list', async () => {
    const fetchMoviesUsecase = new FetchMoviesUsecase(
      new InMemoryMovieRepository()
    );

    const movies = await fetchMoviesUsecase.execute();

    expect(movies).toEqual([]);
  });
});
