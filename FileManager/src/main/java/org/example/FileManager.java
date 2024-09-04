package org.example;

import java.io.File;
import java.util.Objects;
import java.util.stream.Stream;

public class FileManager {
    public void listFileInDirectory(String directory){
        Stream.of(Objects.requireNonNull(new File(directory).listFiles()))
                .filter(File::isFile)
                .map(File::getName)
                .forEach(System.out::println);
    }
    public void sortFilesInDirectory(String directory){
        Stream.of(Objects.requireNonNull(new File(directory).listFiles()))
                .filter(File::isFile)
                .sorted((o1, o2) -> Long.compare(o2.length(), o1.length()))
                .forEach(file ->{
                    System.out.println(file.getName());
                    System.out.println(file.length());
                    System.out.println();
                });
    }
}
