package design_patterns.strategy;

import java.util.ArrayList;
/**
 * Represents an abstract Animal that uses a MoveBehavior strategy
 * to define how it moves.
 */
public abstract class Animal {
    
    protected String name;
    protected ArrayList<String> character;
    protected MoveBehavior moveBehavior;

     /**
     * Constructs an Animal with the given name.
     *
     * @param name the name of the animal
     */

    public Animal (String name) {
        this.name = name;
        this.character = new ArrayList<>();
    }
       /**
     * Returns the name of the animal.
     *
     * @return the animal's name
     */
      
      /**
     * Executes the animal's movement behavior.
     */
     public String getName() {
         return name;
     }
    public void move() {
        moveBehavior.move();

    }
     /**
     * Returns the ASCII art representation of the animal.
     *
     * @return the animal as a String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String line : character) {
             sb.append(line).append("\n");    
        
        }
        return sb.toString();
    }

}


