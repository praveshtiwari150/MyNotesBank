import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		String str = "succccess";
		int n = str.length();
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++){
		    char ch = str.charAt(i);
		    map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		int firstMax = 0, secondMax = 0;
		char firstChar = ' ', secondChar = ' ';
		
		for(Map.Entry<Character, Integer> entry: map.entrySet()){
		    int freq = entry.getValue();
		    char ch = entry.getKey();
		    
		    if(freq > firstMax){
		        secondMax = firstMax;
		        secondChar = firstChar;
		        firstMax = freq;
		        firstChar = ch;
		    }
		    
		    else if(freq > secondMax && freq < firstMax){
		        secondMax = freq;
		        secondChar = ch;
		    }
		}
		
		System.out.println("Second most frequent character is: " + secondChar + " and its frequency is " + secondMax);
	}
}
