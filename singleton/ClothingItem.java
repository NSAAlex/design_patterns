package singleton;

import java.util.ArrayList;

public class ClothingItem {
    private String name;
    private String color;
    private ArrayList<Season> seasons;



    public ClothingItem(String name, String color) {
        this.name = name;
        this.color = color;
        this.seasons = new ArrayList<Season>();
    }
     
    public boolean hasSeason(Season season) {
        return seasons.contains(season);
    }

    public void addSeason(Season season) {
        seasons.add(season);
        if (!seasons.contains(season)) {
            seasons.add(season);
        }
    }

    @Override
    public String toString() {
        return name + " (" + color + ")";
    }





}
