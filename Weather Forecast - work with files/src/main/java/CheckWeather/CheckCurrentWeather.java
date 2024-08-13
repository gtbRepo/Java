package CheckWeather;

import core.WriteDataToFile;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Date;

//TODO
// Ostrzerzenia hydrologiczne brać ze strony:
// https://meteo.imgw.pl/dyn/#osmet=false&oshyd=true&pronieb=false&roadwarn=false&model=alaro4k0&loc=50.049686,19.955626,10
// Powyższa strona posiada: oprócz standardowych parametrów także ostrzeżenia hydrologiczne oraz zachmurzenie

public class CheckCurrentWeather {
    public CheckCurrentWeather() {
        System.out.println("Proszę czekać trwa wczytywanie obecnych danych meteorologicznych.\n");
        try {
            Elements temperature =
                    new ElementByClass("weather-currently-temp-strict")
                            .getElements();

            Elements windAverageSpeed =
                    new ElementByClass("weather-currently-details-value")
                    .getElements();

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
            Thread.sleep(500);
        }
        catch(IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
