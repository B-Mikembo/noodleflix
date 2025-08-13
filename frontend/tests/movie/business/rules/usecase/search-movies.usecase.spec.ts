import { beforeEach, describe, expect, it } from 'vitest';
import { SearchMoviesUsecaseContext } from './search-movies.usecase.context';

describe('Search Movies test', () => {
  let context: SearchMoviesUsecaseContext;

  beforeEach(() => {
    context = new SearchMoviesUsecaseContext();
  });

  it('should return empty list when search movies and no movies corresponding with search term', async () => {
    context.withNoCorrespondingMovies();

    const searchMoviesUsecase = context.buildUsecase();

    const movies = await searchMoviesUsecase.execute("query");
    
    expect(movies).toStrictEqual([]);
  })
});
