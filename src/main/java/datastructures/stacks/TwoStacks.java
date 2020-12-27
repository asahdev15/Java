package datastructures.stacks;

class TwoStacks {

  int size;
  int[] arr;
  int top1,
  top2; //Store top value indices of Stack 1 and Stack 2
  public TwoStacks(int n) {
    size = n;
    arr = new int[size];
    top1 = -1;
    top2 = size;
  }

  //Insert Value in First Stack  
  public void push1(int value) {
    //Check for empty space and insert value if there's an empty space.
    if (top1 < top2 - 1) {
      arr[++top1] = value;
    }
  }

  //Insert Value in Second Stack
  public void push2(int value) {
    //Check for empty space and insert value if there's an empty space.
    if (top1 < top2 - 1) {
      arr[--top2] = value;
    }
  }

  //Return and remove top Value from First Stack
  public int pop1() {
    //Get value from top1 index and decrement it. 
    if (top1 >= 0) {
      int val = arr[top1--];
      return val;
    }
    return - 1;
  }

  //Return and remove top Value from Second Stack
  public int pop2() {
    //Get value from top2 index and increment it.
    if (top2 < size) {
      int val = arr[top2++];
      return val;
    }
    return - 1;
  }


  public static void main(String args[]) {

    TwoStacks tS = new TwoStacks(5);

    tS.push1(11);
    tS.push1(3);
    tS.push1(7);
    tS.push2(1);
    tS.push2(9);

    System.out.println(tS.pop1());
    System.out.println(tS.pop2());
    System.out.println(tS.pop2());
    System.out.println(tS.pop2());
    System.out.println(tS.pop1());


  }  
}