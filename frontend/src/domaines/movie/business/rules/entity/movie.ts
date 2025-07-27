export class Movie {
  constructor(
    public readonly id: number,
    public readonly title: string,
    public readonly voteAverage: number,
    public readonly posterPath: string,
    public readonly releaseDate: string,
    public readonly originalLanguage: string
  ) {}
}
