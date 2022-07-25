package ir.civilization.model.building;

import ir.civilization.model.technology.Technology;
import lombok.Data;

import java.util.List;

@Data
public class Building {
    private String name;
    private double cost;
    private int maintenance;
    List<Technology> technologyRequired;
    private BuildingType type;
}
