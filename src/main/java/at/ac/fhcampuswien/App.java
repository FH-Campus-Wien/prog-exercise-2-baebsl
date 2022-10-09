package at.ac.fhcampuswien;

import sun.tools.jstat.Jstat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;


public class App {

    //todo Task 1
    public void largestNumber(){
        // input your solution here
        Scanner scanner = new Scanner(System.in);
        double biggestNum = 0d;

        for(int i = 1;; i++) {
            System.out.printf("Number " + i + ": "); //format string
            double num1 = scanner.nextDouble();
            if (num1 <=0 && i == 1) {
                System.out.println("No number entered.");
                return;
            }
            else if (num1 <=0) {
                System.out.println("The largest number is " + String.format("%.2f", biggestNum));
                return;
            }
            else if (num1 > biggestNum) {
                biggestNum = num1;
            }
        }
    }

    //todo Task 2
    public void stairs(){
        // input your solution here
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int totalLines = scanner.nextInt();
        int counter = 1;

        if (totalLines <=0) {
            System.out.println("Invalid number!");
        }
        else {
            for (int line = 1; line <= totalLines; line++){
                for (int row = 1; row <= line; row++ ){
                    System.out.print(counter + " ");
                    counter++;
                }
                System.out.println("");
            }
        }
    }

    //todo Task 3
    public void printPyramid(){
        // input your solution here
        final int lines = 6;

        for (int line = 1; line <= lines; line++) {
            for (int spaces = lines - line - 1; spaces >= 0; spaces-- ) {
                System.out.print(" ");
            }
            for (int stars = 1; stars <= line * 2 - 1; stars++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //todo Task 4
    public void printRhombus(){
        // input your solution here
        Scanner scanner = new Scanner(System.in);
        System.out.print("h: ");
        int height = scanner.nextInt();
        System.out.print("c: ");
        char character = scanner.next().charAt(0); // next gibt String zurück & mit charAt(0) holt man 1. Zeichen
        int pyramidHeight = ((height-1)/2);

        if (height % 2 == 0) {
            System.out.println("Invalid number!");
        }
        else {
            //oberer Teil des Rhombus
            for (int line = 1; line <= pyramidHeight; line++) {
                int numSpaces = pyramidHeight - line + 1;
                for (int spaces = 1; spaces <= numSpaces; spaces++ ) {
                    System.out.print(" ");
                }
                int totalchars = line*2-1;
                for (int chars = (totalchars - 1) / 2; chars >= 0; chars--) {
                    System.out.print((char)(character - chars));
                }
                for (int chars = 1; chars <= (totalchars - 1) / 2; chars++) {
                    System.out.print((char)(character - chars));
                }
                System.out.println();
            }
            //Mitte des Rhombus
            for (int chars = (height - 1) / 2; chars >= 0; chars--) {
                System.out.print((char)(character - chars));
            }
            for (int chars = 1; chars <= (height - 1) / 2; chars++) {
                System.out.print((char)(character - chars));
            }
            System.out.println();

            //unterer Teil des Rhombus
            for (int line = 1; line <= pyramidHeight; line++) {
                int numSpaces = line;
                for (int spaces = 1; spaces <= numSpaces; spaces++ ) {
                    System.out.print(" ");
                }
                int totalchars = height - 2 * line;
                for (int chars = (totalchars - 1) / 2; chars >= 0; chars--) {
                    System.out.print((char)(character - chars));
                }
                for (int chars = 1; chars <= (totalchars - 1) / 2; chars++) {
                    System.out.print((char)(character - chars));
                }
                System.out.println();
            }
        }
    }

    //todo Task 5
    public void marks(){
        // input your solution here
        Scanner scanner = new Scanner(System.in);
        List<Integer> grades = new ArrayList<Integer>();

        for(int i = 1;; i++) {
            System.out.printf("Mark " + i + ": "); //format string
            int mark = scanner.nextInt();
            if (mark == 0) {
                int sum = 0;
                int negativeCount = 0;
                float average;

                for (int enteredGrade = 0; enteredGrade < grades.size(); enteredGrade++){
                    sum = sum + grades.get(enteredGrade);
                    if (grades.get(enteredGrade) == 5) {
                        negativeCount++;
                    }
                }
                if (grades.size() > 0) {
                    average = (float)sum/grades.size();
                }
                else {
                    average = 0;
                }
                System.out.println("Average: " +  String.format("%.2f", average));
                System.out.println("Negative marks: " + negativeCount);
                return;
            }
            else if (mark < 1 || mark > 5) {
                System.out.println("Invalid mark!");
                i--;
            }
            else {
                grades.add(mark);
            }
        }
    }

    //todo Task 6
    public void happyNumbers(){
        // input your solution here
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int num = scanner.nextInt();

        while (num != 4 && num != 1) {
            char[] digits = String.valueOf(num).toCharArray();
            int sum = 0;
            for (int i = 0; i < digits.length; i++){
                int digit = Character.getNumericValue(digits[i]);

                sum += Math.pow(digit, 2); //Hochzahl
            }
            num = sum;
        }
        if (num == 1) {
            System.out.println("Happy number!");
        }
        else {
            System.out.println("Sad number!");
        }
    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}