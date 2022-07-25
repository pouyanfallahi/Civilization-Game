package ir.civilization.model.technology;

import java.util.Arrays;
import java.util.List;

public enum TechKind {
    AGRICULTURE(20, null, null),
    ANIMAL_HUSBANDRY(35, Arrays.asList(TechKind.AGRICULTURE), null),
    ARCHERY(35, Arrays.asList(TechKind.AGRICULTURE), null),
    BRONZE_WORKING(55, null, null),
    CALENDAR(70, null, null),
    MASONRY(55, null, null),
    MINING(35, Arrays.asList(TechKind.AGRICULTURE), Arrays.asList(TechKind.MASONRY, TechKind.BRONZE_WORKING)),
    POTTERY(35, Arrays.asList(TechKind.AGRICULTURE), Arrays.asList(TechKind.CALENDAR)),
    THE_WHEEL(55, Arrays.asList(TechKind.ANIMAL_HUSBANDRY), null),
    TRAPPING(55, Arrays.asList(TechKind.ANIMAL_HUSBANDRY), null),
    WRITING(55, Arrays.asList(TechKind.POTTERY), null),
    CONSTRUCTION(100, Arrays.asList(TechKind.MASONRY), null),
    HORSEBACK_RIDING(100, Arrays.asList(TechKind.THE_WHEEL), null),
    IRON_WORKING(150, Arrays.asList(TechKind.BRONZE_WORKING), null),
    MATHEMATICS(100, Arrays.asList(TechKind.THE_WHEEL, TechKind.ARCHERY), null),
    PHILOSOPHY(100, Arrays.asList(TechKind.WRITING), null),
    CHIVALRY(440, Arrays.asList(TechKind.HORSEBACK_RIDING), null),
    CIVIL_SERVICE(400, Arrays.asList(TechKind.PHILOSOPHY, TechKind.TRAPPING), Arrays.asList(TechKind.CHIVALRY)),
    CURRENCY(250, Arrays.asList(TechKind.MATHEMATICS), Arrays.asList(TechKind.CHIVALRY)),
    EDUCATION(440, null, null),
    ENGINEERING(250, Arrays.asList(TechKind.MATHEMATICS, TechKind.CONSTRUCTION), null),
    MACHINERY(440, Arrays.asList(TechKind.ENGINEERING), Arrays.asList(TechKind.CIVIL_SERVICE)),
    METAL_CASTING(240, Arrays.asList(TechKind.IRON_WORKING), null),
    PHYSICS(440, Arrays.asList(TechKind.ENGINEERING, TechKind.METAL_CASTING), null),
    STEEL(440, Arrays.asList(TechKind.METAL_CASTING), null),
    THEOLOGY(250, Arrays.asList(TechKind.CALENDAR, TechKind.PHILOSOPHY), Arrays.asList(TechKind.EDUCATION)),
    ACOUSTICS(650, Arrays.asList(TechKind.EDUCATION), null),
    ARCHAEOLOGY(1300, Arrays.asList(TechKind.ACOUSTICS), null),
    BANKING(650, Arrays.asList(TechKind.EDUCATION, TechKind.CHIVALRY), null),
    CHEMISTRY(900, null, null),
    ECONOMICS(900, Arrays.asList(TechKind.BANKING), null),
    FERTILIZER(1300, Arrays.asList(TechKind.CHEMISTRY), null),
    GUNPOWDER(680, Arrays.asList(TechKind.PHYSICS, TechKind.STEEL), Arrays.asList(TechKind.CHEMISTRY)),
    METALLURGY(900, Arrays.asList(TechKind.GUNPOWDER), null),
    MILITARY_SCIENCE(1300, Arrays.asList(TechKind.ECONOMICS, TechKind.CHEMISTRY), null),
    PRINTING_PRESS(650, Arrays.asList(TechKind.MACHINERY, TechKind.PHYSICS), Arrays.asList(TechKind.ECONOMICS)),
    RIFLING(1425, Arrays.asList(TechKind.METALLURGY), null),
    SCIENTIFIC_THEORY(1300, Arrays.asList(TechKind.ACOUSTICS), null),
    BIOLOGY(1680, Arrays.asList(TechKind.ARCHAEOLOGY, TechKind.SCIENTIFIC_THEORY), null),
    COMBUSTION(1300, null, null),
    DYNAMITE(1900, Arrays.asList(TechKind.FERTILIZER, TechKind.RIFLING), Arrays.asList(TechKind.COMBUSTION)),
    STEAM_POWER(1680, Arrays.asList(TechKind.SCIENTIFIC_THEORY, TechKind.MILITARY_SCIENCE), null),
    ELECTRICITY(1900, Arrays.asList(TechKind.BIOLOGY, TechKind.STEAM_POWER), null),

    RADIO(2200, Arrays.asList(TechKind.ELECTRICITY), null),

    RAILROAD(1900, Arrays.asList(TechKind.STEAM_POWER), Arrays.asList(TechKind.COMBUSTION)),

    REPLACEABLE_PARTS(1900, Arrays.asList(TechKind.STEAM_POWER), Arrays.asList(TechKind.COMBUSTION)),

    TELEGRAPH(2200, Arrays.asList(TechKind.ELECTRICITY), null),
    ;

    private double cost;
    private List<TechKind> prerequisiteTechs;
    private List<TechKind> leadsToTechs;

    TechKind(double cost, List<TechKind> prerequisiteTechs, List<TechKind> leadsToTechs) {
        this.cost = cost;
        this.prerequisiteTechs = prerequisiteTechs;
        this.leadsToTechs = leadsToTechs;

    }
}
