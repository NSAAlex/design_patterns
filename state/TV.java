package state;

public class TV {
    private State homeState;
    private State netflixState;
    private State huluState;
    private State state;
    
    /**
     * Constructor initializes all states and sets initial state to Home
     */
    public TV() {
        homeState = new HomeState(this);
        netflixState = new NetflixState(this);
        huluState = new HuluState(this);
        state = homeState; // Start at home state
        System.out.println("TV is starting at Home");
    }
    
    /**
     * Presses the Home button
     */
    public void pressHomeButton() {
        state.pressHomeButton();
    }
    
    /**
     * Presses the Netflix button
     */
    public void pressNetflixButton() {
        state.pressNetflixButton();
    }
    
    /**
     * Presses the Hulu button
     */
    public void pressHuluButton() {
        state.pressHuluButton();
    }
    
    /**
     * Presses the Movie button
     */
    public void pressMovieButton() {
        state.pressMovieButton();
    }
    
    /**
     * Presses the TV button
     */
    public void pressTVButton() {
        state.pressTVButton();
    }
    
    /**
     * Sets the current state
     * @param state The new state
     */
    public void setState(State state) {
        this.state = state;
    }
    
    /**
     * Gets the Home state
     * @return The Home state
     */
    public State getHomeState() {
        return homeState;
    }
    
    /**
     * Gets the Netflix state
     * @return The Netflix state
     */
    public State getNetflixState() {
        return netflixState;
    }
    
    /**
     * Gets the Hulu state
     * @return The Hulu state
     */
    public State getHuluState() {
        return huluState;
    }
    
    /**
     * Watches a program
     * @param title The title to watch
     */
    public void watch(String title) {
        state.watch(title);
    }
}