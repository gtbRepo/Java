package CheckWeather;

// Klasa stworzona z wykorzystaniem komponentu jsoup ze strony https://mvnrepository.com/artifact/org.jsoup/jsoup
// na licencji MIT: https://mit-license.org
// Data odczytu [9 listopada 2021]

import core.WriteDataToFile;
import org.jsoup.select.Elements;
import java.io.IOException;

public class CheckLongTermWeatherForecast {
    private final String cityName = "Cracow";
    private final int countTo = 44;
    public CheckLongTermWeatherForecast() {
        System.out.println("Please wait. Loading detailed weather Forecast\n");
        try {
            System.out.println("Longterm forecast for the city: " + cityName + "\n");
            for(int counter = 0; counter < countTo; counter++) {
                Elements nameOfTheDay =
                        new ElementByClass("day")
                                .getElements();
                Elements specificDate =
                        new ElementByClass("date")
                                .getElements();
                Elements temperature =
                        new ElementByClass("weather-forecast-longterm-list-entry-forecast-temp")
                                .getElements();
                Elements cloudsPercentage =
                        new ElementByClass("weather-forecast-longterm-list-entry-cloudy-cloudy-value")
                                .getElements();
                Elements windAverageSpeed =
                        new ElementByClass("weather-forecast-longterm-list-entry-wind-value")
                                .getElements();
                Elements windMaxSpeed =
                        new ElementByClass("weather-forecast-longterm-list-entry-wind-hit")
                                .getElements();
                Elements amountOfRainfall =
                        new ElementByClass("weather-forecast-longterm-list-entry-precipitation-value")
                                .getElements();
                Elements sunyHours =
                        new ElementByClass("weather-forecast-longterm-list-entry-pressure-value")
                                .getElements(); // is it really correct? pressure value??

                System.out.println(nameOfTheDay.get(counter).text()
                        + ", " + specificDate.get(counter + 1).text() // dzięki dodaniu 1 do licznika podaje poprawną datę
                        + ". Prognozowana temperatura w ciągu dnia: " + temperature.get(counter).text()
                        + ". \nStopień zachmurzenia: " + cloudsPercentage.get(counter).text()
                        + ". Średnia prędkość wiatru: " + windAverageSpeed.get(counter).text() + " km/h"
                        + ". \nPorywy wiatru do prędkości: " + windMaxSpeed.get(counter).text()
                        + ". \nPrzewidywane opady: " + amountOfRainfall.get(counter).text()
                        + ". \nPrzewidywana liczba słonecznych godzin: " + sunyHours.get(counter).text()
                        + "(" + (counter+1) + "/" + countTo + ")" + ".\n");

                String longForecastName = "forecastLong.txt";
                String rawForecastData = nameOfTheDay.get(counter).text() + " "
                        + specificDate.get(counter + 1).text() + " "
                        + temperature.get(counter).text() + " "
                        + cloudsPercentage.get(counter).text() + " "
                        + windAverageSpeed.get(counter).text() + " km/h "
                        + windMaxSpeed.get(counter).text() + " "
                        + amountOfRainfall.get(counter).text() + " "
                        + sunyHours.get(counter).text();

                new WriteDataToFile(longForecastName, rawForecastData, true);

                Thread.sleep(500);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
