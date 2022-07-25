package ir.civilization.model.map;

import ir.civilization.model.Civilization;
import ir.civilization.model.Symbolizable;

public abstract class MapObject implements Symbolizable {
//    private int health;
    private Civilization owner;

    public MapObject(Civilization owner) {
//        this.health = health;
        this.owner = owner;
    }

    public Civilization getOwner() {
        return owner;
    }

//    public int getHealth() {
//        return health;
//    }
//    public void damage(int healthAmount) {
//        this.health -= healthAmount;
//    }
//
//    public boolean isDestroyed() {
//        return this.health <= 0;
//    }

//    public abstract void tick();

    @Override
    public String toString() {
        return "Owner: " + owner.getName() + ".";
    }

/*    public String getStatusString() {
        String name = this.getClass().getSimpleName();
        return name + "\nOwner: " + owner.getName() + "\nHealth: " + health;
    }*/


    public boolean isFriendly() {
        return true;
//        return !(owner instanceof Bandit);
    }

    public boolean isMilitaryUnit() {
        return true;
//        return this instanceof MilitaryUnit;
    }

    public boolean isBuilding() {
        return true;
//        return this instanceof Building;
    }

    public boolean isWorker() {
        return true;
//        return this instanceof Convertable;
    }

}
