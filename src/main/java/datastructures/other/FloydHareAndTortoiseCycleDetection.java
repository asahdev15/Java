package datastructures.algorithms;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

// Cycle Detection in LL
// Cycle Length in LL
// Cycle Start Node in LL
// Middle Node in LL
// Is LL palindrome or not
// re-order LL
// Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
// Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null

public class FloydHareAndTortoiseCycleDetection {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + FloydHareAndTortoiseCycleDetection.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + FloydHareAndTortoiseCycleDetection.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + FloydHareAndTortoiseCycleDetection.hasCycle(head));
    }

    public static void reorder(ListNode head) {
        if (head == null || head.next == null)
            return;

        // find the middle of the LinkedList
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is now pointing to the middle node
        ListNode headSecondHalf = reverse(slow); // reverse the second half
        ListNode headFirstHalf = head;

        // rearrange to produce the LinkedList in the required order
        while (headFirstHalf != null && headSecondHalf != null) {
            ListNode temp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = temp;

            temp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = temp;
        }

        // set the next of the last node to 'null'
        if (headFirstHalf != null)
            headFirstHalf.next = null;
    }

    public static void palindromreTest(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + FloydHareAndTortoiseCycleDetection.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + FloydHareAndTortoiseCycleDetection.isPalindrome(head));
    }


    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // find middle of the LinkedList
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow); // reverse the second half
        ListNode copyHeadSecondHalf = headSecondHalf; // store the head of reversed part to revert back later

        // compare the first and the second half
        while (head != null && headSecondHalf != null) {
            if (head.value != headSecondHalf.value) {
                break; // not a palindrome
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverse(copyHeadSecondHalf); // revert the reverse of the second half
        if (head == null || headSecondHalf == null) // if both halves match
            return true;
        return false;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

  public static boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast)
        return true; // found the cycle
    }
    return false;
  }

  public static ListNode findCycleStart(ListNode head) {
      int cycleLength = 0;
      // find the LinkedList cycle
      ListNode slow = head;
      ListNode fast = head;
      while (fast != null && fast.next != null) {
          fast = fast.next.next;
          slow = slow.next;
          if (slow == fast) { // found the cycle
              cycleLength = calculateCycleLength(slow);
              break;
          }
      }

      return findStart(head, cycleLength);
  }

    private static int calculateCycleLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slow);

        return cycleLength;
    }

    private static ListNode findStart(ListNode head, int cycleLength) {
        ListNode pointer1 = head, pointer2 = head;
        // move pointer2 ahead 'cycleLength' nodes
        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
        }

        // increment both pointers until they meet at the start of the cycle
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }


}