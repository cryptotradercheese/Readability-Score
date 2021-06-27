package readability;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        File file = new File(args[0]);
        char[] text = new char[(int) file.length()];
        try (FileReader reader = new FileReader(file)) {
            reader.read(text);
        } catch (IOException e) {
            System.out.println(e);
        }
        TextAnalyzer analyzer = new TextAnalyzer(text.toString());

        double score = analyzer.getScore();
        String age = "";
        switch ((int) Math.round(score)) {
            case 1:
                age = "5-6";
                break;
            case 2:
                age = "6-7";
                break;
            case 3:
                age = "7-9";
                break;
            case 4:
                age = "9-10";
                break;
            case 5:
                age = "10-11";
                break;
            case 6:
                age = "11-12";
                break;
            case 7:
                age = "12-13";
                break;
            case 8:
                age = "13-14";
                break;
            case 9:
                age = "14-15";
                break;
            case 10:
                age = "15-16";
                break;
            case 11:
                age = "16-17";
                break;
            case 12:
                age = "17-18";
                break;
            case 13:
                age = "18-24";
                break;
            case 14:
                age = "24+";
                break;
        }

        System.out.println("Words: " + analyzer.countWords());
        System.out.println("Sentences: " + analyzer.countSentences());
        System.out.println("Characters: " + analyzer.countCharacters());
        System.out.println("The score is: " + Math.round(analyzer.getScore() * 100) / 100.0);
        System.out.printf("This text should be understood by %s-year-olds.", age);
    }
}