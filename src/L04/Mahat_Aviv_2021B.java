package L04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Aviv_2021B {

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
                    q1();
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
                    what(183, 39);
                    int n1 = in.nextInt();
                    boolean ok = true;
                    int n2, count = 1;
                    while (ok == true) {
                        n2 = in.nextInt();
                        count++;
                        ok = what(n1, n2);
                        n1 = n2;
                    }
                    System.out.println(count);
                    //3,55,65,466,2
                    //111,111,111,211
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    int cnt = q9(new int[]{3, 2, 2, 2, 5, 6, 6, 1, 3, 3, 3, 3, 1, 2}, 1);
                    System.out.println(cnt);
                    break;
                case 10:
                    int a = q10_a(123);
                    bool = q10_b(new int[]{});
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
    //i=0 -> j=1=>n n-1
    //i=1 -> j=2=>n n-2
    //i=2 -> j=3=>n n-3
    // .
    // .
    // .
    // i=n -> j=n+1
    // n-n + n-(n-1) + n-(n-2)
    // 0 + 1 + 2 + 3 + . . . + n n(n+1)/2
    //O(n^2)
    private static boolean q10_b(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int temp = q10_a(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                if (q10_a(arr[j]) == temp)
                    return false;
            }
        }
        return true;
    }

    //O(n^2)
    private static boolean q10_c(int[] arr1, int[] arr2) {
        return q10_b(arr1) && q10_b(arr2);
    }
    //O(m) m is max len of number
    private static int q10_a(int num) {
        int sum = 0;
        num = Math.abs(num);
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static int block(int[] arr, int index) {
        int i;
        for (i = index; i < arr.length - 1; i++) {
            if (arr[index] != arr[i + 1])
                return i;
        }
        return i;
    }

    private static int q9_(int[] arr, int num) {
        int count = 0;
        for (int i = 0; i < arr.length; ) {
            int ans = block(arr, i);
            if (ans == i)
                i++;
            else {
                if (ans - i >= num)
                    count++;
                i = ans;
            }
        }
        return count;
    }

    private static int q9(int[] arr, int num) {
        int count = 0;

        for (int i = 0; i < arr.length - 1; ) {
            int j = i + 1;
            int countBlock = 1;
            while (j < arr.length) {
                if (arr[i] != arr[j]) {
                    i = j;
                    break;
                }
                countBlock++;
                j++;
            }

            if (countBlock >= num)
                count++;
        }
        return count;
    }

    private static void q1() {
        int sum = 0;
        for (int i = 0; i < 39; i++) {
            int num = rd.nextInt(900) + 100;
            sum += num;
            if (num % 2 == 0)
                System.out.println((num % 10) + ((num / 10) % 10) + num / 100);
        }
        System.out.println(sum / 39.0);
    }

    static class Book {

        private String name;
        private String author;
        private int pages;

        public Book(String name, String author, int pages) {
            this.name = name;
            this.author = author;
            this.pages = pages;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public boolean isSameBook(Book b) {
            return this.name.equals(b.name) && this.author.equals(b.author);
        }
    }

    static class Library {
        private Book[] bookArr;
        private int[] copyArr;
        private int current;

        public Library() {
            this.bookArr = new Book[2000];
            this.copyArr = new int[2000];
            this.current = 0;
        }

        public Book[] getBookArr() {
            return bookArr;
        }

        public void setBookArr(Book[] bookArr) {
            this.bookArr = bookArr;
        }

        public int[] getCopyArr() {
            return copyArr;
        }

        public void setCopyArr(int[] copyArr) {
            this.copyArr = copyArr;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public int bookPosition(Book b) {
            for (int i = 0; i < bookArr.length; i++) {
                if (b.isSameBook(bookArr[i]))
                    return i;
            }
            return -1;
        }

        public void add(Book b) {
            int index;
            if ((index = bookPosition(b)) != -1) {
                copyArr[index]++;
            } else if (current < bookArr.length) {
                bookArr[current] = b;
                copyArr[current]++;
                current++;
            }
        }

    }

    public static boolean what(int n1, int n2) {
        while (n2 > 9) {
            n2 = n2 / 10;
        }
        if (n1 % 10 == n2)
            return true;
        return false;
    }

}