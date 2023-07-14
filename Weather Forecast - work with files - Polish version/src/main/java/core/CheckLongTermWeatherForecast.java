package core;

// Klasa stworzona z wykorzystaniem komponentu jsoup ze strony https://mvnrepository.com/artifact/org.jsoup/jsoup
// na licencji MIT: https://mit-license.org
// Data odczytu [9 listopada 2021]

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
                Document longTermForecastWeatherDocumentInteria = Jsoup.
                        connect("https://pogoda.interia.pl/prognoza-dlugoterminowa-krakow,cId,4970").get();

                Elements nameOfTheDay = longTermForecastWeatherDocumentInteria.
                        getElementsByClass("day");
                Elements specificDate = longTermForecastWeatherDocumentInteria.
                        getElementsByClass("date");
                Elements temperature = longTermForecastWeatherDocumentInteria.
                        getElementsByClass("weather-forecast-longterm-list-entry-forecast-temp");
                Elements cloudsPercentage = longTermForecastWeatherDocumentInteria.
                        getElementsByClass("weather-forecast-longterm-list-entry-cloudy-cloudy-value");
                Elements windAverageSpeed = longTermForecastWeatherDocumentInteria.
                        getElementsByClass("weather-forecast-longterm-list-entry-wind-value");
                Elements windMaxSpeed = longTermForecastWeatherDocumentInteria.
                        getElementsByClass("weather-forecast-longterm-list-entry-wind-hit");
                Elements amountOfRainfall = longTermForecastWeatherDocumentInteria.
                        getElementsByClass("weather-forecast-longterm-list-entry-precipitation-value");
                Elements sunyHours = longTermForecastWeatherDocumentInteria.
                        getElementsByClass("weather-forecast-longterm-list-entry-pressure-value");

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
            }
        }
        catch(IOException e)
        {           //Przechwytywanie też powinno wypisywać mój komunikat, a nie standatdową odp
            e.printStackTrace();        // Jeśli nie bedzie połączenia z internetem
        }
    }
}
