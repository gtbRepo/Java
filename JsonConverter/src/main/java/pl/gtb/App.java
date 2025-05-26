package pl.gtb;

import pl.gtb.converters.CarJsonConverter;
import pl.gtb.converters.CarsStoreJsonConverter;
import pl.gtb.model.Car;
import pl.gtb.model.CarsStore;
import pl.gtb.model.Color;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        //code frome: https://www.youtube.com/watch?v=Rr0ctKODJEU [26.05.2025]

        //car data
        Car car = Car.builder()
                .model("BMW")
                .speed(200)
                .price(new BigDecimal("120000"))
                .color(Color.BLACK)
                .components(new HashSet<>(Arrays.asList("C1", "C2", "C3")))
                .build();

        //car json conversion
        final String carJsonFilename = "car.json";
        CarJsonConverter carJsonConverter = new CarJsonConverter(carJsonFilename);
        carJsonConverter.toJson(car);
        carJsonConverter.fromJson().ifPresent(System.out::println);

        //cars store data
        CarsStore carsStore = new CarsStore(new HashSet<>(Arrays.asList(
                Car.builder()
                        .model("AUDI")
                        .speed(220)
                        .price(new BigDecimal("120000"))
                        .color(Color.BLACK)
                        .components(new HashSet<>(Arrays.asList("C1", "C2", "C3")))
                        .build(),
                Car.builder()
                        .model("BMW")
                        .speed(200)
                        .price(new BigDecimal("110000"))
                        .color(Color.GREY)
                        .components(new HashSet<>(Arrays.asList("C4", "C5", "C6")))
                        .build(),
                Car.builder()
                        .model("MAZDA")
                        .speed(180)
                        .price(new BigDecimal("100000"))
                        .color(Color.WHITE)
                        .components(new HashSet<>(Arrays.asList("C7", "C8", "C9")))
                        .build()
        )));

        // car store json conversion
        final String carsStoreJsonFilename = "cars_store.json";
        CarsStoreJsonConverter carsStoreJsonConverter = new CarsStoreJsonConverter(carsStoreJsonFilename);
        carsStoreJsonConverter.toJson(carsStore);
        carsStoreJsonConverter.fromJson().ifPresent(System.out::println);
    }
}