package Observer;

import java.util.ArrayList;
import java.util.Random;

public abstract class Observer {
    protected Random rand;
    /**
     * Constructs an Observer and registers it with all provided babies.
     * 
     * @param babies The list of babies this observer will monitor
     */
    public Observer(ArrayList<Baby> babies) {
        this.rand = new Random();
        for (Baby baby : babies) {
            baby.registerObserver(this);
        }
    }
    
    public abstract void update(Cry cry, Baby baby);
}