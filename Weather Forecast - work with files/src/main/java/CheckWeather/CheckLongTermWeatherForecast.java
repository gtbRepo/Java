package CheckWeather;

// Klasa stworzona z wykorzystaniem komponentu jsoup ze strony https://mvnrepository.com/artifact/org.jsoup/jsoup
// na licencji MIT: https://mit-license.org
// Data odczytu [9 listopada 2021]

import core.WriteDataToFile;
import org.jsoup.select.Elements;
import java.io.IOException;

public class CheckLongTermWeatherForecast
{
    public CheckLongTermWeatherForecast()
    {
        System.out.println("Proszę czekać trwa wczytywanie długoterminowej progrnozy pogody.\n");
        try
        {
            System.out.println("Długoterminowa prognoza dla Krakowa: \n");
            for(int counter = 0; counter < 44; counter++)
            {
                Elements nameOfTheDay =
                        new GetElementByClass("day")
                                .getElements();
                Elements specificDate =
                        new GetElementByClass("date")
                                .getElements();
                Elements temperature =
                        new GetElementByClass("weather-forecast-longterm-list-entry-forecast-temp")
                                .getElements();
                Elements cloudsPercentage =
                        new GetElementByClass("weather-forecast-longterm-list-entry-cloudy-cloudy-value")
                                .getElements();
                Elements windAverageSpeed =
                        new GetElementByClass("weather-forecast-longterm-list-entry-wind-value")
                                .getElements();
                Elements windMaxSpeed =
                        new GetElementByClass("weather-forecast-longterm-list-entry-wind-hit")
                                .getElements();
                Elements amountOfRainfall =
                        new GetElementByClass("weather-forecast-longterm-list-entry-precipitation-value")
                                .getElements();
                Elements sunyHours =
                        new GetElementByClass("weather-forecast-longterm-list-entry-pressure-value")
                                .getElements(); // is it really correct? pressure value??

                System.out.println(nameOfTheDay.get(counter).text()
                        + ", " + specificDate.get(counter + 1).text() // dzięki dodaniu 1 do licznika podaje poprawną datę
                        + ". Prognozowana temperatura w ciągu dnia: " + temperature.get(counter).text()
                        + ". \nStopień zachmurzenia: " + cloudsPercentage.get(counter).text()
                        + ". Średnia prędkość wiatru: " + windAverageSpeed.get(counter).text() + " km/h"
                        + ". \nPorywy wiatru do prędkości: " + windMaxSpeed.get(counter).text()
                        + ". \nPrzewidywane opady: " + amountOfRainfall.get(counter).text()
                        + ". \nPrzewidywana liczba słonecznych godzin: " + sunyHours.get(counter).text()
                        + ".\n");

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
        catch(IOException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
