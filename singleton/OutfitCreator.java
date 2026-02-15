package singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class OutfitCreator {
    private HashMap<ClothingPart, ArrayList<ClothingItem>> clothing;
    private Random rand;
    private static OutfitCreator outfitCreator;

   
    private OutfitCreator() {
        this.clothing = new HashMap<ClothingPart, ArrayList<ClothingItem>>();
        this.rand = new Random();
        
        // Load clothing items from files
        clothing.put(ClothingPart.TOP, FileReader.getTops());
        clothing.put(ClothingPart.BOTTOM, FileReader.getBottoms());
        clothing.put(ClothingPart.WHOLE, FileReader.getwholes());
    }

   
    public static OutfitCreator getInstance() {
        if (outfitCreator == null) {
            outfitCreator = new OutfitCreator();
        }
        return outfitCreator;
    }

  
    public String getOutfit(Season season) {
        // Randomly decide between a whole outfit or top+bottom
        boolean useWhole = rand.nextBoolean();
        
        if (useWhole) {
            // Try to get a whole outfit
            ClothingItem whole = getRandomClothingItem(ClothingPart.WHOLE, season);
            if (whole != null) {
                return whole.toString();
            }
            // If no whole outfit available for this season, fall back to top+bottom
        }
        
        // Get top and bottom
        ClothingItem top = getRandomClothingItem(ClothingPart.TOP, season);
        ClothingItem bottom = getRandomClothingItem(ClothingPart.BOTTOM, season);
        
        if (top != null && bottom != null) {
            return top.toString() + " with " + bottom.toString();
        } else if (top != null) {
            return top.toString();
        } else if (bottom != null) {
            return bottom.toString();
        } else {
            return "No outfit available for this season";
        }
    }

    /**
     * Gets a random clothing item of the specified type that is appropriate for the season
     * 
     * @param part The type of clothing (TOP, BOTTOM, or WHOLE)
     * @param season The season the clothing should be appropriate for
     * @return A random ClothingItem, or null if none are available
     */
    private ClothingItem getRandomClothingItem(ClothingPart part, Season season) {
        ArrayList<ClothingItem> items = clothing.get(part);
        ArrayList<ClothingItem> seasonalItems = new ArrayList<ClothingItem>();
        
        // Filter items that are appropriate for this season
        for (ClothingItem item : items) {
            if (item.hasSeason(season)) {
                seasonalItems.add(item);
            }
        }
        
        // Return a random item from the filtered list
        if (seasonalItems.isEmpty()) {
            return null;
        }
        
        int randomIndex = rand.nextInt(seasonalItems.size());
        return seasonalItems.get(randomIndex);
    }
}