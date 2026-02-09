package state;

/**
 * NetflixState - Concrete State class representing the Netflix application
 * Extends Application to inherit movie and TV show functionality
 */
public class NetflixState extends Application implements State {
    private TV tv;
    
    /**
     * Constructor - initializes Netflix with sample content
     * @param tv The TV context
     */
    public NetflixState(TV tv) {
        super();
        this.tv = tv;
        
        // Add sample Netflix movies
        movies.add("The Irishman");
        movies.add("Marriage Story");
        movies.add("Roma");
        movies.add("Extraction");
        movies.add("Glass Onion");
        
        // Add sample Netflix TV shows
        tvShows.add("Stranger Things");
        tvShows.add("The Crown");
        tvShows.add("Ozark");
        tvShows.add("Wednesday");
        tvShows.add("Bridgerton");
    }
    
    /**
     * Return to Home state
     */
    @Override
    public void pressHomeButton() {
        System.out.println("Returning to Home from Netflix");
        tv.setState(tv.getHomeState());
    }
    
    /**
     * Already in Netflix
     */
    @Override
    public void pressNetflixButton() {
        System.out.println("Already in Netflix");
    }
    
    /**
     * Switch to Hulu
     */
    @Override
    public void pressHuluButton() {
        System.out.println("Switching from Netflix to Hulu");
        tv.setState(tv.getHuluState());
    }
    
    /**
     * Display available movies
     */
    @Override
    public void pressMovieButton() {
        System.out.println("\n--- Netflix Movies ---");
        displayMovies();
    }
    
    /**
     * Display available TV shows
     */
    @Override
    public void pressTVButton() {
        System.out.println("\n--- Netflix TV Shows ---");
        displayTVShows();
    }
    
    /**
     * Watch a program on Netflix
     * @param title The title to watch
     */
    @Override
    public void watch(String title) {
        System.out.println("Netflix: ");
        super.watch(title);
    }
}
