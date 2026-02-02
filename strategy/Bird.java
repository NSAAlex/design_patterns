package design_patterns.strategy;
/**
 * Represents a Bird that moves by flying.
 */
public class Bird extends Animal {
    /**
     * Constructs a Bird with the given name.
     *
     * @param name the bird's name
     */
    public Bird(String name) {
        super(name);
        character.add("     __");
        character.add("   /.__.\\");
        character.add("   \\ \\/ /");
        character.add("'__/    \\");
        character.add(" \\-      )");
        character.add("  \\_____/");
        character.add("    | |");
        character.add("    \" \"");

        this.moveBehavior = new JumpBehavior(character, 2);
    }

}
