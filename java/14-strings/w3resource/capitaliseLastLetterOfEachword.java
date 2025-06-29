import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main(String[] args) throws java.lang.Exception
    {
        // your code goes here
        String s = "Happy is a henry likes beasn butter bread";
        int n = s.length();

        StringBuilder result = new StringBuilder();
        String[] words = s.split("\\s+");

        for (String word: words) {
            if (word.length() > 1) {
                String substr = word.substring(0, word.length() - 1);
                char lastChar = Character.toUpperCase(word.charAt(word.length() - 1));
                result.append(substr).append(lastChar).append(" ");
            }
            
            else{
                result.append(word.toUpperCase()).append(" ");
            }
        }
        
        System.out.println(result.toString().trim());

    }
}
