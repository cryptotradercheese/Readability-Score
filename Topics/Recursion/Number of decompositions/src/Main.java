import java.util.Scanner;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.*;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        String[] decomposition = decompose(n, 1000000);
//        for (String row : decomposition) {
//            System.out.println(row);
//        }
//        System.out.println(Arrays.toString(decomposition));

//        for (String row : decompose(n, 1000000)) {
//            System.out.println(row);
//        }

//        System.out.println(decompose(n));

        for (StringBuilder str : decompose(n)) {
            System.out.println(str);
        }
//        System.out.println(decompose(n));
    }

//    public static String decompose(int n) {
//        String decomposition = "";
//        Pattern pattern = Pattern.compile("\\d+");
//        for (int i = 1; i <= n; i++) {
//            // at last iteration add n in the end of decomposition
//            if (n == i) {
////                return decomposition + n + "\n";
//                return decomposition + "\n" + n;
//            }
//
//            //пересоздавать массив каждый раз при изменении его длины
//            //String[] prevDecomposition = decompose(n - i).split("\\n"); // remainder decomposition
//            decomposition += decompose(n - i).replace("\n", "\n" + i + " ");
////            for (String row : decompose(n - i).split("\\n")) {
////                Matcher matcher = pattern.matcher(row);
////                matcher.find();
////                int firstNum = Integer.parseInt(matcher.group(0));
////                if (i >= firstNum) {
////                    decomposition += i + " " + row + "\n";
////                }
////            }
//        }
//        return decomposition; //никогда не срабатывает
//    }

//    public static String[] decompose(int n, int iteration) {
//        String[] decomposition = new String[0];
//        for (int i = 1; i <= n; i++) {
//            // at last iteration add n in the end of decomposition
//            if (n == i) {
//                String[] tempArr = Arrays.copyOfRange(decomposition, 0, decomposition.length + 1);
//                tempArr[tempArr.length - 1] = String.valueOf(n);
//                return tempArr;
//            }
//
//            //пересоздавать массив каждый раз при изменении его длины
//            String[] prevDecomposition = decompose(n - i, i); // remainder decomposition
//            String[] curDecomposition = Arrays.copyOfRange(
//                    decomposition,
//                    0,
//                    decomposition.length + prevDecomposition.length
//            );
//
//            int l = 0 + decomposition.length;
//            for (int j = 0 + decomposition.length; j < curDecomposition.length; j++) {
//                Pattern pattern = Pattern.compile("\\d+");
//                Matcher matcher = pattern.matcher(prevDecomposition[j - decomposition.length]);
//                matcher.find();
//                int firstNum = Integer.parseInt(matcher.group(0));
//                if (i >= firstNum && iteration >= i) {
//                    curDecomposition[l] = i + " " + prevDecomposition[j - decomposition.length];
//                    l++;
//                }
//            }
//            decomposition = Arrays.copyOfRange(curDecomposition, 0, l);
////            decomposition = Arrays.copyOfRange(curDecomposition, 0, curDecomposition.length);
//        }
//        return decomposition; //никогда не срабатывает
//    }

    static Pattern pattern = Pattern.compile("\\d+");

//    public static ArrayList<StringBuilder> decompose(int n) {
//        //Pattern pattern = Pattern.compile("\\d+");
//        ArrayList<StringBuilder> decomposition = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            // at last iteration add n in the end of decomposition
//            if (n == i) {
////                decomposition.add(String.valueOf(n));
//                decomposition.add(new StringBuilder().append(n));
//                return decomposition;
//            }
//
//            ArrayList<StringBuilder> prevDecomposition = decompose(n - i); // remainder decomposition
//
//            for (int j = 0; j < prevDecomposition.size(); j++) {
//                Matcher matcher = pattern.matcher(prevDecomposition.get(j));
//                matcher.find();
//                int firstNum = Integer.parseInt(matcher.group(0));
//                if (i >= firstNum) {
//                    //decomposition.add(i + " " + prevDecomposition.get(j));
//                    decomposition.add(prevDecomposition.get(j).insert(0, i + " "));
//                }
//            }
//        }
//        return decomposition; // unreachable
//    }

    public static Queue<StringBuilder> decompose(int n) {
        //Pattern pattern = Pattern.compile("\\d+");
        Queue<StringBuilder> decomposition = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            // at last iteration add n in the end of decomposition
            if (n == i) {
//                decomposition.add(String.valueOf(n));
                decomposition.add(new StringBuilder().append(n));
                return decomposition;
            }

            Queue<StringBuilder> prevDecomposition = decompose(n - i); // remainder decomposition

            for (StringBuilder str : prevDecomposition) {
                Matcher matcher = pattern.matcher(str);
                matcher.find();
                int firstNum = Integer.parseInt(matcher.group(0));
                if (i >= firstNum) {
                    decomposition.add(str.insert(0, i + " "));
                }
            }
        }
        return decomposition; // unreachable
    }

//    public static StringBuilder decompose(int n) {
//        //Pattern pattern = Pattern.compile("\\d+");
//        StringBuilder decomposition = new StringBuilder();
//        for (int i = 1; i <= n; i++) {
//            // at last iteration add n in the end of decomposition
//            if (n == i) {
////                decomposition.add(String.valueOf(n));
//                return decomposition.append("\n" + n);
//            }
//
//            //StringBuilder prevDecomposition = decompose(n - i); // remainder decomposition
//            decomposition.append(decompose(n - i));
//
////            for (StringBuilder str : prevDecomposition) {
////                Matcher matcher = pattern.matcher(str);
////                matcher.find();
////                int firstNum = Integer.parseInt(matcher.group(0));
////                if (i >= firstNum) {
////                    //decomposition.add(i + " " + prevDecomposition.get(j));
////                    decomposition.add(str.insert(0, i + " "));
////                }
////            }
//        }
//        return decomposition; // unreachable
//    }
}