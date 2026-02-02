package design_patterns.strategy;
/**
 * Represents a Rabbit that moves by jumping.
 */
public class Rabbit extends Animal {
     /**
     * Constructs a Rabbit with the given name.
     *
     * @param name the Rabbit's name
     */
    public Rabbit(String name) {
        super(name);

        character.add(" \\\\");
        character.add("  \\\\");
        character.add("  ( _\\");
        character.add("  / \\__");
        character.add(" / _/`\"`");
        character.add("{\\  )_");

        this.moveBehavior = new JumpBehavior(character, 3);
    }

}
