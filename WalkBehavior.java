package design_patterns.strategy;

import java.util.ArrayList;

public class WalkBehavior extends MoveBehavior {

    public WalkBehavior(ArrayList<String> character, int speed) {
       super(character, speed);

    }

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