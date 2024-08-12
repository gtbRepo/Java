package core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteDataToFile {
    public WriteDataToFile(String fileName, String meteoForecast, Boolean append) throws IOException {
        File file = new File(fileName); //created a File object called file
        FileWriter fw = new FileWriter(file, append); //created a FileWriter object called fw
        PrintWriter pw = new PrintWriter(fw); //created a PrintWriter object called pw

        pw.println(meteoForecast);
        pw.close();
    }
}
