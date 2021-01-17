package xdatastructures.tree;

import java.util.*;

public class Tree {

    public static void main(String[] args){
        Tree tree = new Tree();
        TreeNode root = tree.deserialize2("1,2,3,null,null,4,5");
//        List<List<Integer>> values = tree.levelOrder(root);
//        System.out.println(values);

        TreeNode root2 = tree.new TreeNode(1);
        root2.left = tree.new TreeNode(2);
        root2.right = tree.new TreeNode(3);
        root2.right.left = tree.new TreeNode(4);
        root2.right.right = tree.new TreeNode(5);

        System.out.println(tree.serialize(root));
    }

    public String serialize(TreeNode root) {
        if(root == null)
            return "null";
        StringBuilder items = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                TreeNode n = q.poll();
                if(n==null){
                    items.append("null,");
                }else{
                    q.offer(n.left);
                    q.offer(n.right);
                    items.append(n.val).append(",");
                }
                size--;
            }
        }
        return items.substring(0, items.length()-1);
    }


    public TreeNode deserialize2(String data) {
        if (data.equals("") || data.equals("null"))
            return null;
        String[] values = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode (Integer.valueOf(values[0]));
        q.add(root);
        int idx=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                TreeNode node = q.remove();
                if(idx< values.length && !values[idx].equals("null")){
                    TreeNode left = new TreeNode(Integer.valueOf(values[idx]));
                    node.left = left;
                    q.add(node.left);
                }
                idx++;
                if(idx< values.length && !values[idx].equals("null")){
                    TreeNode right = new TreeNode(Integer.valueOf(values[idx]));
                    node.right = right;
                    q.add(node.right);
                }
                idx++;
            }
        }

        return root;


    }


    public TreeNode deserialize(String data) {
        return deserialize(data.split(","), 0);
    }

    private TreeNode deserialize(String[] items, int i){
        if(i>items.length)
            return null;
        try{
            TreeNode n = new TreeNode(Integer.parseInt(items[i]));
            System.out.println(i + ":" + items[i]);
            n.left = deserialize(items, (2*i+1));
            n.right = deserialize(items, (2*i+2));
            return n;
        }catch(Exception ex){

        }
        return null;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>();

        List<List<Integer>> levels = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new LinkedList<>();
            while(size > 0){
                TreeNode n = q.poll();
                level.add(n.val);
                if(n.left!=null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
                size--;
            }
            levels.add(level);
        }
        return levels;
    }

    public List<Integer> postOrderTraversal(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<>();

        while(!stack.isEmpty() || node != null){
            if(node != null){ //visit all the nodes in left subtree first
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.peek().right == null){ //both left and child nodes are visited
                    TreeNode tmp = stack.pop();
                    result.add(tmp.val);

                    while(!stack.isEmpty() && stack.peek().right == tmp){
                        //if tmp is right child, visit the parent node
                        tmp = stack.pop();
                        result.add(tmp.val);
                    }
                }
                else{
                    //there is right child to the node, set it to add to the stack
                    node = stack.peek().right;
                }
            }
        }

        return result;
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;

        return left.val==right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return root.val == sum;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new LinkedList<>();
        findPaths(root, sum, new LinkedList<>(), paths);
        return paths;
    }
    private void findPaths(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> paths){
        if(root == null)
            return;
        currentPath.add(root.val);
        sum = sum - root.val;
        if(root.left == null && root.right == null && sum == 0) {
            paths.add(currentPath);
            return;
        }
        findPaths(root.left, sum, new LinkedList<>(currentPath), paths);
        findPaths(root.right, sum, new LinkedList<>(currentPath), paths);
    }



    Map<Integer,Integer> map;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        index = inorder.length-1;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildTree(postorder,0,inorder.length-1);
    }
    private TreeNode buildTree(int[] postorder, int start, int end){
        if(start > end){
            return null;
        }
        int idx = map.get(postorder[index]);
        TreeNode node = new TreeNode(postorder[index]);
        index--;
        node.right = buildTree(postorder,idx+1,end);
        node.left = buildTree(postorder,start,idx-1);
        return node;
    }




    int max_path_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return max_path_sum;
    }
    public int maxPathSumUtil(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSumUtil(root.left));
        int right = Math.max(0, maxPathSumUtil(root.right));
        max_path_sum = Math.max(left + right + root.val, max_path_sum);
        return Math.max(left, right) + root.val;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


