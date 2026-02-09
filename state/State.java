// Move this code to a file named State.java

package state;

/**
 * State interface for the TV State Pattern
 * Defines the contract for all concrete state classes
 */
public interface State {
    /**
     * Handles the Home button press
     */
    void pressHomeButton();

    /**
     * Handles the Netflix button press
     */
    void pressNetflixButton();

    /**
     * Handles the Hulu button press
     */
    void pressHuluButton();

    /**
     * Handles the Movie button press
     */
    void pressMovieButton();

    /**
     * Handles the TV button press
     */
    void pressTVButton();

    /**
     * Watches a program with the given title
     * @param title The title of the program to watch
     */
    void watch(String title);
}