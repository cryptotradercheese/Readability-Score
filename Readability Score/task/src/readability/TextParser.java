package readability;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TextParser {
    private String text;

    public TextParser(String text) {
        this.text = text;
    }

    String[] getSentences() {
        return this.text.split("(\\s+)?[.!?](\\s+)?");
    }

    String[] getWords() {
        return this.text.split("(?<!\\d),\\W*(?!\\d)|[^\\w,]+");
    }

    int countSentences() {
        return getSentences().length;
    }

    int countWords() {
        return getWords().length;
    }

    int countCharacters() {
        return this.text.replaceAll("\\s+", "").length();
    }

    int countSyllablesInWord(String word) {
        Pattern pattern = Pattern.compile("(?i)[aeiouy]{1,2}");
        Matcher matcher = pattern.matcher(word);

        int syllablesInWord = 0;
        while (matcher.find()) {
            syllablesInWord++;
        }

        if (word.matches("(?i).*e")) {
            syllablesInWord--;
        }

        if (syllablesInWord == 0) {
            syllablesInWord++;
        }

        return syllablesInWord;
    }

    int countSyllables() {
        int syllables = 0;
        for (String word : getWords()) {
            syllables += countSyllablesInWord(word);
        }

        return syllables;
    }

    int countPolysyllables() {
        int polysyllables = 0;
        for (String word : getWords()) {
            if (countSyllablesInWord(word) > 2) {
                polysyllables++;
            }
        }

        return polysyllables;
    }
}