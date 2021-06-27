package readability;

public interface ReadabilityCalculationAlgorithm {
    double getScore(String text);
}

class AutomatedReadabilityAlgorithm implements ReadabilityCalculationAlgorithm {
    @Override
    public double getScore(String text) {
        TextParser parser = new TextParser(text);
        return 4.71 * parser.countCharacters() / parser.countWords() +
                0.5 * parser.countWords() / parser.countSentences() -
                21.43;
    }
}

class FleschKincaidAlgorithm implements ReadabilityCalculationAlgorithm {
    @Override
    public double getScore(String text) {
        TextParser parser = new TextParser(text);
        return 0.39 * parser.countWords() / parser.countSentences() +
                11.8 * parser.countSyllables() / parser.countWords() -
                15.59;
    }
}

class SMOGAlgorithm implements ReadabilityCalculationAlgorithm {
    @Override
    public double getScore(String text) {
        TextParser parser = new TextParser(text);
        return 1.043 * Math.sqrt(parser.countPolysyllables() * 30 / parser.countSentences()) + 3.1291;
    }
}

class ColemanLiauAlgorithm implements ReadabilityCalculationAlgorithm {
    @Override
    public double getScore(String text) {
        TextParser parser = new TextParser(text);
        double l = (double) parser.countCharacters() / parser.countWords() * 100;
        double s = (double) parser.countSentences() / parser.countWords() * 100;
        return 0.0588 * l - 0.296 * s - 15.8;
    }
}

class ReadabilityAnalyzer {
    private ReadabilityCalculationAlgorithm algorithm;

    void setAlgorithm(ReadabilityCalculationAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    double getScore(String text) {
        return this.algorithm.getScore(text);
    }
}