package state;

import java.util.ArrayList;

/**
 * Abstract Application class that serves as a base for streaming services
 * Manages movie and TV show collections
 */
public abstract class Application {
    protected ArrayList<String> movies;
    protected ArrayList<String> tvShows;
    
    /**
     * Constructor initializes the movie and TV show lists
     */
    public Application() {
        movies = new ArrayList<>();
        tvShows = new ArrayList<>();
    }
    
    /**
     * Watches a program by title
     * Searches in both movies and TV shows
     * @param title The title to watch
     */
    public void watch(String title) {
        if (movies.contains(title)) {
            System.out.println("Now watching movie: " + title);
        } else if (tvShows.contains(title)) {
            System.out.println("Now watching TV show: " + title);
        } else {
            System.out.println("Sorry, \"" + title + "\" is not available.");
        }
    }
    
    /**
     * Displays all available movies
     */
    public void displayMovies() {
        System.out.println("Available Movies:");
        if (movies.isEmpty()) {
            System.out.println("  No movies available");
        } else {
            for (String movie : movies) {
                System.out.println("  - " + movie);
            }
        }
    }
    
    /**
     * Displays all available TV shows
     */
    public void displayTVShows() {
        System.out.println("Available TV Shows:");
        if (tvShows.isEmpty()) {
            System.out.println("  No TV shows available");
        } else {
            for (String show : tvShows) {
                System.out.println("  - " + show);
            }
        }
    }
}