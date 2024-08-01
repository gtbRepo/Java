package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Quiz {
    File quizJson;
    public Quiz(String fileName){
        String file = Objects.requireNonNull(this.getClass().getClassLoader().getResource(fileName)).getFile();
        quizJson = new File(file);
    }

    public void displayQuestions() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Question> questions = mapper.readValue(quizJson,
                new TypeReference<>() {});

        questions.stream().map(Question::getQuestion)
                .forEach(System.out::println);
    }

    public void play() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int  points = 0;

        ObjectMapper mapper = new ObjectMapper();
        List<Question> questions = mapper.readValue(quizJson,
                new TypeReference<>() {});

        for(Question question: questions){
            System.out.println(question.getQuestion());
            System.out.println("a: " + question.getA());
            System.out.println("b: " + question.getB());
            System.out.println("c: " + question.getC());
            System.out.println("d: " + question.getD());
            System.out.println("Write your answer (\'a\' or \'b\' or \'c\' or \'d\')");

            String answer = scanner.nextLine();

            if (question.getCorrectAnswer().equals(answer)) {
                System.out.println("That is correct!");
                points++;
            } else {
                System.out.println("Wrong answer. Correct answer is: " +
                        question.getCorrectAnswer());
            }
        }
        System.out.println("The end. You've got: " + points + " points.");
        scanner.close();
    }
}
