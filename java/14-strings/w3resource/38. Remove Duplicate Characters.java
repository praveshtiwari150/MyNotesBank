import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		
		String s = "w3resources";
		int n = s.length();
		
		StringBuilder ans = new StringBuilder();
		
		for(int i=0; i<n; i++){
		    char ch = s.charAt(i);
		    set.add(ch);
		}
		
		for(Character ch:set){
		    ans.append(ch);
		}
		
		System.out.println(ans.toString());

	}
}
