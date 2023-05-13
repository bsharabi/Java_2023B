package L08;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2022A {


    static Scanner in = new Scanner(System.in);
    static Random rd = new Random();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {
        boolean bool;

        while (true) {

            System.out.println(ANSI_PURPLE + BOLD + "Enter q number" + ANSI_RESET);
            int numberQ = in.nextInt();
            switch (numberQ) {
                case 1:
                    break;
                case 2:
                    what(new int[]{1, 17, 12, 3, 10, 18}, 4);
                    System.out.println("הפונקציה מבצעת חלוקה של המערך כך שכל המספרים שקטנים מnum מצידו השמאלי והשאר מצידו הימני");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    bool = what(1804, 1957);
                    System.out.println(bool);

                    System.out.println("הפונקציה מחזירה ערך אמת אם ספרת ה-MSB של שתיהם שווה אך המספרים לא באותו אורך");

                    bool = what(1804, 19572);
                    System.out.println(bool);
//
                    bool = where(1234, 12);
                    System.out.println(bool);
                    System.out.println("הפונקציה מחזירה ערך אמת אם כמות הספרות שונה");

                    bool = where(0, 1);
                    System.out.println(bool);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    bool = Q9("hello");
                    break;
                case 10:
                  bool=  what(new int[][]{
                            {17, 16, 15, 14, 13},
                            {12, 11, 10, 9, 8},
                            {7, 6, 5, 4, 3},
                    });
                    System.out.println(bool);
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

    private static boolean Q9(String s) {
        int[] cntLetter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < 'a' || ch > 'z')
                return false;
            cntLetter[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cntLetter[i] > 1)
                return false;
        }
        return true;
    }

    public static void what(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        System.out.print(ANSI_BLUE);
        System.out.println("      arr                 left        right");
        System.out.print(ANSI_PURPLE);
        System.out.println(MessageFormat.format("{0}      {1}          {2}", Arrays.toString(arr), left, right));
        while (left != right) {
            if (arr[left] < num)
                left++;
            else if (arr[right] > num)
                right--;
            else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            System.out.println(MessageFormat.format("{0}      {1}          {2}", Arrays.toString(arr), left, right));
        }
        System.out.print(ANSI_RESET);
    }

    public static boolean what(int num1, int num2) {
        System.out.print(ANSI_BLUE);
        System.out.println("num1     num2");
        System.out.print(ANSI_PURPLE);
        System.out.println(MessageFormat.format("{0}       {1}  ", num1, num2));

        while (num1 >= 10 || num2 >= 10) {
            if (num1 >= 10 && num2 >= 10) {
                num1 = num1 / 10;
                num2 = num2 / 10;
            } else {
                if (num1 >= 10) {
                    num1 = num1 / 10;
                } else {
                    num2 = num2 / 10;
                }
                if (num1 == num2) {
                    return true;
                }
            }
            System.out.println(MessageFormat.format("{0}      {1}  ", num1, num2));
        }
        System.out.print(ANSI_RESET);
        return false;
    }

    public static boolean where(int num1, int num2) {
        System.out.print(ANSI_BLUE);
        System.out.println("num1     num2");
        System.out.print(ANSI_PURPLE);
        System.out.println(MessageFormat.format("{0}       {1}  ", num1, num2));
        while (num1 > 0 || num2 > 0) {
            if (num1 * num2 == 0)
                return true;
            num1 = num1 / 10;
            num2 = num2 / 10;
            System.out.println(MessageFormat.format("{0}      {1}  ", num1, num2));
        }
        System.out.print(ANSI_RESET);
        return false;
    }

    public static boolean what(int[][] mat) {
        for (int i = 0; i < mat.length - 1; i++)
            for (int j = 0; j < mat[0].length - 1; j++) {
                if (mat[i][j] < 0)
                    return false;
                if (mat[i][j] <= mat[i + 1][j])
                    return false;
                if (mat[i][j] <= mat[i][j + 1])
                    return false;
            }
        return true;
    }

}
