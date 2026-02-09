package decorator;

import java.util.ArrayList;

public class star extends TreeDecorator {

    private Tree tree;

    public star(Tree tree) {
        super(new ArrayList<>(tree.lines));
        this.tree = tree;
        ArrayList<String> starLines = FileReader.getLines("./txt/star.txt");
        colorize(starLines);
        integrateDecor(starLines);
    }

    private void colorize(ArrayList<String> starLines) {
        for (int i = 0; i < starLines.size(); i++) {
            String line = starLines.get(i);
            if (line.contains("Y")) {
                starLines.set(i, line.replace("Y", " "));
                
            }
        }
    }
}

