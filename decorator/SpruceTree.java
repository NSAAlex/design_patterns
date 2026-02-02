package decorator;

import java.util.ArrayList;

public class SpruceTree extends Tree {

    public SpruceTree() {
        super(FileReader.getLines("./txt/spruce-tree.txt"));
        colorize();
    }

    private void colorize() {
        ArrayList<String> colored = new ArrayList<>();
        for (String line : lines) {
            if (line.contains("B")) {
                colored.add(getBROWN() + line.replace("B", " ") + getRESET());
            } else if (line.contains("G")) {
                colored.add(getGREEN() + line.replace("G", " ") + getRESET());
            } else if (line.trim().isEmpty()) {
                colored.add(line);
            } else {
                colored.add(getGREEN() + line + getRESET());
            }
        }
        this.lines = colored;
    }

    private String getBROWN() {
        return "\u001B[33m";
    }

    private String getGREEN() {
        return "\u001B[32m";
    }

    private String getRESET() {
        return "\u001B[0m";
    }
}
