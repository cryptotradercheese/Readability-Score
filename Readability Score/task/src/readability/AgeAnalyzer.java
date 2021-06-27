package readability;

public class AgeAnalyzer {
    static int getAge(double score) {
        int age;
        switch ((int) Math.round(score)) {
            case 1:
                age = 6;
                break;
            case 2:
                age = 7;
                break;
            case 3:
                age = 9;
                break;
            case 4:
                age = 10;
                break;
            case 5:
                age = 11;
                break;
            case 6:
                age = 12;
                break;
            case 7:
                age = 13;
                break;
            case 8:
                age = 14;
                break;
            case 9:
                age = 15;
                break;
            case 10:
                age = 16;
                break;
            case 11:
                age = 17;
                break;
            case 12:
                age = 18;
                break;
            case 13:
                age = 24;
                break;
            case 14:
                age = 24;
                break;
            default:
                age = 24;
                break;
        }

        return age;
    }
}