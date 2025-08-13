import { beforeEach, describe, expect, it } from 'vitest';
import { SearchMoviesUsecaseContext } from './search-movies.usecase.context';
import { MovieFixture } from '../entity/movie.fixture';

describe('Search Movies test', () => {
  let context: SearchMoviesUsecaseContext;

  beforeEach(() => {
    context = new SearchMoviesUsecaseContext();
  });

  it('should return empty list when search movies and no movies corresponding with search term', async () => {
    context.withNoCorrespondingMovies();

    const searchMoviesUsecase = context.buildUsecase();

    const movies = await searchMoviesUsecase.execute('query');

    expect(movies).toStrictEqual([]);
  });

  it('should return movies corresponding with search when search movies with corresponding search term', async () => {
    const searchMoviesUsecase = context.buildUsecase();

    const movies = await searchMoviesUsecase.execute('demon');

    expect(movies).toStrictEqual([MovieFixture.theDemonSlayer()]);
  });
});
