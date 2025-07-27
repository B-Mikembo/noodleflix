export class MovieModel {
  constructor(
    public id: number,
    public title: string,
    public voteAverage: number,
    public posterPath: string,
    public releaseDate: string,
    public originalLanguage: string
  ) {}
}
