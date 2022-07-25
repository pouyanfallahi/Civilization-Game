package ir.civilization.model.unit;

public enum UnitRole {

    ARCHER(70,2),

    CHARIOT_ARCHER(60,4),

    SCOUT(25,2),

    SETTLER(89,2),

    SPEARMAN(50,2),

    WARRIOR(40,2),

    WORKER(70,2),

    CATAPULT(100,2),

    HORSEMAN(70,4),

    SWORDSMAN(70,2),

    CROSSBOWMAN(120,2),

    KNIGHT(150,3),

    LONG_SWORD_MAN(150,3),

    PIKEMAN(100,2),

    TREBUCHET(170,2),

    CANON(250,2),

    CAVALRY(260,3),

    LANCER(220,4),

    MUSKETMAN(120,2),

    RIFLEMAN(200,2),

    ANTI_TANK_GUN(300,2),

    ARTILLERY(420,2),

    INFANTRY(300,2),

    PANZER(450,5),

    TANK(200,4)
;
    private int cost;
    private int movement;

    UnitRole(int cost, int movement) {
        this.cost = cost;
        this.movement = movement;
    }
}
