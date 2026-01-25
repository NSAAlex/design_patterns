package Observer;

import java.util.ArrayList;

public class Mom extends Observer {
    
    public Mom(ArrayList<Baby> babies) {
        super(babies);
    }
    
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