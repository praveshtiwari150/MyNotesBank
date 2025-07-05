import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
        LinkedList<String> list = new LinkedList<>();
        
        list.add("Red");
        list.add("Green");
        list.add("Black");
        list.add("White");
        list.add("Pink");
        list.add("Yellow");
        
        System.out.println(list);
        
        for(String color : list){
            System.out.println(color);
        }
        
        list.add(2, "Purple");
        // iterate from specified position
        Iterator p = list.listIterator(3);
        
        while(p.hasNext()){
            System.out.println(p.next());
        }
        
        Iterator it = list.descendingIterator();
        
        System.out.println("Element in reverse order.");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
        list.addFirst("White");
        list.addLast("Pink");
        System.out.println(list);
        
        // insert some elements at specified position
        LinkedList<String> temp = new LinkedList<>();
        temp.add("Maroon");
        temp.add("Pink");
        
        list.addAll(3, temp);
        
        System.out.println(list);
        
        int firstPink = list.indexOf("Pink");
        int lastPink = list.lastIndexOf("Pink");
        System.out.println("First Occurence " + firstPink + " last Cccurence " + lastPink);
        
        for(int i=0; i<list.size(); i++){
            System.out.println("Element at index " + i + ": " + list.get(i));
        }
        
        list.remove(2);
        list.removeFirst();
        list.removeLast();
        temp.clear();
        System.out.println( temp);
        System.out.println("Before Swap");
        System.out.println(list);
        Collections.swap(list, 3,5);
        System.out.println("After Swap");
        System.out.println(list);
        
        List<String> temp2 = new LinkedList<>();
        // Clone the list
        List<String> temp3 = (LinkedList<String>) ((LinkedList<String>) list).clone();
        temp2.addAll(list);
        
        Collections.shuffle(temp2);
        System.out.println(temp2);
        
        //  Remove and Return First
        System.out.println("Removed element: " + list.pop());
        System.out.println(list);
        
        // Peek First Element
        System.out.println("Peek element: " + list.peek());
        
        List<String> arrlist = new ArrayList<String>(list);
        
        System.out.println(arrlist);
        
        
        // comparison of 2 linked list
        LinkedList<Boolean> check = new LinkedList<>();
        
        for(String e : list){
            check.add(temp3.contains(e) ? true : false);
        }
        
        System.out.println(check);
        
        // LIST empty or not
        System.out.println(temp.isEmpty() ? "List is empty" : "List is not empty");
        
        // Replacing 2nd element with new value
        list.set(1,  "Orange");
        System.out.println(list);
        
	}
}
