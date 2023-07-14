package core;

import java.util.Scanner;
import gui.Gui;

public class Main
{
    public static void main(String[] args)
    {
        new VersionAndGreet();
        boolean flag = true;
        while(flag)
        {
            new InformHowBehave();
            new Gui();
            int choice = 0;
            Scanner scan = new Scanner(System.in);
            try
            {
                choice = scan.nextInt();
            }
            catch (java.util.InputMismatchException e)
            {
                scan.nextLine();
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
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }
}