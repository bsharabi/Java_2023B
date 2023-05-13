package L07;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Aviv_2022A {


    static Scanner in = new Scanner(System.in);
    static Random rd = new Random();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        boolean bool;

        while (true) {
            System.out.println("Enter q number");
            int numberQ = in.nextInt();
            switch (numberQ) {
                case 1:
                    Q1();
                    break;
                case 2:
                    break;
                case 3:
                    bool = Q3(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3});
                    System.out.println(bool);
                    System.out.println("סיבוכיות הפעולה הינה O(n) מכיוון ואנו עוברים על המערך פעם אחת בלבד");
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    what(new int[]{12, 13, 1, 10, 34});
                    System.out.println("הפונקציה מחפשת את שלושת הערכים הגדולים ביותר במערך ומחזירה את סכומם");
                    System.out.println("סיבוכיות הפעולה הינה O(n) מכיוון ואנו עוברים על המערך פעם אחת בלבד");
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    bool = Q9("aaabbbBBAAAB");
                    System.out.println(bool);
                    break;
                case 10:
                    Q10(34, 34);
                    break;
                case 11:

                    break;
                case 12:
                    break;
                case 13:
                    break;
                case -1:
                    return;
            }
        }
    }

    private static boolean Q10(int num1, int num2) {

        int countDigitNum1 = (int) Math.log10(num1) + 1;
        int countDigitNum2 = (int) Math.log10(num2) + 1;

        if (countDigitNum1 != countDigitNum2)
            return false;

        int lsbNum1 = num1 % 10;
        int lsbNum2 = num2 % 10;
        while (num1 > 9) {
//countDigitNum1++;
            num1 /= 10;
        }
        //countDigitNum1++;

        while (num2 > 9) {
            // countDigitNum2++;
            num2 /= 10;
        }
        //countDigitNum2++;


        return lsbNum1 == lsbNum2 && num1 == num2;

    }

    private static boolean Q9(String str) {
        int balanceLetter[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);


            // ch<'A' ||  90 ~'Z' < ch < 97 ~ 'a'  ||  ch > 'z'
            if (ch < 'A' || ch > 'Z' && ch < 'a' || ch > 'z')
                return false;
            //65 - 90
            //ch = Z => ch-'A' = 25
            //ch = A => ch-'A' = 0
            if (ch >= 'A' && ch <= 'Z')
                balanceLetter[ch - 'A']--;
                // 97 - 122
            else
                balanceLetter['a' - ch]++;

            //aabaAAAB
            // {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
        }
        for (int i = 0; i < 26; i++) {
            if (balanceLetter[i] != 0)
                return false;
        }
        return true;
    }

    private static boolean Q9_TwoArrays(String str) {
        int lowerCase[] = new int[26];
        int upperCase[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch < 'A' || ch > 'Z' && ch < 'a' || ch > 'z')
                return false;
            //65 - 90
            //ch = Z => ch-'A' = 25
            //ch = A => ch-'A' = 0
            if (ch >= 'A' && ch <= 'Z')
                upperCase[ch - 'A']++;
                // 97 - 122
            else
                lowerCase['a' - ch]++;
        }
        for (int i = 0; i < 26; i++) {
            if (upperCase[i] != lowerCase[i])
                return false;
        }
        return true;
    }

    private static boolean Q3(int[] arr) {

        if (arr.length % 3 != 0)
            return false;

        int size = arr.length - arr.length / 3;
        for (int i = 0; i < size; i++) {

            if (arr[i] != arr[arr.length / 3 + i])
                return false;
        }
        return true;
    }

    private static void Q1() {

        int num1, num2, countNumber = 0, sumEven = 0, pairEqual = 0;

        while ((num1 = in.nextInt()) + (num2 = in.nextInt()) != 0 || num1 == 0 && num2 == 0) {
            countNumber++;
            sumEven += (num1 > 0) ? num1 : 0;
            sumEven += (num2 > 0) ? num2 : 0;
            pairEqual += (num1 == num2) ? 1 : 0;
        }
        System.out.println("countNumber is " + countNumber);
        System.out.println("sumEven is " + sumEven);
        System.out.println("pairEqual " + pairEqual);

    }

    public static int what(int[] arr) {

        System.out.println("              arr                  |        x        |        y        |        z        |");
        int x = arr[0];
        int y = 0;
        int z = 0;
        System.out.println("     " + Arrays.toString(arr) + "           |        " + x + "       |        " + y + "        |        " + z + "        |");
        for (int index = 1; index < arr.length; index++) {
            if (arr[index] > x) {
                z = y;
                y = x;
                x = arr[index];
            } else if (arr[index] > y) {
                z = y;
                y = arr[index];
            } else if (arr[index] > z) {
                z = arr[index];
            }
            System.out.println("     " + Arrays.toString(arr) + "           |        " + x + "       |        " + y + "        |        " + z + "        |");

        }
        System.out.println("     " + Arrays.toString(arr) + "           |        " + x + "       |        " + y + "        |        " + z + "        |");

        return x + y + z;
    }

}
