package design_patterns.strategy;

import java.util.ArrayList;

public abstract class MoveBehavior {

    protected int speed;
    protected ArrayList<String> character;

    public MoveBehavior(ArrayList<String> character, int speed) {
    this.character = character;
    this.speed = speed;
    }

    public abstract void move();

    protected void sleep(int num) {
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
        
    }   

    protected void clear() {
        System.out.print("\033[H\033[2j");
        System.out.flush();
    }
}
