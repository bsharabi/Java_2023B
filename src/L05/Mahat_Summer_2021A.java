package L05;

import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2021A {

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
                    Q2();
                    break;
                case 3:
                    Q3("ababab", "ab");
                    break;
                case 4:
                    int index = Q4(new int[]{});
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    int[] res = Q11_A(new int[]{}, new int[]{});
                    bool = Q11_B(new int[]{}, new int[]{});

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

    //    private static int Q4(int[] arr) {
//        int max = arr[0];
//        int index = 0;
//
//        // מחפשים את האיבר המקסימלי במערך ואת מיקומו
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > max) {
//                max = arr[i];
//                index = i;
//            }
//        }
//        for (int i = 1; i < index; i++) {
//            if (arr[i] <= arr[i - 1])
//                return -1;
//        }
//        for (int i = index+1; i < arr.length; i++) {
//            if (arr[i] >= arr[i - 1])
//                return -1;
//        }
//
//        return index;
//
//    }
//
    // הפונקציה מחפשת את סכום סדרת המספרים הגדולה ביותר
    public static int what(int [] arr)
    {
        //{-2,-3,4,-1,-2,1,5,-3}
        int m =arr[0]; int s=0;
        //m=-2, s=0
        for( int i=0; i<arr.length; i++)
        {
            s=s+arr[i];
            // s = -2 i=0 -> s=0
            // s = -3 i =1 -> s=0
            // s =4 i=2 -> s=4 , m=4
            // s = 3 i=3 -> s=3, m=4
            // s = 1 i=4 -> s=1, m=4
            // s = 2 i=5 -> s=2, m=4
            // s = 7 i=6 -> s=7, m=7
            // s = 4 i =7 - > s=4 , m=7
            if(s>m)
                m=s;
            if(s<0)
                s=0;
        }
        return m;
    }

    //O(n)
    private static int Q4(int[] arr) {
        int i;

        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1])
                break;
        }
        int index = i;
        for (; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1])
                return -1;
        }
        return index;

    }

    private static void Q2() {

    }

    private static boolean Q11_B(int[] a, int[] b) {
        return (Q11_A(a, b).length == 0);
    }

    private static boolean helper(int[] a, int num) {
        for (int item : a) {
            if (item == num)
                return true;
        }
        return false;
    }

    //    private static int[] Q11_A(int[] b, int[] c) {
//        // שלב ראשון נגדיר משתנה ספירה על מנת שנדע כמה ערכים מקימים שהם גם נמצאים במערך b וגם נמצאים במערך c
//        int counter = 0;
//        // שלב הספירה
//        // נרוץ על אחד מהמערכים עד גודלו ובכל איטרציה נבדוק האם המערך עליו רצנו במיקום i ערכו נמצא באיזשהו מיקום במערך השני
//        for (int i = 0; i < b.length; i++) {
//            if (helper(c, b[i]))
//                counter++;
//        }
//        int[] newArray = new int[counter];
//        counter = 0;
//        for (int i = 0; i < b.length; i++) {
//            if (helper(c, b[i]))
//                newArray[counter++] = b[i];
//        }
//        return newArray;
//    }
    // c={1,3,4,10,5,7, 5,1,100, 7}
    // b={3,9,1,10,2,10,5}
//    private static int[] Q11_A(int[] b, int[] c) {
//        // שלב ראשון נגדיר משתנה ספירה על מנת שנדע כמה ערכים מקימים שהם גם נמצאים במערך b וגם נמצאים במערך c
//        int counter = 0;
//        // שלב הספירה
//        // נרוץ על אחד מהמערכים עד גודלו ובכל איטרציה נבדוק האם המערך עליו רצנו במיקום i ערכו נמצא באיזשהו מיקום במערך השני
//        for (int i = 0; i < b.length; i++) {
//            for (int j = 0; j < c.length; j++) {
//                if (b[i] == c[j])
//                    counter++;
//            }
//        }
//        int[] newArray = new int[counter];
//        counter = 0;
//        for (int i = 0; i < b.length; i++) {
//            if (helper(c, b[i]))
//                newArray[counter++] = b[i];
//        }
//        return newArray;
//    }
    private static int[] Q11_A(int[] b, int[] c) {
        int counter[] = new int[90];
        int cntArray = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (b[i] == c[j]) {
                    counter[b[i] - 10]++;
                    cntArray += (counter[b[i] - 10] == 1) ? 1 : 0;
                    break;
                }
            }
        }
        int[] newArray = new int[cntArray];
        cntArray = 0;
        for (int i = 0; i < 90; i++) {
            if (counter[i] != 0)
                newArray[cntArray] = i + 10;
        }
        return newArray;
    }

    private static boolean Q3(String s1, String s2) {
        int temp = s1.length() / s2.length();
        String newStr = "";

        for (int i = 0; i < temp; i++) {
            newStr += s2.length();
        }
        return newStr.equals(s1);
    }

    private static void Q1() {

        double avg = 0;
        int sum = 0;
        int[] inputs = new int[35];
        for (int i = 0; i < 35; i++) {
            inputs[i] = in.nextInt();
            sum += inputs[i];
        }
        avg = sum / 35.0;
        for (int i = 0; i < 35; i++) {
            if (inputs[i] > avg)
                System.out.println(inputs[i]);
        }
    }

    static class Garbage {

        private String location;
        private double capacity;
        private double quantity;

        public String getLocation() {
            return location;
        }

        public double getCapacity() {
            return capacity;
        }

        public double getQuantity() {
            return quantity;
        }
    }
}