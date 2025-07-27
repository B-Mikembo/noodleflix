import { Movie } from '../../../../../src/domaines/movie/business/rules/entity/movie';

export class MovieFixture {
  static theDragon(): Movie {
    return new Movie(
      1087192,
      'How to Train Your Dragon',
      8.085,
      '/41dfWUWtg1kUZcJYe6Zk6ewxzMu.jpg',
      '2025-06-06',
      'en'
    );
  }

  static theM3gan(): Movie {
    return new Movie(
      1071585,
      'M3GAN 2.0',
      7.642,
      '/oekamLQrwlJjRNmfaBE4llIvkir.jpg',
      '2025-06-25',
      'en'
    );
  }

  static theLiloAndStitch() {
    return new Movie(
      552524,
      'Lilo & Stitch',
      7.311,
      '/c32TsWLES7kL1uy6fF03V67AIYX.jpg',
      '2025-05-17',
      'en'
    );
  }

  static theDemonSlayer() {
    return new Movie(
      1311031,
      'Demon Slayer: Kimetsu no Yaiba Infinity Castle',
      6.827,
      '/aFRDH3P7TX61FVGpaLhKr6QiOC1.jpg',
      '2025-07-18',
      'ja'
    );
  }

  static theManWithNoPast() {
    return new Movie(
      1315986,
      'Man with No Past',
      6.703,
      '/eWHvROuznSzcxBAAkzX1X0Rmzoe.jpg',
      '2025-01-13',
      'en'
    );
  }
}
