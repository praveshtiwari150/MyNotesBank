import java.util.*;

public class main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list + "->" + list.size());

        // add
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list + "->" + list.size());

        // insert at any pos
        list.add(1, 1000);
        System.out.println(list + "->" + list.size());

        // access a specific index val
        int val = list.get(1);
        System.out.println(val);

        // update val at a specific index
        list.set(1, 2000);
        System.out.println(list + "->" + list.size());

        // remove val from a specific index
        list.remove(1);
        System.out.println(list + "->" + list.size());

        ArrayList<String> strArr = new ArrayList<>();
        strArr.add("Hello");
        strArr.add("Bunny");
        strArr.add("Nayeon");
        System.out.println(strArr + "->" + strArr.size());

        for (int i = 0; i < strArr.size(); i++) {
            System.out.println(strArr.get(i));
        }
        System.out.println();
        for (String ele : strArr) {
            System.out.println(ele);
        }
    }
}