package state;

import java.util.ArrayList;

/**
 * HuluState - Concrete State class representing the Hulu application
 * Extends Application to inherit movie and TV show functionality
 */
public class HuluState extends Application implements State {
    private TV tv;
    
    /**
     * Constructor - initializes Hulu with sample content
     * @param tv The TV context
     */
    public HuluState(TV tv) {
        super();
        this.tv = tv;
        
        // Add sample Hulu movies
        movies.add("Parasite");
        movies.add("Palm Springs");
        movies.add("Prey");
        movies.add("The Bear Movie");
        movies.add("Nomadland");
        
        // Add sample Hulu TV shows
        tvShows.add("The Handmaid's Tale");
        tvShows.add("The Bear");
        tvShows.add("Only Murders in the Building");
        tvShows.add("Abbott Elementary");
        tvShows.add("Reservation Dogs");
    }
    
    /**
     * Return to Home state
     */
    @Override
    public void pressHomeButton() {
        System.out.println("Returning to Home from Hulu");
        tv.setState(tv.getHomeState());
    }
    
    /**
     * Switch to Netflix
     */
    @Override
    public void pressNetflixButton() {
        System.out.println("Switching from Hulu to Netflix");
        tv.setState(tv.getNetflixState());
    }
    
    /**
     * Already in Hulu
     */
    @Override
    public void pressHuluButton() {
        System.out.println("Already in Hulu");
    }
    
    /**
     * Display available movies
     */
    @Override
    public void pressMovieButton() {
        System.out.println("\n--- Hulu Movies ---");
        displayMovies();
    }
    
    /**
     * Display available TV shows
     */
    @Override
    public void pressTVButton() {
        System.out.println("\n--- Hulu TV Shows ---");
        displayTVShows();
    }
    
    /**
     * Watch a program on Hulu
     * @param title The title to watch
     */
    @Override
    public void watch(String title) {
        System.out.println("Hulu: ");
        super.watch(title);
    }
}