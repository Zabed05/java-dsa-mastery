package Questions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BT {

    // Level Order Traversal (LC: 102)
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel);
        }
        return result;
    }

    // Average of levels in Binary Tree (LC: 637) (ask in google)
    public List<Double> levelAverage(TreeNode root){
        List<Double> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            double levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            double average = levelSum/levelSize;
            result.add(average);
        }
        return result;
    }

    //LevelOrder Successor of a node (ask in google)
    public TreeNode findSuccessor(TreeNode root, int key){
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();

            if(currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null){
                queue.offer(currentNode.right);
            }

            if(currentNode.val == key){
                break;
            }
        }
        return queue.peek();
    }

    // Binary Tree ZigZag Level Order Traversal (LC: 103)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        boolean reverse = false;

        while(!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                if(!reverse){
                    TreeNode currentNode = deque.pollFirst();
                    currentLevel.add(currentNode.val);

                    if(currentNode.left != null){
                        deque.offerLast(currentNode.left);
                    }
                    if(currentNode.right != null){
                        deque.offerLast(currentNode.right);
                    }

                }
                else{
                    TreeNode currentNode = deque.pollLast();
                    currentLevel.add(currentNode.val);

                    if(currentNode.right != null){ // add right first
                        deque.offerFirst(currentNode.right);
                    }
                    if(currentNode.left != null){
                        deque.offerFirst(currentNode.left);
                    }
                }
            }
            reverse = !reverse;
            result.add(currentLevel);
        }
        return result;
    }

    // Level Order Traversal II (LC: 107)
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }

            result.add(0, currentLevel);
        }
        return result;
    }
    
    // Populating next right ponters in each node (LC: 116)
    class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
    public Node connect(Node root){
        if(root == null){
            return null;
        }
        Node leftMost = root;
        while(leftMost.left != null){
            Node current = leftMost;
            while(current != null){
                current.left.next = current.right;
                if(current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    // Binary Tree Right side view (LC:199) (ask in Amazon, Filipkart)
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            TreeNode rightNode = null;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
                rightNode = currentNode;
            }
            result.add(rightNode.val);
        }
        return result;
    }

    // Cousins in Binary Tree (LC: 993)
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (
            (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy))
        );
    }
    TreeNode findNode(TreeNode node, int x) {
        if (node == null){
            return null;
        }
        if (node.val == x){
            return node;
        }
        TreeNode n = findNode(node.left, x);
        if (n != null){
            return n;
        }
        return findNode(node.right, x);
    }
    boolean isSibling (TreeNode node, TreeNode x, TreeNode y) {
        if (node == null){
            return false;
        }

        return (
        (node.left == x && node.right == y) || (node.left == y && node.right == x)
        || isSibling(node.left, x, y) || isSibling(node.right, x, y)
        );
    }
    int level (TreeNode node, TreeNode x, int lev) {
        if(node == null){
            return 0;
        }

        if(node == x){
            return lev;
        }

        int l = level(node.left, x, lev+1);
        if (l != 0){
            return l;
        }
        return level(node.right, x, lev+1);
    }

    // Symmetric Tree (LC: 101) (ask in Google, Amazon, Apple)
    public boolean isSymmetric(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }

            if(left.val != right.val){
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    //--------------------DFS--------------------//
    // Diameter of Binary Tree (LC: 543)
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return  diameter;
    }
    private int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, dia);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}