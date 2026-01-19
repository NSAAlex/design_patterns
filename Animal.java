package design_patterns.strategy;

import java.util.ArrayList;

public abstract class Animal {
    
    protected String name;
    protected ArrayList<String> character;
    protected MoveBehavior moveBehavior;

    public Animal (String name) {
        this.name = name;
        this.character = new ArrayList<>();
    }
     public String getName() {
         return name;
     }
    public void move() {
        moveBehavior.move();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String line : character) {
             sb.append(line).append("\n");    
        
        }
        return sb.toString();
    }

}


