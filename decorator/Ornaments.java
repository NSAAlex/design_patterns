package decorator;

import java.util.ArrayList;

public class Ornaments extends TreeDecorator {

    private Tree tree;

    public Ornaments(Tree tree) {
        super(new ArrayList<>(tree.lines));
        this.tree = tree;
        ArrayList<String> ornamentLines = FileReader.getLines("./txt/ornaments.txt");
        colorize(ornamentLines);
        integrateDecor(ornamentLines);
    }

    private void colorize(ArrayList<String> ornamentLines) {
        for (int i = 0; i < ornamentLines.size(); i++) {
            String line = ornamentLines.get(i);
            if (line.contains("R")) {
                ornamentLines.set(i, "\u001B[31m" + line.replace("R", " ") + "\u001B[0m");
            }
        }
    }
}