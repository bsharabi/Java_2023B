package L06;

import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2021B {


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
                    Q3("Java is a good language", 'a');
                    break;
                case 4:
                    Q4(new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5, 5});
                    Q4_b(new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5, 5});
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

    private static int Q4_b(int[] arr) {

        // arr.len =10 last index = 9
        // arr.len =11 last index = 9
        int index = (arr.length % 2 == 0) ? arr.length - 1 : arr.length - 2;

        return Math.min(arr[0], arr[index]);
    }

    private static boolean Q4(int[] arr) {

        for (int i = 2; i < arr.length; i += 2) {
            if (arr[i - 2] > arr[i])
                return false;
        }
        for (int i = 3; i < arr.length; i += 2) {
            if (arr[i - 2] < arr[i])
                return false;
        }
        return true;
    }

    private static void Q3(String s, char ch) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                for (int j = i; j < s.length(); j++) {
                    System.out.print(s.charAt(j));
                }
                System.out.println();
            }
        }
    }

    private static void Q1() {
    }

    static class Necklace {

        private int red;
        private int yellow;
        private int green;


        public Necklace(int red, int yellow, int green) {
            this.red = red;
            this.yellow = yellow;
            this.green = green;
        }

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public int getYellow() {
            return yellow;
        }

        public void setYellow(int yellow) {
            this.yellow = yellow;
        }

        public int getGreen() {
            return green;
        }

        public void setGreen(int green) {
            this.green = green;
        }

        private int helper() {
            return red + yellow + green;
        }

        public int checkNecklace() {

            if (red > 0 && green == 0 && yellow == 0 || green > 0 && red == 0 && yellow == 0 || yellow > 0 && green == 0 && red == 0)
                return 1;
            else if (red == yellow && yellow == green)
                return 2;
            else if (red > 0 && yellow > 0 && green == 0 ||
                    green > 0 && yellow > 0 && red == 0 ||
                    green > 0 && red > 0 && yellow == 0)
                return 3;
            else
                return 4;

        }

        public int q2_c(Necklace[] arr, int num) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].checkNecklace() == 3) {
                    if (arr[i].helper() > num)
                        count++;
                }
            }
            return count;
        }
    }


    static class Ceremony {

        private int songNumber;
        private int[] arrSong;

        public Ceremony(int songNumber) {
            this.songNumber = songNumber;
            arrSong = new int[30];

        }

        public int getSongNumber() {
            return songNumber;
        }

        public void setSongNumber(int songNumber) {
            this.songNumber = songNumber;
        }

        public void doChoices() {


            int first, second, third;

            while ((first = in.nextInt()) != 0 && (second = in.nextInt()) != 0 && (third = in.nextInt()) != 0) {
                arrSong[first - 1] += 5;
                arrSong[second - 1] += 3;
                arrSong[third - 1] += 1;
            }
        }

        public int winner() {
            int index = 0;
            int max = arrSong[index];

            for (int i = 1; i < arrSong.length; i++) {
                if (arrSong[i] > max) {
                    max = arrSong[i];
                    index = i;
                }
            }
            return index;
        }
    }
}
