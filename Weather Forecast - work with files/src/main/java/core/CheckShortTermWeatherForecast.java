package core;

// Klasa stworzona z wykorzystaniem komponentu jsoup ze strony https://mvnrepository.com/artifact/org.jsoup/jsoup
// na licencji MIT: https://mit-license.org
// Data odczytu [9 listopada 2021]

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
                Document shortTermForecastWeatherDocumentInteria = Jsoup.
                        connect("https://pogoda.interia.pl/prognoza-szczegolowa-krakow,cId,4970").get();

                Elements getHour = shortTermForecastWeatherDocumentInteria.
                        getElementsByClass("hour");
                Elements temperature = shortTermForecastWeatherDocumentInteria.
                        getElementsByClass("forecast-temp");
                Elements cloudsPercentage = shortTermForecastWeatherDocumentInteria.
                        getElementsByClass("entry-precipitation-value cloud-cover");
                Elements windAverageSpeed = shortTermForecastWeatherDocumentInteria.
                        getElementsByClass("speed-value");
                Elements windMaxSpeed = shortTermForecastWeatherDocumentInteria.
                        getElementsByClass("wind-hit");
                Elements amountOfRainfall = shortTermForecastWeatherDocumentInteria.
                        getElementsByClass("entry-precipitation-value rain");

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

                Thread.sleep(7000); //TODO change position of this method
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

