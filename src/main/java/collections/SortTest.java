package collections;

import java.util.*;

public class SortTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Map<String, String> keys = new HashMap<>();
        list.add("E");
        list.add("D");
        list.add("B");
        list.add("A");
        list.forEach(item -> System.out.println(item));
        Collections.sort(list);
        System.out.println("---- Sorting ");
        list.forEach(item -> System.out.println(item));

        List<Person> listPersons = new ArrayList<Person>();
        listPersons.add(new Person("C", 30));
        listPersons.add(new Person("B", 20));
        listPersons.add(new Person("A", 10));
        listPersons.forEach(item -> System.out.println(item));
        Collections.sort(listPersons);
        System.out.println("---- Sorting ");
        listPersons.forEach(item -> System.out.println(item));

    }

    static private class Person implements Comparable<Person> {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Person check) {
            System.out.println("---- Compare : Starts");
            System.out.println("this : " + this.name + "-" + this.age);
            System.out.println("check : " + check.name + "-" + check.age);
            System.out.println("---- Compare : Ends");
            return (this.age - check.age);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
