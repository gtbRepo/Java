package CheckWeather;

import core.WriteDataToFile;
import org.jsoup.select.Elements;
import java.io.IOException;

public class CheckShortTermWeatherForecast {
    private final String cityName = "Cracow";
    private final int countTo = 24;
    public CheckShortTermWeatherForecast() {
        System.out.println("Please wait. Loading detailed weather Forecast\n");
        try {
            System.out.println("Shortterm forecast for city: " + cityName + "\n");
            for (int counter = 0; counter < countTo; counter++) {

                Elements getHour =
                        new ElementByClass("hour")
                                .getElements();
                Elements temperature  =
                        new ElementByClass("forecast-temp")
                                .getElements();
                Elements cloudsPercentage =
                        new ElementByClass("entry-precipitation-value cloud-cover")
                                .getElements();
                Elements windAverageSpeed =
                        new ElementByClass("speed-value")
                                .getElements();
                Elements windMaxSpeed =
                        new ElementByClass("wind-hit")
                                .getElements();
                Elements amountOfRainfall =
                        new ElementByClass("entry-precipitation-value rain")
                                .getElements();

                System.out.println("Hour " + getHour.get(counter).text()
                        + " 00. Forecast temparature: " + temperature.get(counter).text()
                        + ". \n Cloudiness: " + cloudsPercentage.get(counter).text()
                        + ". Average wind speed: " + windAverageSpeed.get(counter).text() + " km/h"
                        + ". \nWind hits: " + windMaxSpeed.get(counter).text()
                        + ". Forecasted amount of rain: " + amountOfRainfall.get(counter).text()
                        + "(" + (counter+1) + "/" + countTo + ")" + ".\n");

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
        catch(IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}