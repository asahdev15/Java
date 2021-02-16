package collections;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {
        priorityQueue();
    }

    private static void linkedListQueue(){
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
    }

    private static void priorityQueue(){
        System.out.println("prority queue for ints with natural ordering");
//        Queue<Integer> qp = new PriorityQueue<Integer>(); // increasing order -> min heap
        Queue<Integer> qp = new PriorityQueue<Integer>((a,b)->(b-a)); // decreasing order -> max heap
        qp.offer(15);
        qp.offer(11);
        qp.offer(10);
        qp.offer(14);
        System.out.println(qp);
        while(!qp.isEmpty()){
            System.out.println(qp.poll());
        }


//        System.out.println("\nprority queue for students with default comparable ordering - age");
//        Queue<Student> q2 = new PriorityQueue<Student>();
//        q2.add(new Student("A", 1));
//        q2.add(new Student("C", 3));
//        q2.add(new Student("B", 2));
//        q2.add(new Student("B", 22));
//        System.out.println(q2.toString());
//        while(!q2.isEmpty()){
//            System.out.println(q2.poll());
//        }
//
//
//        System.out.println("\nprority queue for students with comparator ordering - name");
//        Comparator<Student> idComparator = new Comparator<Student>(){
//            @Override
//            public int compare(Student c1, Student c2) {
//                return -c1.name.compareTo(c2.name);
//            }
//        };
//        Queue<Student> q3 = new PriorityQueue<Student>(idComparator);
//        q3.add(new Student("A", 1));
//        q3.add(new Student("C", 3));
//        q3.add(new Student("B", 2));
//        q3.add(new Student("B", 22));
//        System.out.println(q3.toString());
//        while(!q3.isEmpty()){
//            System.out.println(q3.poll());
//        }

    }



}

