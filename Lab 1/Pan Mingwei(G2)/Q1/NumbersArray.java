/*
 * Name:Pan Mingwei
 * Email ID:mingwei.pan.2022
 */

import java.util.*;

public class NumbersArray {
    public static void main(String[] args) {
        Integer[] input = { 1, 2, 3, 4, 1, 5 };

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));

        System.out.println();

        input = new Integer[] { 1, 2, 3, 4, 1, 2, 5, 3 };

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));
    }

    public static int findMax(Integer[] input) {
        int max = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] > max) {
                max = input[i];
            }
        }
        return max;
    }

    public static int[] findDuplicates(Integer[] input) {
        int[] duplicates = new int[input.length];
        int size = 0;
        // sort the array
        Arrays.sort(input);
        for (int i = 0; i < input.length - 1; i++) {
            if (size == 0 && input[i] == input[i + 1]) {
                duplicates[size] = input[i];
                size++;
            } else {
                // if the current element is the same the next element
                // and have not been added in the duplicates array
                if (input[i] == input[i + 1] && input[i] != duplicates[size - 1]) {
                    duplicates[size] = input[i];
                    size++;
                }
            }
        }
        // resize the array
        int[] duplicates_resized = new int[size];
        for (int i = 0; i < size; i++) {
            duplicates_resized[i] = duplicates[i];
        }
        return duplicates_resized;
    }

    public static int[] findUnique(Integer[] input) {
        int[] unique = new int[input.length];
        int size = 0;
        // sort the array
        Arrays.sort(input);
        //check for first element;
        if (input[0] != input[1]) {
            unique[0] = input[0];
            size++;
        }
        for (int i = 1; i < input.length - 1; i++) {
            if (input[i] != input[i - 1] && input[i] != input[i + 1]) {
                unique[size] = input[i];
                size++;
            }
        }
        //check for last element;
        if (input[input.length - 1] != input[input.length - 2]) {
            unique[size] = input[input.length - 1];
            size++;
        }
        // resize the array
        int[] unique_resized = new int[size];
        for (int i = 0; i < size; i++) {
            unique_resized[i] = unique[i];
        }
        return unique_resized;
    }
}