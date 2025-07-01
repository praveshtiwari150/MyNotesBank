import java.util.*;

public class arrayListPractice {
    public static void main(String[] args) {

    // decleration
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(47, 92, 15, 63, 7, 81, 29, 53, 3, 74));
        ArrayList<Integer> clonedNumsUsingCollection = new ArrayList<>(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            clonedNumsUsingCollection.add(null);
        }
        ArrayList<String> clonedColorsUsingAddAll = new ArrayList<>();

    // insertion
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add(0, "Orange");

    // cloning
        Collections.copy(clonedNumsUsingCollection, nums);
        clonedColorsUsingAddAll.addAll(colors);
        ArrayList<String> newc1 = (ArrayList<String>)colors.clone();
        System.out.println("Cloned array list: " + newc1);       

    // updation
        colors.set(2, "Purple");

    // sorting
        Collections.sort(nums);

    // shuffling
        Collections.shuffle(colors);

    // reversing
        Collections.reverse(colors);

    // sublist
    ArrayList<Integer> partialNums = new ArrayList<>(nums.subList(2,5));
    System.out.println("Sublist from index 2 to 4 : " + partialNums);

    // comparing two arrays
    ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
    ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));

    boolean res = list1.equals(list2);
    System.out.println("Are both lists equal? " + res);

    // joining two arrays
    list1.addAll(list2);
    System.out.println("Joining arrays using addAll : " + list1);

    //removing all elements
    newc1.removeAll(newc1);
    System.out.println("Array list after remove all elements "+ newc1);

    // triming (making capacity of an array list the current list size)
    clonedNumsUsingCollection.trimToSize();
    System.out.println("clonedNumsUsingCollection after trimming: " + clonedNumsUsingCollection);

    // checking if list is empty or not
    if(newc1.isEmpty()){
        System.out.println("newc1 is empty");
    }

    // iteration and retriving

        // 1) using simple for loop
        for (int i = 0; i < colors.size(); i++) {
            System.out.print(colors.get(i) + "\t");
        }
        System.out.println();

        // 2) using special for loop
        for (String color : colors) {
            System.out.print(color);
        }
        System.out.println();

        // 3) using Iterator Class
        Iterator<String> it = colors.iterator();
        while (it.hasNext()) {
            String color = it.next();
            System.out.print(color + "\t");
        }
        System.out.println();

        // 4) retrieving element at a specified index
        System.out.println(nums);
        System.out.println("clonedColorsUsingAddAll : " + clonedColorsUsingAddAll);
        System.out.println("clonedNumsUsingCollection : " + clonedNumsUsingCollection);
        System.out.println("Color at index 3: " + colors.get(3));
        System.out.println("Color at index 1: " + colors.get(1));
        System.out.println("Color at index 4: " + colors.get(4));

    // searching
        System.out.println(colors.contains("Red"));

    // increasing capacity
    ArrayList<String> fruits = new ArrayList<>(3);
    fruits.add("Mango");
    fruits.add("Orange");
    fruits.add("Apple");

    System.out.println(fruits);

    fruits.ensureCapacity(6);
    fruits.add("Peach");
    fruits.add("Pomogranet");
    fruits.add("Custord Apple");

    System.out.println(fruits);




    }
}
