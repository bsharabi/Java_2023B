package L09;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2022B {


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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:

                    break;
                case 7:
                    break;
                case 8:
                    int[] arr = why(new int[]{6, 6, 2, 7, 7, 7, 9, 7, 7, 3});
                    System.out.println(Arrays.toString(arr));
                    System.out.println("הפונקציה בונה מערך חדש המכיל את הערכים מהמערך שהתקבל כפרמטר ללא כפילויות של הרצפים");
                    System.out.println("הפונקציה מחזירה מערך חדש ללא רצף של כפילויות");
                    break;
                case 9:
                    String str = "Hello";
                    bool = Q9(str);
                    break;
                case 10:
                    bool = what(new int[][]{{5, 3, 1, 4}, {10, 1, 1, 1}, {8, 2, 2, 1}});
                    System.out.println(bool);
                    bool = what(new int[][]{{5, 3, 1, 4}, {18,-3,-1,-1}, {20, -2, -2, -3}});
                    System.out.println(bool);
                    bool = what(new int[][]{{5, 3, 1, 4}, {18,-3,1,-1}, {20, -2, -2, -3}});
                    System.out.println(bool);
                    System.out.println("סכום כל שורה שווה לסכום השורה הראשונה במטריצה");
                    System.out.println("סיבוכיות הפעולה בהנחה שמספר השורות הינו n ומספר העמודות הינו m אזי O(m*n)");
                    break;
                case 11:
                    break;
                case 12:
                    Book b = new Book();

                    break;
                case 13:
                    sod(3234);
                    int n = 3;
                    sod(n);
                    int a[] = new int[]{17, 5, 864, 51, 77, 789};
                    secret(a);
                    break;
                case 14:
                    break;
                case -1:
                    return;
            }
        }
    }

    public static double sod(int n) {
        return sod(n, 0, 0);
    }

    private static double sod(int n, int c, double a) {
        if (n == 0 && c == 0) return 0;
        else if (n == 0) return a / c;
        else return sod(n / 10, c + 1, a + (n % 10));
    }

    public static boolean secret(int[] a) {
        return secret(a, a.length - 1);
    }

    public static boolean secret(int[] a, int m) {
        if (m == 0) return true;
        else
            return secret(a, m - 1) && (sod(a[m]) - sod(a[m - 1]) == 1);
    }

    public class Library {
        private Book[] books;

        public boolean isAvailable(int code) {
            return true;
        }

        public void print(String genre, int rate) {

        }
    }

    static public class Book {
        private int code; // הספר קוד
        private String name; // הספר שם
        private int[] ratings;
        private String genre;
        private int numOfCopies;

        public void updateRating(int rate) {
        }

        public double calcRating() {
            return 0;
        }


    }

    private static boolean Q9(String str) {
        if (str == null || str.length() < 2)
            return false;

        int[] letters = new int[26];

        boolean isLower = false, isUpper = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z')
                isUpper = true;
            else if (ch >= 'a' && ch <= 'z')
                isLower = true;
            else
                return false;
        }
        if (isLower && isUpper)
            return false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isLower)
                letters[ch - 'a']++;
            else
                letters[ch - 'A']++;
        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] % 2 != 0)
                return false;
        }
        return true;
    }

    public static boolean what(int[][] arr) {
        int tempSum;
        int sum = 0;
        for (int j = 0; j < arr[0].length; j++)
            sum += arr[0][j];
        for (int i = 1; i < arr.length; i++) {
            tempSum = 0;
            for (int j = 0; j < arr[i].length; j++)
                tempSum += arr[i][j];
            if (tempSum != sum)
                return false;
        }
        return true;
    }

    // why(new int[]{6, 6, 2, 7, 7, 7, 9, 7, 7, 3});
    public static int[] why(int[] arr) {
        System.out.println("arr[i]  arr[i-1]                 temp                      count");
        int[] temp = new int[arr.length];
        temp[0] = arr[0];
        int count = 1;
        System.out.println(MessageFormat.format("   {0}     {1}             {2}    {3} ", arr[0], arr[1], Arrays.toString(temp), count));
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                temp[count] = arr[i];
                count++;
            }
            System.out.println(MessageFormat.format("   {0}     {1}             {2}    {3} ", arr[i], arr[i - 1], Arrays.toString(temp), count));
        }
        int[] res = new int[count];
        for (int i = 0; i < count; i++)
            res[i] = temp[i];
        return res;
    }

}
