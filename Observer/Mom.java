package Observer;

import java.util.ArrayList;

public class Mom extends Observer {
    /**
     * Constructs a Mom observer and registers her with all provided babies.
     * 
     * @param babies The list of babies Mom will monitor
     */
    public Mom(ArrayList<Baby> babies) {
        super(babies);
    }
    /**
     * Responds to a baby's cry with appropriate motherly care.
     * Provides love for angry cries, feeds for hungry cries,
     * and changes diapers for wet cries.
     * 
     * @param cry The type of cry the baby made
     * @param baby The baby that is crying
     */
    @Override
    public void update(Cry cry, Baby baby) {
        System.out.println("Mom responds to " + baby.getName() + "'s " + cry + " cry:");
        
        switch (cry) {
            case ANGRY:
                System.out.println("Mom says: 'Don't worry sweetie, mommy's here!'");
                baby.receiveLove();
                break;
            case HUNGRY:
                System.out.println("Mom says: 'Time to feed you, little one!'");
                baby.eat();
                break;
            case WET:
                System.out.println("Mom says: 'Let's get you a clean diaper!'");
                baby.getChanged();
                break;
        }
    }
}