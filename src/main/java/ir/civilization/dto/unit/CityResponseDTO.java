package ir.civilization.dto.unit;

import ir.civilization.dto.DtoLoader;
import ir.civilization.model.City;
import lombok.Data;

@Data
public class CityResponseDTO implements DtoLoader<City> {

    private String name;

    @Override
    public void loadFrom(City city) {
        this.name = city.getName();
    }
}
