/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;
/**
 *
 * @author chesire
 */
public class ElementSearch {
    
    public static int notInArray(int array[]){
//        Length of array to be tested, + 1 to get actual size since one number is missing
        int arrayLength = array.length + 1;
//        Find the sum of the integers from 1 to n + 1(arrayLength + 1)
        int sum_of_expected_array = arrayLength * (arrayLength + 1) / 2;
//        Sum of the given array
        int sum_of_array = Arrays.stream(array).sum();
//        Missing integer is the sum of expected array minus sum of array
        return sum_of_expected_array - sum_of_array;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Enter your arrays here
        int testArray[] = new int[]{3,5,4,1};
        System.out.println("Missing Integer:"+ notInArray(testArray));
    }
    
}
