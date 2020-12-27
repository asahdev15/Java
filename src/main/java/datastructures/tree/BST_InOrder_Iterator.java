package datastructures.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class BST_InOrder_Iterator {

  Stack<BinaryNode> stk = new Stack<BinaryNode>();

  public BST_InOrder_Iterator(BinaryNode root) {
    while(root != null) {
      stk.push(root);
      root = root.left;
    }
  }

  public boolean hasNext() {
    return !stk.isEmpty();
  }

  public BinaryNode getNext() {
    if(stk.isEmpty())
      return null;

    BinaryNode rVal = stk.pop();
    BinaryNode temp = rVal.right;
    while(temp!= null) {
      stk.push(temp);
      temp = temp.left;
    }

    return rVal;
  }
  



}