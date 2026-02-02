package design_patterns.strategy;

/**
 * Represents a Elephant that moves by walking.
 */
public class Elephant extends Animal {
   
     /**
     * Constructs a Elephant with the given name.
     *
     * @param name the Elephant's name
     */
    public Elephant(String name) {
        super(name);

        character.add("        /  \\~~~/  \\");
        character.add("  ,----(     ..    )");
        character.add(" /      \\__     __/");
        character.add("/|         (\\  |(");
        character.add("^ \\   /___\\  /\\ | ");
        character.add("  |__|   |__|-\"    ");
        character.add("");
        this.moveBehavior = new WalkBehavior(character, 1);
    







        
    }
}
