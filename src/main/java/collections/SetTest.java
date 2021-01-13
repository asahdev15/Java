package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

    public static void main(String[] args) {
        hashSetTest();
        linkedHashSetTest();
        treeSetTest();
        treeSetObjectTest();
    }

    private static void addElementsSet(Set<String> set){
        set.add("4");
        set.add("2");
        set.add("3");
        set.add("1");
        set.add("4");
        set.add("1");
    }

    private static void hashSetTest(){
        System.out.println("\n-- hash set");
        Set<String> set = new HashSet<String>();
        addElementsSet(set);
        System.out.println(set.toString());
        System.out.println(set.contains("2"));
        System.out.println(set.contains("200"));
        System.out.println(set.remove("2"));
        System.out.println(set.toString());
    }

    private static void linkedHashSetTest(){
        System.out.println("\n-- linked hash set");
        Set<String> set = new LinkedHashSet<String>();
        addElementsSet(set);
        System.out.println(set.toString());
    }

    private static void treeSetTest(){
        System.out.println("\n-- Tree set");
        Set<String> set = new TreeSet<String>();
        addElementsSet(set);
        System.out.println(set.toString());
    }

    private static void treeSetObjectTest(){
        System.out.println("\n-- Tree set Object");
        Set<NodeS> set = new TreeSet<NodeS>();
        set.add(new NodeS(61, null));
        set.add(new NodeS(3, null));
        set.add(new NodeS(6, null));
        set.add(new NodeS(4, null));
        System.out.println(set.toString());
    }

    static class NodeS implements Comparable<NodeS> {
        int cost;
        NodeS next;

        public NodeS(int cost, NodeS next) {
            this.cost = cost;
            this.next = next;
        }

        @Override
        public int compareTo(NodeS o) {
            // ASC
//            return (this.cost - o.cost);
            // DESC
            return -(this.cost - o.cost);
        }

        @Override
        public String toString() {
            return "NodeS{" + "cost=" + cost + ", next=" + next + '}';
        }

    }

}
