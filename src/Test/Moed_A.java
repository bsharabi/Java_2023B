package Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Moed_A {


    static Scanner in = new Scanner(System.in);
    static Random rd = new Random();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public static void main(String[] args) {
        boolean bool;
        String input;
        int ans;
        while (true) {
            System.out.println("Enter q number");
            int numberQ = in.nextInt();
            switch (numberQ) {
                case 1:
                    if (isPangram())
                        System.out.println("The string is a pangram");
                    else
                        System.out.println("The string is not a pangram");
                    break;
                case 2:
                    ans = calcPrice(1150);
                    System.out.println("new Price " + ans);
                    break;
                case 3:
                    int arr[] = new int[]{0, 1, 3, 7, 15, 31, 63};
                    bool = isSumsArray(arr);
                    System.out.println("The array " + Arrays.toString(arr) + " is sum array " + bool);
                    arr = new int[]{6, 7, 15, 31, 63, 127, 255};
                    bool = isSumsArray(arr);
                    System.out.println("The array " + Arrays.toString(arr) + " is sum array " + bool);

                    arr = buildSumsArray(7, 0);
                    System.out.println(Arrays.toString(arr));
                    arr = buildSumsArray(7, 6);
                    System.out.println(Arrays.toString(arr));
                    break;
                case 4:
                    Student[] students = new Student[10];
                    for (int i = 0; i < students.length; i++) {
                        int random = rd.nextInt(2);
                        students[i] = new Student(i + "-b", (random == 0) ? 'W' : 'M');
                    }
                    System.out.println(isBalancedArray(students));
                    break;
                case 5:
                    int[][] mat = {{12, 29, 16, 19, 23, 29},
                            {25, 1, 6, 19, 1, 4},
                            {19, 9, 25, 6, 6, 25},
                            {1, 22, 22, 2, 19, 17},
                            {6, 22, 5, 8, 17, 16},
                            {0, 21, 26, 3, 3, 2}};
                    System.out.println(Arrays.deepToString(mat));
                    ans = what((mat));
                    System.out.println(Arrays.deepToString(mat));
                    System.out.println(ans);
                    break;
                case 6:
                    input = "AbC5E3GhIjA4Cd7fGhIj";
                    System.out.println(func(input, ""));
                    System.out.println(func("12345", ""));
                    break;
                case 7:
//                    Q7_a();
                    Q7_aTest();
                    break;
                case 8:
                    int x = sod1(123);
                    System.out.println("sod1 output -> " + x);
                    x = sod2(494949494);
                    System.out.println("sod2 output -> " + x);
                    x = sod3(123, 68);
                    System.out.println("sod3 output -> " + x);
                    x = sod3(35, 79283);
                    System.out.println("sod3 output -> " + x);
                    break;
                case 9:

                    break;
                case 10:
                    bool = isValidParentheses("{()}");
                    System.out.println("1. " + bool);
                    bool = isValidParentheses("{{(())}}");
                    System.out.println("2. " + bool);
                    bool = isValidParentheses("{({})}");
                    System.out.println("3. " + bool);
                    bool = isValidParentheses("(){}()");
                    System.out.println("4. " + bool);
                    bool = isValidParentheses("())");
                    System.out.println("5. " + bool);
                    bool = isValidParentheses("{{(()})}");
                    System.out.println("6. " + bool);
                    bool = isValidParentheses("(}");
                    System.out.println("7. " + bool);
                    bool = isValidParentheses("");
                    System.out.println("8. " + bool);
                    bool = isValidParentheses("4{}");
                    System.out.println("9. " + bool);
                    break;
                case 11:
                    int[] arr2 = new int[]{3, 2, 8, 1, 5, 3, 2, 6, 1, 9};
                    System.out.println(Arrays.toString(arr2));
                    shift(arr2);
                    System.out.println(Arrays.toString(arr2));
                    shiftFive();
                    break;
                case 12:
                    break;
                case -1:
                    return;

            }

        }

    }

    //Q1
    private static boolean isPangram() {
        System.out.println("Enter string to check");
        in.nextLine();
        String input = in.nextLine();
        boolean[] exist = new boolean[26];
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                exist[ch - 'a'] = true;
        }
        for (int i = 0; i < 26; i++)
            if (!exist[i])
                return false;
        return true;
    }

    //Q2
    public static int calcPrice(int price) {
        int code = price / 100;
        int currentPrice = price % 100;
        int input;
        System.out.println("Enter discount between 20 and 30");
        while ((input = in.nextInt()) < 20 || input > 30)
            System.out.println("Try again, enter discount between 20 and 30");

        currentPrice -= (input * currentPrice) / 100;
        System.out.println(code + "," + currentPrice);
        return (code * 100) + currentPrice;
    }

    //Q3_a
    public static boolean isSumsArray(int[] arr) {
        if (arr == null)
            return false;
        int sum = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] != sum + i)
                return false;
            sum += arr[i];
        }
        return true;
    }

    //Q3_b
    public static int[] buildSumsArray(int size, int first) {
        if (size <= 0)
            return null;

        int[] temp = new int[size];
        int sum = temp[0] = first;

        for (int i = 1; i < size; i++) {
            temp[i] = sum + i;
            sum += temp[i];
        }

        return temp;
    }

    //Q4
    static public class Student {
        private String name;
        // ----- for q4 ------
        private double height;
        private double weight;
        private char gender;
        //--------------------
        // for q12
        private int Code;
        private int dep;
        private Course[] st_courses;
        //--------------------

        public Student(String name, char gender) {
            this.gender = gender;
            this.name = name;
            if (gender == 'M') {
                height = rd.nextInt(165, 185);
                weight = rd.nextInt(60, 80);


            } else if (gender == 'W') {
                height = rd.nextInt(155, 175);
                weight = rd.nextInt(45, 60);
            }
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public char getGender() {
            return gender;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }

        public int getCode() {
            return Code;
        }

        public void setCode(int code) {
            Code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDep() {
            return dep;
        }

        public void setDep(int dep) {
            this.dep = dep;
        }

        public Course[] getSt_courses() {
            return st_courses;
        }

        public void setSt_courses(Course[] st_courses) {
            this.st_courses = st_courses;
        }

        public double getAvg() {
            double sum = 0;
            for (int i = 0; i < st_courses.length; i++) {
                if (st_courses[i].getType() == 3)
                    sum += st_courses[i].getGrade();
            }
            return sum / st_courses.length;
        }

        public int getProjCourseCount() {
            int count = 0;
            for (int i = 0; i < st_courses.length; i++) {
                if (st_courses[i].getType() == 1 && st_courses[i].getGrade() > 80)
                    count++;
            }
            return count;
        }
    }

    //Q4_b
    public static boolean isBalancedArray(Student[] arr) {
        int check = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getGender() == 'M')
                check++;
            else if (arr[i].getGender() == 'W')
                check--;
        }
        return (check == 0);
    }

    //Q5
    public static int what(int[][] mat) {
        int[] b = new int[mat.length];
        int k = 0;
        for (int i = 0; i < mat.length; i++) {
            int x = mat[i][0];
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] > x)
                    x = mat[i][j];
            }
            mat[i][k++] = x;
        }
        k = 0;
        for (int i = 0; i < b.length; i++) {
            b[i] = mat[i][k++];
        }
        int x = b[0];
        for (int i = 1; i < b.length; i++) {
            if (x - b[i] < 0)
                x = b[i];
        }
        return x;
    }

    //Q6
    public static String func(String str, String newStr) {
        if (str.isEmpty())
            return newStr;
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            for (int i = 0; i < str.charAt(0) - '0'; i++)
                newStr += str.charAt(0);
        }
        return func(str.substring(1), newStr);
    }

    //Q7
    public static void Q7_a() {

        int[] votes = new int[40];
        int input;
        int first = 0, second = 1, third = 2;

        for (int i = 0; i < 300; i++) {
            int[] vote = new int[40];
            for (int j = 0; j < 10; ) {
                if ((input = in.nextInt()) < 1 || input > 40) {
                    System.out.println("You must choose a song between 1 and 40");
                } else if (vote[input - 1] != 0)
                    System.out.println("Each song can be voted once");
                else {
                    vote[input - 1]++;
                    votes[input - 1]++;
                    j++;
                    if (votes[input - 1] > votes[first]) {
                        third = second;
                        second = first;
                        first = input - 1;
                    } else if (votes[input - 1] > votes[second]) {
                        third = second;
                        second = input - 1;
                    } else if (votes[input - 1] > votes[third])
                        third = input - 1;
                }
            }
        }
        System.out.println(Arrays.toString(votes));
        System.out.println("first -> " + first + " second ->" + second + " third -> " + third);
    }

    //Q7 test with random
    public static void Q7_aTest() {

        int[] votes = new int[40];
        int input;
        int first = 0, second = 1, third = 2;

        for (int i = 0; i < 10; i++) {
            int[] vote = new int[40];
            for (int j = 0; j < 10; ) {
                if ((input = rd.nextInt(0, 50)) < 1 || input > 40) {
                    System.out.println("You must choose a song between 1 and 40");
                } else if (vote[input - 1] != 0)
                    System.out.println("Each song can be voted once");
                else {
                    vote[input - 1]++;
                    votes[input - 1]++;
                    j++;
                    if (votes[input - 1] > votes[first]) {
                        third = second;
                        second = first;
                        first = input - 1;
                    } else if (votes[input - 1] > votes[second]) {
                        third = second;
                        second = input - 1;
                    } else if (votes[input - 1] > votes[third])
                        third = input - 1;
                }
            }
        }
        System.out.println(Arrays.toString(votes));
        System.out.println("first -> " + first + " second ->" + second + " third -> " + third);
    }

    //Q8
    public static int sod3(int x, int y) {
        if (y == 0)
            return x;
        y /= 10;
        int temp1 = (x * 10) + sod1(y);
        int temp2 = sod2(y);
        return sod3(temp1, temp2);

    }

    //Q8
    private static int sod2(int x) {
        if (x < 10)
            return x;
        return sod2(x / 10) * 10 + (x % 10);
    }

    //Q8
    private static int sod1(int x) {
        if (x < 10)
            return x;
        return sod1(x / 10);
    }

    //Q9
    static class Lecturer extends Employee {
        private boolean extensionStudy;

        public Lecturer(String name, String id, int seniority, boolean extensionStudy) {
            super(name, id, seniority);
            this.extensionStudy = extensionStudy;
        }

        public Lecturer(boolean extensionStudy) {
            this.extensionStudy = extensionStudy;
        }

        public boolean isExtensionStudy() {
            return extensionStudy;
        }

        public void setExtensionStudy(boolean extensionStudy) {
            this.extensionStudy = extensionStudy;
        }
    }

    //Q9
    static class Practitioner extends Employee {
        private Lecturer[] lecturers;

        public Practitioner(String name, String id, int seniority, Lecturer[] lecturers) {
            super(name, id, seniority);
            this.lecturers = lecturers;
        }

        public Practitioner(Lecturer[] lecturers) {
            this.lecturers = lecturers;
        }

        public Lecturer[] getLecturers() {
            return lecturers;
        }

        public void setLecturers(Lecturer[] lecturers) {
            this.lecturers = lecturers;
        }
    }

    //Q9
    static class HeadDepartment extends Employee {
        private Lecturer[] lecturers;
        private Practitioner[] practitioners;

        public boolean hasExtensionStudy() {
            for (int i = 0; i < lecturers.length; i++) {
                if (!lecturers[i].extensionStudy)
                    return false;
            }
            return true;
        }

        public HeadDepartment(String name, String id, int seniority, Lecturer[] lecturers, Practitioner[] practitioners) {
            super(name, id, seniority);
            this.lecturers = lecturers;
            this.practitioners = practitioners;
        }

        public HeadDepartment(Lecturer[] lecturers, Practitioner[] practitioners) {
            this.lecturers = lecturers;
            this.practitioners = practitioners;
        }

        public Lecturer[] getLecturers() {
            return lecturers;
        }

        public void setLecturers(Lecturer[] lecturers) {
            this.lecturers = lecturers;
        }

        public Practitioner[] getPractitioners() {
            return practitioners;
        }

        public void setPractitioners(Practitioner[] practitioners) {
            this.practitioners = practitioners;
        }
    }

    //Q9
    static class Employee {
        private String name;
        private String id;
        private int Seniority;

        public Employee(String name, String id, int seniority) {
            this.name = name;
            this.id = id;
            Seniority = seniority;
        }

        public Employee() {
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

        public int getSeniority() {
            return Seniority;
        }

        public void setSeniority(int seniority) {
            Seniority = seniority;
        }
    }

    //Q9
    static public void q9(Employee[] employees) {
        for (Employee employee : employees)
            if (employee instanceof HeadDepartment)
                if (((HeadDepartment) employee).hasExtensionStudy())
                    System.out.println(employee.name);
    }

    //Q10
    public static boolean isValidParentheses(String input) {
        if (input.length() == 0 || input.length() % 2 != 0)
            return false;

        String help = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != '(' && ch != ')' && ch != '{' && ch != '}')
                return false;
            if (ch == '(' || ch == '{')
                help += ch;
            else {
                int size =help.length();
                if (size == 0)
                    return false;
                char open = help.charAt(size - 1);
                if (open == '{' && ch == '}' || open == '(' && ch == ')') {
                    String temp = "";
                    for (int j = 0; j < size - 1; j++) {
                        temp += help.charAt(j);
                    }
                    help = temp;
                } else {
                    return false;
                }
            }
        }
        return help.length() == 0;
    }

    //Q11
    public static void shift(int[] input) {

        for (int i = 0; i < 8; i++) {
            input[i] = input[i + 2];
        }
        input[9] = input[8] = 0;
    }

    //Q11
    public static void shiftFive() {
        int[] arr = new int[10];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                arr[j] = rd.nextInt(10);// אתם צריכים לקלוט מספרים אני עושה רנדום
            }
            System.out.println(Arrays.toString(arr));
            shift(arr);
            System.out.println(Arrays.toString(arr));
        }
    }

    //Q12
    static public class Course {
        private int code;
        private double grade;
        private int type;

        public Course(int code, double grade, int type) {
            this.code = code;
            this.grade = grade;
            this.type = type;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }

    //Q12
    public static Student[] studentsByDep(Student[] arr, int dep) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDep() == dep)
                count++;
        }
        Student[] temp = new Student[count];
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getDep() == dep)
                temp[count++] = arr[i];
        }
        return temp;
    }
}