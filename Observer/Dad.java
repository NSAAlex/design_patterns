package Observer;

import java.util.ArrayList;

public class Dad extends Observer {
    /**
     * Constructs a Dad observer and registers him with all provided babies.
     * 
     * @param babies The list of babies Dad will monitor
     */
    public Dad(ArrayList<Baby> babies) {
        super(babies);
    }
    /**
     * Responds to a baby's cry with appropriate fatherly care.
     * Provides love for angry cries, feeds for hungry cries,
     * and changes diapers for wet cries.
     * 
     * @param cry The type of cry the baby made
     * @param baby The baby that is crying
     */
    @Override
    public void update(Cry cry, Baby baby) {
        System.out.println("Dad responds to " + baby.getName() + "'s " + cry + " cry:");
        
        switch (cry) {
            case ANGRY:
                System.out.println("Dad says: 'It's okay buddy, daddy's got you!'");
                baby.receiveLove();
                break;
            case HUNGRY:
                System.out.println("Dad says: 'Let me get you a bottle!'");
                baby.eat();
                break;
            case WET:
                System.out.println("Dad says: 'Diaper change time, champ!'");
                baby.getChanged();
                break;
        }
    }
}