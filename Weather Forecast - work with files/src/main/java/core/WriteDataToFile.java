package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.*;
import java.util.Date;

public class WriteDataToFile {
    public WriteDataToFile() throws IOException {
        File file = new File("out.txt"); //created a File object called file
        FileWriter fw = new FileWriter(file, true); //created a FileWriter object called fw
        PrintWriter pw = new PrintWriter(fw); //created a PrintWirter object called pw

        Date nowDate = new Date();
        pw.println("Utworzono domyślny plik w dniu" + nowDate);

        pw.close();
    }

    public WriteDataToFile(String fileName, String meteoForecast, Boolean append) throws IOException {
        File file = new File(fileName); //created a File object called file
        FileWriter fw = new FileWriter(file, append); //created a FileWriter object called fw
        PrintWriter pw = new PrintWriter(fw); //created a PrintWirter object called pw

        pw.println(meteoForecast);

        pw.close();
    }
}
