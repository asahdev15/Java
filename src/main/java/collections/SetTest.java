package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

// Collection contains Unique Elements - i.e No Duplicate Elements

public class SetTest {

    static class NodeS implements Comparable<NodeS> {
        int cost;
        NodeS next;

        public NodeS(int cost, NodeS next) {
            this.cost = cost;
            this.next = next;
        }

        @Override
        public int compareTo(NodeS o) {
            if (this.cost > o.cost)
                return 1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return "NodeS{" +
                    "cost=" + cost +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("---------- hash set");
        Set<String> set = new HashSet<String>();
        set.add("Ravi");
        set.add("Vijay");
        set.add("Ravi");
        set.add("Ajay");
        set.forEach(item -> System.out.println(item));

        System.out.println("---------- linked hash set");
        set = new LinkedHashSet<String>();
        set.add("Bavi");
        set.add("Cijay");
        set.add("Bavi");
        set.add("Ajay");
        set.forEach(item -> System.out.println(item));

        System.out.println("---------- Tree set");
        set = new TreeSet<String>();
        set.add("Ravi");
        set.add("Vijay");
        set.add("Ravi");
        set.add("Ajay");
        set.forEach(item -> System.out.println(item));

        // object
        System.out.println("*************** object");
        TreeSet<NodeS> s = new TreeSet<NodeS>();
        s.add(new NodeS(61, null));
        s.add(new NodeS(3, null));
        s.add(new NodeS(6, null));
        s.add(new NodeS(4, null));
        s.forEach(item -> System.out.println(item));

    }
}
