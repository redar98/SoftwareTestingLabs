package com.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter your age: ");

        int age = reader.nextInt();

        if (age < 15){
            System.out.println("You can not work at this age!");
        } else if (age >= 15 && age < 16){
            System.out.println("You can work at most 5 hours a day only with accordance of your parents!");
        } else if (age >= 16 && age < 18){
            System.out.println("You are eligible to work at most 7 hours a day!");
        }
    }
}
