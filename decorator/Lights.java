package decorator;

import java.util.ArrayList;

public class Lights extends TreeDecorator {

    private Tree tree;

    public Lights(Tree tree) {
        super(new ArrayList<>(tree.lines));
        this.tree = tree;
        ArrayList<String> lightLines = FileReader.getLines("./txt/lights.txt");
        colorize(lightLines);
        integrateDecor(lightLines);
    }
/**
     * Applies ANSI white color codes to any line in the given list
     * that contains the character {@code "W"}.
     * 
     * <p>The {@code "W"} character is replaced with a space and
     * wrapped with {@link #getWHITE()} and {@link #getRESET()} codes,
     * so that it renders as a white-colored light in the console.</p>
     * 
     * @param lightLines the list of light pattern strings to colorize;
     *                   modified in place
     */
    private void colorize(ArrayList<String> lightLines) {
        for (int i = 0; i < lightLines.size(); i++) {
            String line = lightLines.get(i);
            if (line.contains("W")) {
                lightLines.set(i, getWHITE() + line.replace("W", " ") + getRESET());
            }
        }
    }

    protected static String getWHITE() {
        return "\u001B[37m";
    }

    protected static String getRESET() {
        return "\u001B[0m";
    }
}
