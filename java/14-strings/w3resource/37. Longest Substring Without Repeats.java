import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		String s = "pickoutthelongestsubstring";
		int n = s.length();
		
		boolean[] set = new boolean[256];
		int maxLen = 0;
		
		int i=0;
		int j=-1;
		
		while(i<n){
		    char ch = s.charAt(i);
		    
		    while(set[ch]){
		        j++;
		        set[s.charAt(j)] = false;
		    }
		    
		    set[ch] = true;
		    
		    int currLen = i - j;
		    if(currLen > maxLen){
		        maxLen = currLen;
		    }
		    i++;
		}
		
		System.out.println(maxLen);

	}
}
