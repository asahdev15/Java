package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {

    public static void main(String[] args) {
        circularArrayList();
    }

    private static void arrayList(){
        List<String> list = new ArrayList<String>();//creating arraylist
        list.add("1");//adding object in arraylist
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list.toString());
        list.remove("4");
        list.remove(0);
        System.out.println(list.toString());
    }

    private static void linkedList(){
        List<String> list = new LinkedList<String>();//creating linkedlist
        list.add("1");//adding object in linkedlist
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list.toString());
    }

    private static void copyOnWriteArrayList(){

        // this causes ConcurrentModificationException to be thrown
        // once the iterator is created, if the ArrayList is modified, it throws ConcurrentModificationException

        List<String> list = new ArrayList<>();

        // this causes ConcurrentModificationException NOT to be thrown
        // This is a thread-safe variant of java.util.ArrayList
        // in which all mutative operations (add, set, and so on) are implemented
        // by making a fresh copy of the underlying array

//        List<String> list = new CopyOnWriteArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator<String> it = list.iterator();
        //manipulate list while iterating
        while(it.hasNext()){
            System.out.println("list is:"+list);
            String str = it.next(); // throws ConcurrentModificationException
            System.out.println("Fetched : "+str);
            if(str.equals("2"))list.remove("5"); // this will cause modCount to change
            if(str.equals("3"))list.add("3 found"); // this will cause modCount to change
            if(str.equals("4")) list.set(1, "4"); // this will NOT cause modCount to change
        }

        // modCount is the ArrayList variable that holds the modification count
        // and every time we use add, remove or trimToSize method, it increments.
        // expectedModCount is the iterator variable that is initialized when we create iterator with same value as modCount.
        // This explains why we don’t get exception if we use set method to replace any existing element




    }


    private static void circularArrayList(){
        List<String> items = new CircularArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");
        items.add("F");
        System.out.println(items.toString());
        for(int i = 12; i<=17 ; i++){
            System.out.println(items.get(i));
        }

    }

    /*
     A  B  C  D  E  F
     0  1  2  3  4  5
     6  7  8  9 10 11
    12 13 14 15 16 17
    ....
     */
    static class CircularArrayList<E> extends ArrayList<E>
    {
        private static final long serialVersionUID = 1L;

        public E get(int index)
        {
            return super.get(index % size());
        }
    }


}
