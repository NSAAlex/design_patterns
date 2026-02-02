package design_patterns.strategy;

import java.util.ArrayList;

/**
 * Movement behavior that simulates walking.
 */
public class WalkBehavior extends MoveBehavior {
  /**
     * Constructs a walking behavior.
     *
     * @param character ASCII art of the animal
     * @param speed walking speed
     */
    public WalkBehavior(ArrayList<String> character, int speed) {
       super(character, speed);

    }
      /**
     * Executes the walking animation.
     */
    @Override
    public void move() {
       for (int i = 0; i < speed; i++) {
           clear();
           for (String line : character) {
                System.out.println(" " + line);
           }
           sleep(300);
       }
    }
}