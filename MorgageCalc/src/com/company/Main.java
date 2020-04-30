package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte PERCENTAGE = 100;
        final byte MONTHS_IN_YEAR = 12;
        int principal = 0;
        float monthlyRate = 0;
        int noOfPayment = 0;

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Principle ($1k - $1M) : ");
            principal = scan.nextInt();
            if (principal >= 1_000 && principal <= 1_000_000)
                break;
                System.out.println("Please enter amount between 1,000 and 1,000,000.");
        }

        while (true) {
            System.out.println("Annual Interest Rate : ");
            float annualRate = scan.nextFloat();
            if (annualRate >=1 && annualRate <=30){
                monthlyRate = annualRate / PERCENTAGE / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Please enter rate between 1 and 30.");
        }

        while (true) {
            System.out.println("Period : ");
            byte period = scan.nextByte();
            if (period >= 1 && period <= 30) {
                noOfPayment = period * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Please enter year/s between 1 and 30.");
        }

        double mortgage = principal * (monthlyRate * Math.pow(1 + monthlyRate, noOfPayment)) /
                (Math.pow(1 + monthlyRate, noOfPayment) - 1);

        String mortgageFormat = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println(mortgageFormat);


    }
}
