class Movie {
    String title;
    String genre;
    double rating;

    void play() {
        System.out.println("Playing the movie! ");
    }
}

class MovieTest {
    public static void main(String[] args) {
        Movie newMovie = new Movie();
        newMovie.title = "Suits!";
        newMovie.genre = "Fiction";
        newMovie.rating = 8.5;
    }
}