package collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {

    static private class Student implements Comparable<Student> {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Student o) {
            if (this.age == o.age)
                return 0;
            else if (this.age > o.age)
                return 1;
            else
                return -1;
        }

    }

    public static void main(String[] args) {
        System.out.println("basic queue");
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(15);
        q.add(11);
        q.add(10);
        q.add(14);
        System.out.println(q.poll());

        System.out.println("prority queue");
        PriorityQueue<Integer> qp = new PriorityQueue<Integer>();
        qp.add(15);
        qp.add(11);
        qp.add(10);
        qp.add(14);
        System.out.println(qp.poll());
        System.out.println(qp.poll());

        System.out.println("prority queue for students");
        PriorityQueue<Student> pStudends = new PriorityQueue<Student>();
        pStudends.add(new Student("Hussein", 27));
        pStudends.add(new Student("Jena", 2));
        pStudends.add(new Student("Laya", 1));
        System.out.println(pStudends.poll().name);
    }

}