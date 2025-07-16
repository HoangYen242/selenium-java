package org.example;

import tvn.day1.Fraction;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //16 28 -16 -4 -13 11 28 8 10 21 4 30 -7 -14
        int[] numbers = {16, 28, -16, -4, -13, 11, 28, 8, 10, 21, 4, 30, -7, -18};

        int max = numbers[0];
        int maxIndex = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex);

        int min = numbers[0];
        int minIndex = 0;

        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] < min){
                min = numbers[i];
                minIndex = i;
            }
        }
        System.out.println(min);
        System.out.println(minIndex);
    }
}