package readability;

import java.util.Scanner;

public class TextAnalyzer {
    private String text;

    public TextAnalyzer(String text) {
        this.text = text;
    }

    String[] getSentences() {
        return this.text.split("(\\s+)?[.!?](\\s+)?");
    }

    int countSentences() {
        return getSentences().length;
    }

    int countWords() {
        int wordsCount = 0;
        for (String sentence : getSentences()) {
            wordsCount += sentence.split("\\W+").length;
        }

        return wordsCount;
    }

    int countCharacters() {
        return this.text.replaceAll("\\s+", "").length();
    }

    double getScore() {
        return 4.71 * countCharacters() / countWords() + 0.5 * countWords() / countSentences() - 21.43;
    }

    void printInfo() {

    }
}