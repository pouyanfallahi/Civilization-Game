package ir.civilization.model.technology;

import lombok.Data;

import java.util.List;
@Data
public class Technology {
    private String key;
    private String name;
    private double cost;
    private List<Technology> prerequisiteTechs;
    private List<Technology> leadsToTechs;
    private TechnologyType type;
}
