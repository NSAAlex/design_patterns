package design_patterns.strategy;

import java.util.ArrayList;
 
/**
 * Movement behavior that simulates jumping.
 */
public class JumpBehavior extends MoveBehavior {

    /**
     * Constructs a jumping behavior.
     *
     * @param character ASCII art of the animal
     * @param speed jumping speed
     */
    public JumpBehavior(ArrayList<String> character, int speed) {
        super(character, speed); 
    }
     /**
     * Executes the jumping animation.
     */
    @Override
    public void move() {
        for (int i = 0; i < speed; i++) {
            clear();
            System.out.println();
           
            for   (String Line : character) {
               System.out.println(Line);
            
            }      
          sleep(300);
        }
    }
}
