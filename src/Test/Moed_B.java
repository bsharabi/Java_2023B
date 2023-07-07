package Test;

import java.lang.reflect.Array;
import java.util.*;

public class Moed_B {
    static Scanner in = new Scanner(System.in);
    static Random rd = new Random();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public static void main(String[] args) {
        boolean bool;
        int arr[];
        while (true) {
            System.out.println("Enter q number");
            int numberQ = in.nextInt();
            switch (numberQ) {
                case 1:
                    q1();
                    break;
                case 2:
                    String out = checkString("AB5T7F4FGH8GG4FF");
                    System.out.println(out);
                    break;
                case 3:
                    bool = isDifferencePow(new int[]{0, 0, 0, 0, 0, 0, 0});
                    System.out.println(bool);
                    bool = isDifferencePow(new int[]{6, 36, 900, 756900, 2147483647, 2147483647, 2147483647});
                    System.out.println(bool);

                    int[] a = buildDifferencePow(7, 0);
                    System.out.println(Arrays.toString(a));
                    a = buildDifferencePow(7, 6);
                    System.out.println(Arrays.toString(a));
                    break;
                case 4:
                    int newDate = calcDate(825);
                    System.out.println(newDate);
                    break;
                case 5:
                    Hotel hotel = new Hotel();
                    System.out.println(hotel);
                    System.out.println(hotel.free(1));
                    System.out.println(hotel.free(2));

                    System.out.println(hotel.check(1, 5));
                    System.out.println(hotel.check(2, 2));

                    break;
                case 6:
                    int[] arr1 = {4, 5, 7};
                    int[] arr2 = {3, 8, 6};
                    func(arr1, arr2);
                    arr1 = new int[]{1, 2, 3};
                    arr2 = new int[]{4, 5, 6};
                    func(arr1, arr2);

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    int[][] PrimeSymMatrix = {
                            {67, 45, 37, 11}
                            , {45, 68, 5, 4}
                            , {37, 5, 43, 5}
                            , {11, 4, 5, 5}};
                    int[][] SecondSymMatrix = {
                            {67, 45, 37, 11}
                            , {5, 43, 5, 37}
                            , {4, 15, 43, 45}
                            , {11, 4, 5, 67}};
                    int[][] generalMatrix = {
                            {67, 5, 37, 11}
                            , {45, 6, 5, 4}
                            , {637, 5, 443, 5}
                            , {161, 44, 5, 65}};

                    System.out.println(isSymmetric(PrimeSymMatrix));
                    System.out.println(isSymmetric(SecondSymMatrix));
                    System.out.println(isSymmetric(generalMatrix));

                    break;
                case 10:
                    System.out.println(getCalculatedSalary(5000, 30));
                    System.out.println(getCalculatedSalary(5500, 30));
                    System.out.println(getCalculatedSalary(3000, 20));
                    System.out.println(getCalculatedSalary(6000, 50));
                    Q10_b();
                    break;
                case 11:
                    int[] A = new int[]{10, 55, 69, 74, 80, 54, 41};
                    int[] B = new int[]{14, 35, 69, 74, 60, 54, 42};
                    System.out.println(Arrays.toString(A));
                    System.out.println(Arrays.toString(B));
                    arr = diff(A, B);
                    System.out.println(Arrays.toString(arr));
                    arr = Q11_B(A, B);
                    System.out.println(Arrays.toString(arr));
                    break;
                case 12:
                    arr = new int[]{24, 8, 1, 24, 8, 1, 7, 8, 1};
//                     arr = new int[]{0,0,0,0,0,0,0,0,0};
//                    arr = new int[]{15,9,2,25,9,2,8,9,2};
                    arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                    int res = whoAmI(arr);
                    System.out.println(res);
                    System.out.println(Arrays.toString(arr));
                    break;
                case 13:

                    break;
                case -1:
                    return;

            }

        }

    }

    //Q1
    private static void q1() {
        int countTemp = 0;
        int chocolate = 0;
        for (int i = 0; i < 10; i++) {
            double temperature = in.nextDouble();
            int toss = rd.nextInt(2, 9);
            if (toss > 3)
                chocolate++;
            if (temperature < 2)
                countTemp++;
        }
        System.out.println("The number of days when the temperature was below 2 degrees Celsius -> " + countTemp);
        System.out.println("Amount of chocolate cups -> " + chocolate);
    }

