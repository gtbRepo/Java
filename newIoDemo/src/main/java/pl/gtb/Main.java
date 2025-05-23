package pl.gtb;

import pl.gtb.domain.Employee;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        Path inputPath = Paths.get("./EmployeeData.txt");
        List<String> lines = Files.readAllLines(inputPath, Charset.forName("UTF-8"));

        List<Employee> employees = new ArrayList<>();

        for(int i = 0; i < lines.size(); i++) {
            if(lines.get(i).equals("EmployeeData")) {
                String[] name = lines.get(i + 1).split(",");
                int age = Integer.parseInt(lines.get(i + 2));
                boolean fullTime = lines.get(i + 3).equals("y");

                Employee emp = new Employee(name[0],name[1],age,fullTime);

                employees.add(emp);
            }
        }

        employees.get(0).setLastName("Wild");

        Path outputFile = Paths.get("./EmployeeData.json");
        Files.write(outputFile, toJson(employees).getBytes(StandardCharsets.UTF_8));
    }

    private static String toJson(List<Employee> employees) {
        String empl = employees.stream()
                .map(Employee::toJson)
                .collect(Collectors.joining(","));
        return "{\"employees\": ["+empl+"]}";
    }
}