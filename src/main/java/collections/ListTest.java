package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();//creating arraylist
        list.add("Ravi");//adding object in arraylist
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");
        list.remove("Ravi");
        list.remove(0);
        System.out.println("ArrayList:");
        list.stream().forEach(i->System.out.print(i+"->"));
        System.out.println("\n---------------");
        list = new LinkedList<String>();//creating linkedlist
        list.add("James");//adding object in linkedlist
        list.add("Serena");
        list.add("Swati");
        list.add("Junaid");
        System.out.println("LinkedList:");
        list.stream().forEach(i->System.out.print(i+"->"));

    }
}