    //Q2
    public static String checkString(String str) {
        int countNumber = 0;
        int size = str.length();
        char first = str.charAt(0);
        char last = str.charAt(size - 1);
        int firstNumber = -1;
        int lastNumber = -1;
        if (first < 'A' || first > 'Z' || last < 'A' || last > 'Z')
            return "ERROR";

        for (int i = 0; i < size; i++) {
            char ch = str.charAt(i);
            if (ch < '0' || ch > '9' && ch < 'A' || ch > 'Z') {
                return "ERROR";
            }
            if (ch <= '9') {
                if (firstNumber == -1)
                    firstNumber = ch - '0';
                lastNumber = ch - '0';
                countNumber++;
            }
        }
        if (countNumber != 5)
            return "ERROR";

        String newS = "";
        for (int i = 0; i < firstNumber; i++)
            newS += first;
        for (int i = 0; i < lastNumber; i++)
            newS += last;

        return newS;
    }

    //Q3
    private static int[] buildDifferencePow(int size, int first) {

        int[] arr = new int[size];
        arr[0] = first;
        int dif = first;
        for (int i = 1; i < size; i++) {
            arr[i] = (int) Math.pow(dif, 2);
            dif = Math.abs(dif - arr[i]);
        }
        return arr;
    }

    //Q3
    private static boolean isDifferencePow(int[] arr) {

        int size = arr.length;
        int dif = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] != (int) Math.pow(dif, 2))
                return false;
            dif = Math.abs(dif - arr[i]);
        }
        return true;
    }

    //Q4
    public static int calcDate(int date) {
        int month = date / 100;
        int day = date % 100;
        System.out.println("Today is " + day + "." + month);
        System.out.println("Enter number between 1 and 10");
        int dayInput;
        while ((dayInput = in.nextInt()) < 1 || dayInput > 10)
            System.out.println("Invalid argument");
        int newDay = 0;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            newDay = ((day + dayInput) % 31);
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            newDay = ((day + dayInput) % 31);
        else if (month == 2)
            newDay = ((day + dayInput) % 31);
        month = (newDay < day) ? month + 1 : month;
        System.out.println(newDay + "," + month);
        return month * 100 + newDay;
    }

    //Q5
    public static class Room {
        private int roomNum; // מס. חדר בן 3 ספרות
        private int roomType; // סוג החדר : 1 רגיל, 2 סוויטה
        private int nights; // לכמה לילות החדר תפוס כרגע. 0 משמעו חדר פנוי

        public Room(int roomNum, int roomType, int nights) {
            this.roomNum = roomNum;
            this.roomType = roomType;
            this.nights = nights;
        }

        public int getRoomNum() {
            return roomNum;
        }

        public void setRoomNum(int roomNum) {
            this.roomNum = roomNum;
        }

        public int getRoomType() {
            return roomType;
        }

        public void setRoomType(int roomType) {
            this.roomType = roomType;
        }

        public int getNights() {
            return nights;
        }

        public void setNights(int nights) {
            this.nights = nights;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "roomNum=" + roomNum +
                    ", roomType=" + roomType +
                    ", nights=" + nights +
                    '}';
        }
    }

    public static class Hotel {
        private Room[] rooms;

        public Hotel() {
            this.rooms = new Room[200];
            for (int i = 0; i < 200; i++) {
                rooms[i] = new Room((i + 1) + 100, rd.nextInt(2) + 1, rd.nextInt(4));
            }
        }

        public Room free(int type) {
            for (int x = 0; x < rooms.length; x++)
                if (type == rooms[x].getRoomType() && rooms[x].getNights() == 0)
                    return rooms[x];
            return null;
        }

        public int check(int type, int night) {
            Room room = free(type);
            if (room != null) {
                room.setNights(night);
                System.out.println(room);
                return (type == 1) ? night * 300 : night * 500;
            }
            return -1;
        }

        @Override
        public String toString() {
            return "Hotel{" +
                    "rooms=" + Arrays.toString(rooms) +
                    '}';
        }
    }

    //Q6
    public static void func(int[] arr1, int[] arr2) {
        int i, j, temp;
        for (i = 0; i < arr1.length; i++) {
            for (j = 0; j < arr2.length; j++) {
                if (arr1[i] > arr2[j]) {
                    temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    //Q7
    static class Questionnaire {
        private String name;
        private String QNumber;
        private String[] ids;
        private int SNumber;

        public Questionnaire(String name, String QNumber) {
            this.name = name;
            this.QNumber = QNumber;
            this.ids = new String[100];
            this.SNumber = 0;
        }

        public boolean addStudent(String id) {
            if (SNumber > ids.length)
                return false;
            ids[SNumber++] = id;
            return true;
        }

        public boolean IsRegister(String id) {
            for (int i = 0; i < SNumber; i++) {
                if (ids[i].equals(id))
                    return true;
            }
            return false;
        }
    }

    //Q8
    static public class Car {
        private int Year;
        private int Code;
        private int Type;
        private double price;

        public Car() {
        }

        public Car(int Year, int Code, double price) {
            this.Year = Year;
            this.Code = Code;
            this.price = price;
        }

        public int getYear() {
            return Year;
        }

        public void setYear(int year) {
            Year = year;
        }

        public int getCode() {
            return Code;
        }

        public void setCode(int code) {
            Code = code;
        }

        public int getType() {
            return Type;
        }

        public void setType(int type) {
            Type = type;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    static public class Company {
        private int Code;
        private Car[] our_cars = new Car[100];

        public Car maxSportPrice() {
            double max = 0;
            Car car = null;
            for (int i = 0; i < our_cars.length; i++) {
                car = our_cars[i];
                if (our_cars[i].getType() == 1)
                    if (car.getPrice() > max)
                        max = car.getPrice();
            }
            return car;
        }

        public double avg_cars_price() {
            double avg = 0;
            for (int i = 0; i < our_cars.length; i++) {
                avg += our_cars[i].getPrice();
            }
            return avg / our_cars.length;
        }

        public double price_of_cars() {
            int i, cnt = 0;
            double p = 0;
            for (i = 0; i < our_cars.length; i++) {
                if (our_cars[i].getPrice() > 10000) {
                    p += our_cars[i].getPrice();
                    cnt++;
                }
            }
            if (cnt > 0)
                return (double) p / 100;
            else
                return 0;
        }


    }

    //Q9
    static public int isSymmetric(int[][] matrix) {
        int n = matrix.length;
        boolean primary = false;
        boolean second = false;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    primary = true;
                    break;
                }
            }
        }
        if (!primary)
            return 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (matrix[i][j] != matrix[n - 1 - j][n - 1 - i]) {
                    second = true;
                    break;
                }
            }
        }
        if (!second)
            return 2;
        return 0;
    }

    //Q10
    static public double getCalculatedSalary(double salary, int age) {
        if (age > 50 && salary > 5000) {
            return salary - salary * 0.30;
        }
        if (age > 30 && salary <= 5000) {
            return salary - salary * 0.10;
        }
        return salary;
    }

    static public void Q10_b() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            int age = rd.nextInt(16, 100);
            double salary = rd.nextDouble(17.89 * 186, 32.5 * 186);
            double newSalary = getCalculatedSalary(salary, age);
            System.out.println(newSalary);
            if (newSalary > 5000) {
                count++;
            }
        }
        System.out.println(count);
    }

    //Q11
    public static int[] diff(int[] A, int[] B) {
        int n = 90;
        int[] counterA = new int[n];
        int[] counterB = new int[n];
        int countDiff = 0;
        for (int i = 0; i < A.length; i++)
            counterA[A[i] - 10]++;
        for (int i = 0; i < B.length; i++)
            counterB[B[i] - 10]++;

        for (int i = 0; i < n; i++)
            if (counterA[i] > 0 && counterB[i] == 0)
                countDiff++;
        int[] diffArr = new int[countDiff];
        countDiff = 0;
        for (int i = 0; i < n; i++)
            if (counterA[i] > 0 && counterB[i] == 0)
                diffArr[countDiff++] = i+10;
        return diffArr;
    }

    public static int[] Q11_B(int[] A, int[] B) {
        int n = 90;
        int[] counterA = new int[n];
        int[] counterB = new int[n];
        int countComp = 0;
        for (int i = 0; i < A.length; i++)
            counterA[A[i] - 10]++;
        for (int i = 0; i < B.length; i++)
            counterB[B[i] - 10]++;

        for (int i = 0; i < n; i++)
            if (counterA[i] == 0 && counterB[i] == 0)
                countComp++;
        int[] newArr = new int[countComp];
        countComp = 0;
        for (int i = 0; i < n; i++)
            if (counterA[i] == 0 && counterB[i] == 0)
                newArr[countComp++] = i+10;
        return newArr;
    }
    //Q12
    public static int whoAmI(int[] arr) {
        int mone1 = 0;
        int mone2 = 0;
        int y = arr.length / 3;
        for (int x = 0; x < y; x++) {
            if (arr[x] != arr[x + y]) {
                mone1++;
            }
        }
        if (mone1 == 0) {
            for (int x = 0; x < y; x++) {
                if (arr[x] != arr[x + y * 2]) {
                    mone2++;
                }
            }
        }
        if ((mone1 == 0) && (mone2 == 0)) {
            return 3;
        }
        if (mone2 > 0) {
            return 1;
        }
        return 0;
    }

}
