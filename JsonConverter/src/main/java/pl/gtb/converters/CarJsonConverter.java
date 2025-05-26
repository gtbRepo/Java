package pl.gtb.converters;

import pl.gtb.model.Car;

public class CarJsonConverter extends JsonConverter<Car> {
    public CarJsonConverter(String jsonFilname) {
        super(jsonFilname);
    }
}
