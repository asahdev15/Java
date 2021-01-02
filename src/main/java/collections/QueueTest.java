package collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList();
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        System.out.println(q + " : " +q.size());
        System.out.println(q.poll());
        System.out.println(q + " : " +q.size());
        System.out.println(q.peek());
        System.out.println(q + " : " +q.size());


//        System.out.println("prority queue");
//        Queue<Integer> qp = new PriorityQueue<Integer>();
//        qp.add(15);
//        qp.add(11);
//        qp.add(10);
//        qp.add(14);
//        System.out.println(qp.poll());
//        System.out.println(qp.poll());
//
//        System.out.println("prority queue for students");
//        Queue<Student> pStudends = new PriorityQueue<Student>();
//        pStudends.add(new Student("Hussein", 27));
//        pStudends.add(new Student("Jena", 2));
//        pStudends.add(new Student("Laya", 1));
//        System.out.println(pStudends.poll().name);
    }

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

}