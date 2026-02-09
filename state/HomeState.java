package state;

import java.util.ArrayList;
/**
 * HomeState - Concrete State class representing the Home screen
 */
public class HomeState implements State {
    private TV tv;
    
    /**
     * Constructor
     * @param tv The TV context
     */
    public HomeState(TV tv) {
        this.tv = tv;
    }
    
    /**
     * Already at Home, so do nothing
     */
    @Override
    public void pressHomeButton() {
        System.out.println("Already at Home");
    }
    
    /**
     * Transition to Netflix state
     */
    @Override
    public void pressNetflixButton() {
        System.out.println("Switching to Netflix");
        tv.setState(tv.getNetflixState());
    }
    
    /**
     * Transition to Hulu state
     */
    @Override
    public void pressHuluButton() {
        System.out.println("Switching to Hulu");
        tv.setState(tv.getHuluState());
    }
    
    /**
     * Cannot press Movie button from Home
     */
    @Override
    public void pressMovieButton() {
        System.out.println("Cannot access Movies from Home. Please select Netflix or Hulu first.");
    }
    
    /**
     * Cannot press TV button from Home
     */
    @Override
    public void pressTVButton() {
        System.out.println("Cannot access TV Shows from Home. Please select Netflix or Hulu first.");
    }
    
    /**
     * Cannot watch from Home
     */
    @Override
    public void watch(String title) {
        System.out.println("Cannot watch from Home. Please select Netflix or Hulu first.");
    }
}
