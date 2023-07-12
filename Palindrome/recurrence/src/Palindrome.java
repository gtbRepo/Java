// Program-gra do zgadywania czy dana fraza to palindrom

/*
st.replaceAll("\\s+","") removes all whitespaces and non-visible characters (e.g., tab, \n).

st.replaceAll("\\s+","") and st.replaceAll("\\s","") produce the same result.

The second regex is 20% faster than the first one, but as the number consecutive spaces increases,
the first one performs better than the second one.

Assign the value to a variable, if not used directly:

st = st.replaceAll("\\s+","")

*/

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println("This program can check if word is a palindrome.");
        System.out.println("Write word you want to check: \n(be sure to use only lower case letters)");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine().toString().toLowerCase().replaceAll("\\s+", "").trim();
        char wordArray[] = word.toCharArray();
        final int addressInTableOfTheFirstChar = 0;
        int addressInTableOfTheLastChar = wordArray.length-1;
        if(palindrome.isItPalindrome(wordArray, addressInTableOfTheFirstChar,
                addressInTableOfTheLastChar) == true){
            System.out.print("True");
        } else {
            System.out.println("False");
        }
    }
    public boolean isItPalindrome(char wordArray[], int firstChar, int lastChar){
        if(lastChar <= firstChar){
            return true;
        } else if(wordArray[firstChar] != wordArray[lastChar]){
            return false;
        } else {
            return isItPalindrome(wordArray, firstChar + 1, lastChar - 1);
        }
    }
}