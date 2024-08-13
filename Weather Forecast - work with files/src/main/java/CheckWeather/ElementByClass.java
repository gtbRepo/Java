package CheckWeather;

import lombok.Getter;
import org.jsoup.select.Elements;

@Getter
public class ElementByClass {
    private final Elements elements;
    public ElementByClass(String elementClassName) {
        ConnectToWebSite connectToWebSite = new ConnectToWebSite();
        elements = connectToWebSite
                .getCurrentWeatherDocument()
                .getElementsByClass(elementClassName);
    }
}
