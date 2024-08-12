package CheckWeather;

import org.jsoup.select.Elements;

public class GetElementByClass {
    private final Elements elements;
    public GetElementByClass(String elementClassName) {

        ConnectToWebSite connectToWebSite = new ConnectToWebSite();
        elements = connectToWebSite
                .getCurrentWeatherDocument()
                .getElementsByClass(elementClassName);
    }

    public Elements getElements() {
        return elements;
    }
}
