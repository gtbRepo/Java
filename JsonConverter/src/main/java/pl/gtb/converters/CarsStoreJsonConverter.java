package pl.gtb.converters;

import pl.gtb.model.CarsStore;

public class CarsStoreJsonConverter extends JsonConverter<CarsStore>{
    public CarsStoreJsonConverter(String jsonFilename){
        super(jsonFilename);
    }
}
