import java.util.Scanner;

public class GpaCalculator {

    static String[] courseList;
    static int[] creditHourList;
    static int arrayLength = 1;
    static double[] scoreList;
    static String[] gradeList;
    static double[] gradeScoreList;
    static double[] calculatedGradeList;
    static Scanner scan = new Scanner(System.in);
    static int totalCreditHour = 0;
    static double totalCalculatedGrade = 0;
    static double gpa = 0;


    public static void main(String[] args) {
        System.out.println("Please Enter name?");
        String studentName = scan.nextLine();

        addCourse();
        addCreditHr();
        addScore();
        gradeScore();
        gradeCalculator();
        gpa(totalCreditHour,totalCalculatedGrade);
        viewGrades(studentName,totalCreditHour,totalCalculatedGrade,gpa);
    }

    public static void addCourse() {
        System.out.println("Please insert number of courses?");
        arrayLength = scan.nextInt();
        courseList = new String[arrayLength];
        for (int i = 0; i < arrayLength; i++){
            System.out.println("Please enter course name?(in one word)");
            String courseName = scan.next();
            courseList[i] = courseName;
        }
    }

    public static void addCreditHr() {
        creditHourList = new int[courseList.length];
        for (int i = 0; i < arrayLength; i++) {
            System.out.println("Please insert credit hours for " + courseList[i]);
            int creditHour = scan.nextInt();
            creditHourList[i] = creditHour;
            totalCreditHour += creditHourList[i];
        }
    }

    public static void addScore() {
        scoreList = new double[arrayLength];
        for (int i = 0; i < scoreList.length; i++){
            System.out.println("insert score in " + courseList[i]);
            double score = scan.nextDouble();
            scoreList[i] = score;
        }
        System.out.println("Successfully entered required information!");
    }

    public static void gradeScore() {
        gradeList = new String[arrayLength];
        gradeScoreList = new double[arrayLength];
        for (int i = 0;i < scoreList.length;i++) {
            if (scoreList[i] < 100 && scoreList[i] >= 90) {
                gradeList[i] = "A+";
                gradeScoreList[i] = 4;
            } else if (scoreList[i] < 90 && scoreList[i] >= 85) {
                gradeList[i] = "A";
                gradeScoreList[i] = 4;
            } else if (scoreList[i] < 85 && scoreList[i] >= 80) {
                gradeList[i] = "A-";
                gradeScoreList[i] = 3.75;
            } else if (scoreList[i] < 80 && scoreList[i] >= 75) {
                gradeList[i] = "B+";
                gradeScoreList[i] = 3.5;
            } else if (scoreList[i] < 75 && scoreList[i] >= 70) {
                gradeList[i] = "B";
                gradeScoreList[i] = 3;
            } else if (scoreList[i] < 70 && scoreList[i] >= 65) {
                gradeList[i] = "B-";
                gradeScoreList[i] = 2.75;
            } else if (scoreList[i] < 65 && scoreList[i] >= 60) {
                gradeList[i] = "C+";
                gradeScoreList[i] = 2.5;
            } else if (scoreList[i] < 60 && scoreList[i] >= 55) {
                gradeList[i] = "C";
                gradeScoreList[i] = 2;
            } else if (scoreList[i] < 55 && scoreList[i] >= 50) {
                gradeList[i] = "C-";
                gradeScoreList[i] = 1.75;
            } else if (scoreList[i] < 50 && scoreList[i] >= 35) {
                gradeList[i] = "D";
                gradeScoreList[i] = 1;
            } else if (scoreList[i] < 35) {
                gradeList[i] = "F";
                gradeScoreList[i] = 0;
            }
        }
    }

    public static void gradeCalculator() {
        calculatedGradeList = new double[arrayLength];
        for (int i = 0; i < scoreList.length;i++) {
            double calculatedGrade = creditHourList[i] * gradeScoreList[i];
            calculatedGradeList[i] = calculatedGrade;
            totalCalculatedGrade += calculatedGrade;
        }
    }

    public static void gpa(int totalCreditHour,double totalCalculatedGrade) {
        gpa = totalCalculatedGrade / totalCreditHour;
    }
    public static void viewGrades(String studentName,int totalCreditHour,double totalCalculatedGrade,double gpa) {
        System.out.println("GRADE REPORT");
        System.out.println("NAME " + studentName);
        System.out.println("Number of courses is " + courseList.length);
        System.out.println("________________________________________________");
        System.out.println("Courses    Grade    CreditHr    value*CreditHr");
        System.out.println("________________________________________________");
        for (int i = 0; i < courseList.length; i++){
            String[] shortCourseList = new String[arrayLength];
            if (courseList[i].length() < 10){
                int fill = 10 - courseList[i].length();
                shortCourseList[i] = courseList[i] + " ".repeat(fill);
            }else
                shortCourseList[i] = courseList[i];
            System.out.println(shortCourseList[i].substring(0,10) + "\t" + gradeList[i] + "\t\t" + "\t" + creditHourList[i] + "\t\t\t" + calculatedGradeList[i]);
        }
        System.out.println("________________________________________________");
        System.out.println("Total Credit hour = "+ totalCreditHour + " Total grade point = " + totalCalculatedGrade);
        System.out.println("________________________________________________");
        System.out.println("Your GPA is " + "= " + gpa);
        System.out.println("________________________________________________");

    }
}
