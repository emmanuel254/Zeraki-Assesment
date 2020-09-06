/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulatestrings;

/**
 *
 * @author chesire
 */
public class ManipulateStrings {
    
    public static String reverseString(String cut_string){
//       Using getBytes method to convert this cut_string
        byte[] cutStringArray = cut_string.getBytes();
        byte[] new_result = new byte[cutStringArray.length];

//       Storing the cut_string in the reverse order into the new_result
        for(int j = 0; j < cutStringArray.length; j++){
            new_result[j] = cutStringArray[cutStringArray.length - j - 1];
        }
        
        return new String(new_result);
    }
    
    public static String groupStrings(String S){
        int message_length = S.length();
        System.out.println("Message Length: "+message_length);
        
        int sum = 0;
        int temp = 0;
        int groups_of = 4;
        String result = "";
        
        for(int i = 1; i <= message_length; i++){
            
            if(i != 0 && i % groups_of == 0){
//                Temp is used to mark the start of where the string is to be cut
                temp = sum;
//                Sum is used to mark the end of where the string is to be cut
                sum = sum + groups_of;
//                Cut the string starting at temp and ending at sum
                String cut_string = S.substring(temp, sum);
                
//                Calling the reverseString function to reverse the substring and store the result in result String
                result = result+ManipulateStrings.reverseString(cut_string);
            }
        }
        
//        To get last remaining characters in string length is not a multiple of 4     
        int modulus = S.length() % groups_of;
        
//        Use the modulus result to get last remaining characters and reverse them
        if(modulus >= 1){
            String cut_strings = S.substring(sum, S.length());
            result = result + ManipulateStrings.reverseString(cut_strings);
        }
        
//        Return divided and reversed string
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Input the strings to be tested here
        String testString = " Tempor ip";
        
        System.out.println("Entered String:"+ testString);
//        Call groupStrings to get the desired output
        System.out.println("Grouped, Reversed String:"+groupStrings(testString));
    }
    
}
