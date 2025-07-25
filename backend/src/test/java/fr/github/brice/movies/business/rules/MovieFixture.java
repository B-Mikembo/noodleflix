package fr.github.brice.movies.business.rules;

import fr.github.brice.movies.business.rules.entity.Movie;

public class MovieFixture {
    public static Movie theDragons() {
        return new Movie(1, "Dragons", 0.81, "https://dragons.com", "11/06/2025", "FR");
    }

    public static Movie theM3ganTwoDotZero() {
        return new Movie(2, "M3GAN 2.0", 0.76, "https://m3gan.com", "25/06/2025", "FR");
    }

    public static Movie theLiloAndStitch() {
        return new Movie(3, "Lilo & Stitch", 0.73, "https://liloandstitch.com", "21/05/2025", "FR");
    }

    public static Movie theAmnesique() {
        return new Movie(4, "L'Amnésique", 0.67, "https://lamnesique.com", "14/01/2025", "FR");
    }
}
