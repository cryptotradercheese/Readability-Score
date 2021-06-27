package readability;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        File file = new File(args[0]);
        char[] text = new char[(int) file.length()];
        try (FileReader reader = new FileReader(file)) {
            reader.read(text);
        } catch (IOException e) {
            System.out.println(e);
        }

        final Scanner scanner = new Scanner(System.in);
        TextParser parser = new TextParser(String.valueOf(text));
        ReadabilityAnalyzer analyzer = new ReadabilityAnalyzer();

        System.out.println("Words: " + parser.countWords());
        System.out.println("Sentences: " + parser.countSentences());
        System.out.println("Characters: " + parser.countCharacters());
        System.out.println("Syllables: " + parser.countSyllables());
        System.out.println("Polysyllables: " + parser.countPolysyllables());
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");

        int generalAge = 0;
        int algorithmsUsed = 0;
        String algorithm = scanner.next();
        System.out.println();

        String[] params;
        if ("all".equals(algorithm)) {
            params = new String[] {"ARI", "FK", "SMOG", "CL"};
        } else {
            params = new String[] {"algorithm"};
        }

        for (String param : params) {
            String name = "";
            switch (param) {
                case "ARI":
                    name = "Automated Readability Index";
                    analyzer.setAlgorithm(new AutomatedReadabilityAlgorithm());
                    break;
                case "FK":
                    name = "Flesch–Kincaid readability tests";
                    analyzer.setAlgorithm(new FleschKincaidAlgorithm());
                    break;
                case "SMOG":
                    name = "Simple Measure of Gobbledygook";
                    analyzer.setAlgorithm(new SMOGAlgorithm());
                    break;
                case "CL":
                    name = "Coleman–Liau index";
                    analyzer.setAlgorithm(new ColemanLiauAlgorithm());
                    break;
            }

            double score = analyzer.getScore(String.valueOf(text));
            int age = AgeAnalyzer.getAge(score);
            generalAge += age;
            algorithmsUsed++;
            System.out.printf(
                    "%s: %.2f (about %d-year-olds).",
                    name,
                    score,
                    age
            );
            System.out.println();
        }


        double averageAge = (double) generalAge / algorithmsUsed;
        System.out.println();
        System.out.printf("This text should be understood in average by %.2f-year-olds.", averageAge);
    }
}