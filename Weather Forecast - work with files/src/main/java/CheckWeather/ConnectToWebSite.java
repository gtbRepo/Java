package CheckWeather;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class ConnectToWebSite {
    private final Document currentWeatherDocument;
    public ConnectToWebSite() {
        try {
            Thread.sleep(500); //TODO Change to site without rate limits
            //Try this: https://meteo.imgw.pl/pogoda?lat=50.049686&lon=19.955626 <-for avg wind speed
            // and this: https://agrometeo.imgw.pl/pogoda? <- for cloudiness

            //Check api: https://danepubliczne.imgw.pl/pl/apiinfo <-probably the best

            currentWeatherDocument = Jsoup.
                        connect("https://pogoda.interia.pl/prognoza-szczegolowa-krakow,cId,4970").get();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Document getCurrentWeatherDocument() {
        return currentWeatherDocument;
    }
}
