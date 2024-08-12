package CheckWeather;

// Klasa stworzona z wykorzystaniem komponentu jsoup ze strony https://mvnrepository.com/artifact/org.jsoup/jsoup
// na licencji MIT: https://mit-license.org
// Data odczytu [9 listopada 2021]

import core.WriteDataToFile;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class CheckShortTermWeatherForecast
{
    public CheckShortTermWeatherForecast()
    {
        System.out.println("Proszę czekać trwa wczytywanie szczegółowej prognozy pogody.\n");
        try
        {
            System.out.println("Krótkoterminowa prognoza dla Krakowa: \n");
            for (int counter = 0; counter < 24; counter++) {

                Elements getHour =
                        new GetElementByClass("hour")
                                .getElements();
                Elements temperature  =
                        new GetElementByClass("forecast-temp")
                                .getElements();
                Elements cloudsPercentage =
                        new GetElementByClass("entry-precipitation-value cloud-cover")
                                .getElements();
                Elements windAverageSpeed =
                        new GetElementByClass("speed-value")
                                .getElements();
                Elements windMaxSpeed =
                        new GetElementByClass("wind-hit")
                                .getElements();
                Elements amountOfRainfall =
                        new GetElementByClass("entry-precipitation-value rain")
                                .getElements();

                System.out.println("Godzina " + getHour.get(counter).text()
                        + " 00. Prognozowana temperatura: " + temperature.get(counter).text()
                        + ". \nStopień zachmurzenia: " + cloudsPercentage.get(counter).text()
                        + ". Średnia prędkość wiatru: " + windAverageSpeed.get(counter).text() + " km/h"
                        + ". \nPorywy wiatru do prędkości: " + windMaxSpeed.get(counter).text()
                        + ". Przewidywane opady: " + amountOfRainfall.get(counter).text()
                        + ".\n");

                String shortForecastName = "forecast24h.txt";
                String rawForecastData = getHour.get(counter).text() + " "
                        + temperature.get(counter).text() + " "
                        + cloudsPercentage.get(counter).text() + " "
                        + windAverageSpeed.get(counter).text() + " km/h "
                        + windMaxSpeed.get(counter).text() + " "
                        + amountOfRainfall.get(counter).text() + " ";

                new WriteDataToFile(shortForecastName, rawForecastData, true);

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

