package design_patterns.strategy;

import java.util.ArrayList;

public class JumpBehavior extends MoveBehavior {

    public JumpBehavior(ArrayList<String> character, int speed) {
        super(character, speed); 
    }
   
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
