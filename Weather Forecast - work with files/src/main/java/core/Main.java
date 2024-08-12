package core;

import java.util.Scanner;

import CheckWeather.CheckCurrentWeather;
import CheckWeather.CheckLongTermWeatherForecast;
import CheckWeather.CheckShortTermWeatherForecast;
import gui.Gui;

//TODO upgrade gui;
//TODO Change site to site without rate limits
//Try this https://meteo.imgw.pl/pogoda?lat=50.049686&lon=19.955626


public class Main
{
    public static void main(String[] args)
    {
        new VersionAndGreet();
        new InformHowBehave();
        boolean flag = true;
        while(flag)
        {
            int choice = 0;
            Scanner scanner = new Scanner(System.in);
            try
            {
                choice = scanner.nextInt();
            }
            catch (java.util.InputMismatchException e)
            {
                scanner.nextLine();
            }
            switch (choice)
            {
                case 1:
                    new CheckCurrentWeather();
                    break;
                case 2:
                    new CheckShortTermWeatherForecast();
                    break;
                case 3:
                    new CheckLongTermWeatherForecast();
                    break;
                case 4:
                    new CheckCurrentWeather();
                    new CheckShortTermWeatherForecast();
                    new CheckLongTermWeatherForecast();
                case 5:
                    new Gui();
                    break;
                default:
                    scanner.close();
                    flag = false;
                    break;
            }
        }
    }
}