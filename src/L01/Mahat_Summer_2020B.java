package com.company.L01;

import java.util.Scanner;

public class Mahat_Summer_2020B {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter q number");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    q1();
                    break;
                case 2:


                case 3:
                    int mul;
                    mul = q3_a(4, 3);
                    mul = q3_a(5, 3);
                    mul = q3_a(3, 5);
                    mul = q3_a(1, 15);
                    mul = q3_a(15, 1);
                    System.out.println("C. Yes");
                    System.out.println("הפעולה מבצעת באופן כללי מכפלה בין שני מספרים באמצעות סכום");
                    int pow;

                    pow = q3_b(4, 3);
                    pow = q3_b(4, 2);
                    pow = q3_b(16, 1);
                    System.out.println("C. NO");
                    System.out.println("הפעולה מבצעת באופן כללי חזקה בין שני מספרים");

                    break;
                case 4:
                    boolean bool = q4(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
                case 10:
                    int ans = q10_a(new int[]{4, 10, 13, 71, 10, 10, 71, 71, 2, 10}, 71);
                    System.out.println(ans);
                    ans = q10_b(new int[]{4, 10, 13, 71, 10, 10, 71, 71, 2, 10});
                    System.out.println(ans);
                case -1:
                    return;

            }

        }
    }

    private static int q10_a(int[] arr, int num) {

        int countRight = 0;
        int countLeft = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                break;
            countLeft++;
        }
        if (countLeft == arr.length)
            return -1;

        for (int i = arr.length - 1; i > countLeft; i--, countRight++) {
            if (arr[i] == num)
                break;
        }

        return countLeft + countRight;

    }

    private static int q10_b(int[] arr) {
        int min = q10_a(arr, arr[0]);
        int number = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = q10_a(arr, i);
            if (min >= temp) {
                min = temp;
                number = arr[i];
            }
        }
        return number;
    }


    //O(n)
    private static boolean q4(int[] arr) {
        if (arr.length < 4 || arr.length % 2 == 1)
            return false;
        int sumFirst = 0;
        int sumSecond = 0;
        int middle = arr.length / 2;

        for (int i = 0; i < middle; i++) {
            sumFirst += arr[i];
        }
        for (int i = middle; i < arr.length; i++) {
            sumSecond += arr[i];
        }
        return sumFirst == sumSecond;
    }

    private static int q3_b(int x, int y) {

        System.out.println("----------------Why---------------");
        System.out.println("   x       y       z");
        int z = 1;
        System.out.println("   " + x + "       " + y + "       " + z);
        while (y > 0) {
            z = q3_a(z, x);// פעולת מכפלה
            y--;
            System.out.println("   x       y       z");
            System.out.println("   " + x + "       " + y + "       " + z);
            System.out.println("---------------------------------");
        }
        System.out.println("Ans = " + z);
        System.out.println("-----------------END----------------");

        return z;
    }

    private static int q3_a(int a, int b) {
        System.out.println(ANSI_BLACK);
        System.out.println("----------------What---------------");
        System.out.println("   a       b       c");
        int c = 0;
        System.out.println("   " + a + "       " + b + "       " + c);
        while (a > 0) {
            c = c + b;
            a--;
            System.out.println("   " + a + "       " + b + "       " + c);
        }
        System.out.println(c);
        System.out.println("-----------------------------------");
        System.out.println(ANSI_CYAN);
        return c;

    }

    private static void q1() {
        int countString = 0;
        int countDigit = 0;
        for (int i = 0; i < 50; i++) {
            String str = sc.next();
            int size = str.length();
            if (str.length() % 2 == 0)
                System.out.println(str.charAt(0));
            else
                System.out.println(str.charAt(size - 1));
            char ch = str.charAt(size - 1);
            countDigit += (ch >= '0' && ch <= '9') ? 1 : 0;
            if (str.charAt(0) == 'A')
                countString++;
        }
        System.out.println("count of A - " + countString);

        System.out.println("count of digit 0-9 - " + countDigit);

    }
}