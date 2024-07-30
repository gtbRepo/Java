package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    List<String> words = List.of("car", "cat", "programming", "computer");
    String word;
    char[] userWord;
    int lives = 3;


    public void play() {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        word = words.get(random.nextInt(words.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord, '_');

        while (!gameEnded()) {
            System.out.println(userWord);
            System.out.println();
            System.out.println("Write another letter");
            System.out.println("Lives left: " + lives);

            //TODO Check input
            char letter = scanner.nextLine().charAt(0);

            checkLetter(letter);
        }

        if(lives == 0){
            System.out.println("Sorry, you lost :(");
        } else {
            System.out.println("Congratulations, you won! :)");
        }
        scanner.close();
    }

    private void checkLetter(char letter) {
        boolean foundLetter = false;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == letter){
                userWord[i] = letter;
                foundLetter = true;
            }
        }

        if(!foundLetter){
            System.out.println("Letter not found");
            lives--;
        }
    }

    private boolean gameEnded() {
        return lives == 0 || word.equals(String.valueOf(userWord));
    }
}
