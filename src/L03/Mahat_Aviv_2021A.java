package L03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Aviv_2021A {

    static Scanner sc = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public static void main(String[] args) {
        boolean bool;

        while (true) {
            System.out.println("Enter q number");
            int numberQ = sc.nextInt();
            switch (numberQ) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    bool = q4(new int[]{1, 2, 3, 4, 5, 6, 7, 0, 56, 45, 85, 96, 15, 96, 56});
                    System.out.println(bool);
                    break;
                case 5:
                    what(new int[]{2, 4, 7, 12, 18}, 10);
                    System.out.println(ANSI_RESET);
                    what(new int[]{2, 4, 7, 12, 18}, 14);
                    System.out.println(ANSI_RESET);
                    System.out.println("הפעולה בודקת האם קיימים זוג מספרים אשר סכומם שווה ל - num");
                    System.out.println("סיבוכיות הפעולה הינה O(n) מכיוון ועוברים על המערך פעם אחת בלבד");
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    q8_a();
                    System.out.println(ANSI_RESET);

                    //m->0 , s->0

                    //x-> d[1].getTests() = 7
                    //d[1].getTests() = d[3].getTests()+2 = 4
                    //d[3].setTests = x = 7

                    //i=0 -> 3
                    //s -> 3
                    //m -> 1

                    //i=1 -> 4
                    //s -> 7
                    //m -> 1

                    //i=2 -> 1
                    //s -> 8
                    //m -> 1

                    //i=3 -> 7
                    //s -> 15
                    //m -> 2

                    //i=4 -> 7
                    //s -> 22
                    //m -> 3

                    // print -> 22 /5
                    // print -> 3

                    Driver[] d = new Driver[5];

                    d[0] = new Driver("Yossi", "1234", 2000, 3);
                    d[1] = new Driver("Avi", "7596", 1980, 7);
                    d[2] = new Driver("Sara", "6051", 1995, 1);
                    d[3] = new Driver("Dani", "4472", 1998, 2);
                    d[4] = new Driver("Maor", "4432", 1999, 2);


                    String[] names = q8_b(d, 3);
                    System.out.println(Arrays.toString(names));
                    break;
                case 9:
                    bool = q9_a("fA%B##rkC1^BAdd");
                    System.out.println("Is Palindrome -> " + bool);
                    String bigPalindrome = q9_b(new String[]{"fA%B##rkC1^BAdd", "ABCCBA", "fA%BC##rkC1^CBAdd", "12A21", "a0X$11$X0a"});
                    System.out.println("Big Palindrome is -> " + bigPalindrome);
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    bool = what("hello", "oeloh");
                    System.out.println(bool);
                    bool = what("hello", "eollh");
                    System.out.println(bool);
                    break;
                case -1:
                    return;

            }

        }

    }

    private static String q9_b(String[] palindromes) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < palindromes.length; i++) {

            if (q9_a(palindromes[i]) && palindromes[i].length() > max) {
                max = palindromes[i].length();
                index = i;
            }
        }
        return palindromes[index];
    }

    private static boolean q9_a(String str) {
        String buildBigPali = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
                buildBigPali += str.charAt(i);
        }

        int size = buildBigPali.length() - 1;

        for (int i = 0; i < size / 2; i++) {
            if (buildBigPali.charAt(i) != buildBigPali.charAt(size - i))
                return false;
        }
        return true;
    }

    private static String[] q8_b(Driver[] d, int num) {

        int count = 0;

        for (int i = 0; i < d.length; i++) {
            if (d[i].tests < num)
                count++;
        }

        String[] names = new String[count];
        count = 0;

        for (int i = 0; i < d.length; i++) {
            if (d[i].tests < num)
                names[count++] = d[i].name;
        }

        return names;
    }

    private static void q8_a() {

        Driver[] d = new Driver[5];
        d[0] = new Driver("Yossi", "1234", 2000, 3);
        d[1] = new Driver("Avi", "7596", 1980, 7);
        d[2] = new Driver("Sara", "6051", 1995, 1);
        d[3] = new Driver("Dani", "4472", 1998, 2);
        d[4] = d[3];
        int m = 0, s = 0;
        int x = d[1].getTests();
        d[1].setTests(d[3].getTests() + 2);
        d[3].setTests(x);
        for (int i = 0; i < d.length; i++) {
            if (new Random().nextBoolean())
                System.out.print(ANSI_CYAN);
            else
                System.out.print(ANSI_PURPLE);
            System.out.println("i=" + i + " -> " + d[i].getTests());
            s = s + d[i].getTests();
            System.out.println("s -> " + s);
            if (d[i].getYear() > 1995) {
                m++;
            }
            System.out.println("m -> " + s);
            System.out.println();
        }
        System.out.println("print -> " + s + "/" + d.length + " = " + (double) s / d.length);
        System.out.println("print -> " + m);

    }

    public static boolean what(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.length() == 0)
            return true;
        int place = s2.indexOf(s1.charAt(0));
        if (place < 0)
            return false;
        else {
            String a = s2.substring(0, place);
            String b = s2.substring(place + 1);
            String c = a.concat(b);
            return what(s1.substring(1), c);
        }
    }

    public static boolean what(int[] arr, int num) {
        System.out.print(ANSI_BLUE);
        System.out.println("         arr          |    num     |     k     |     p     |     s     ");
        System.out.println("-------------------------------------------------------------------------");
        System.out.print(ANSI_RESET);
        int k = 0;
        int p = arr.length - 1;
        int s;
        while (k < p) {
            s = arr[k] + arr[p];
            if (new Random().nextBoolean())
                System.out.print(ANSI_CYAN);
            else
                System.out.print(ANSI_PURPLE);
            System.out.println(Arrays.toString(arr) + "     |     " + num + "     |     " + k + "     |     " + p + "     |     " + ((s > 9) ? s : s + " ") + "     |");
            if (s < num) {
                k++;
            } else {
                if (s > num) {
                    p--;
                } else {
                    System.out.println("true");
                    return true;
                }
            }
        }
        System.out.println("false");
        return false;
    }

    //O(n)
    private static boolean q4(int[] arr) {

        if (arr.length % 2 == 0)
            return false;
        int i = 0;
        for (i = 0; i < arr.length / 2; i++) {
            if (arr[i] <= 0 || arr[i] > 9)
                return false;
        }
        if (arr[i++] != 0)
            return false;

        for (; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] < 10)
                return false;
        }

        return true;
    }

    static class Driver {
        private String name;
        private String id;
        private int year;
        private int tests;

        public Driver(String name, String id, int year, int tests) {
            this.name = name;
            this.id = id;
            this.year = year;
            this.tests = tests;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getTests() {
            return tests;
        }

        public void setTests(int tests) {
            this.tests = tests;
        }
    }
}