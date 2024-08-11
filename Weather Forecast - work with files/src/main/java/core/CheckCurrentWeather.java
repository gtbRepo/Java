package core;

// Klasa stworzona z wykorzystaniem komponentu jsoup ze strony https://mvnrepository.com/artifact/org.jsoup/jsoup
// na licencji MIT: https://mit-license.org
// Data odczytu [9 listopada 2021]

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Date;

//<div class="weather-currently-temp-strict">6°C</div>

// Ostrzerzenia hydrologiczne brać ze strony:
// https://meteo.imgw.pl/dyn/#osmet=false&oshyd=true&pronieb=false&roadwarn=false&model=alaro4k0&loc=50.049686,19.955626,10
// Powyższa strona posiada: oprócz standardowych parametrów także ostrzeżenia hydrologiczne oraz zachmurzenie

public class CheckCurrentWeather
{
    public CheckCurrentWeather()
    {
        System.out.println("Proszę czekać trwa wczytywanie obecnych danych meteorologicznych.\n");
        try
        {
            Document currentWeatherDocumentInteria = Jsoup.
                    connect("https://pogoda.interia.pl/prognoza-szczegolowa-krakow,cId,4970").get();
            Elements temperature = currentWeatherDocumentInteria.
                    getElementsByClass("weather-currently-temp-strict");
            Elements windAverageSpeed = currentWeatherDocumentInteria.
                    getElementsByClass("weather-currently-details-value");
            System.out.println("Obecnie temperatura w Krakowie wynosi: "
                    + temperature.get(0).text()
                    + "\nŚrednia prędkość wiatru wynosi: "
                    + windAverageSpeed.get(2).text()
                    + "\n");

            Date nowDate = new Date();
            String shortForecastName = "forecastCurrent.txt";
            String rawForecastData = nowDate + " " + temperature.get(0).text() + " "
                    + windAverageSpeed.get(2).text();

            new WriteDataToFile(shortForecastName, rawForecastData, true);
            Thread.sleep(5000);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
