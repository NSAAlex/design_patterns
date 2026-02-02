package decorator;

import java.util.ArrayList;

public class Tree {
    private static final String RESET = "\033[0m";
    private static final String GREEN = "\033[32m";
    private static final String WHITE = "\033[37m";
    private static final String RED = "\033[31m";
    private static final String YELLOW = "\033[33m";
    private static final String BROWN = "\033[38m;5;94m";

    protected ArrayList<String> lines;

    Tree(ArrayList<String> lines) {
        this.lines = lines;
    }
 /**
     * Returns the full tree as a single string, with each line
     * separated by a newline character.
     * 
     * @return a string representation of the tree, ready for
     *         console output
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

}
