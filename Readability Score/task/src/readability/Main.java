package readability;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] sentences = text.split("[.!?]");

        int wordsCount = 0;
        for (String sentence : sentences) {
            wordsCount += sentence.split("(?<=\\w)\\W").length;
        }

        if ((double) wordsCount / sentences.length > 10) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }
}