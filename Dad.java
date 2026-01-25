package Observer;

import java.util.ArrayList;

public class Dad extends Observer {
    
    public Dad(ArrayList<Baby> babies) {
        super(babies);
    }
    
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