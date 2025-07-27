export class Movie {
  constructor(
    private id: number,
    private title: string,
    private voteAverage: number,
    private posterPath: string,
    private releaseDate: string,
    private originalLanguage: string
  ) {}
}
