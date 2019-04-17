package com.test.collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    String val;
    TreeNode left;
    TreeNode right;
    TreeNode(String x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString(){
        return "val: " + val;
    }
}

public class BinaryTree {
    public static void visit(TreeNode node) {
        System.out.print(node.val + " ");
    }

    /**
     * 二叉树的先序遍历
     * 输出结果是：A B D E C F G
      */
    public static void preOrderRecursion(TreeNode root){
        if (root != null) {
            visit(root);
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
        }
    }

    /**
     * 中序遍历
     * 输出结果是: B D E A C F G
      */
    public static void inOrderRecursion(TreeNode root){
        if (root != null) {
            preOrderRecursion(root.left);
            visit(root);
            preOrderRecursion(root.right);
        }
    }

    /**
     * 后续遍历
     * 输出结果是：B D E C F G A
     */
    public static void postOrderRecursion(TreeNode root){
        if (root != null) {
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
            visit(root);
        }
    }

    /**
     * 用Stack实现 深度优先搜索算法（Depth First Search）
     * 排序后的结果是：A B D E C F G
     */
    public static void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);
        while(!treeStack.isEmpty()) {
            TreeNode temp = treeStack.pop();
            if(temp != null) {
                visit(temp);
                treeStack.push(temp.right);
                treeStack.push(temp.left);
            }
        }
    }

    /**
     * 用Queue实现 广度优先搜索算法（Breadth First Search）
     * 排序后的结果是： A B C D E F G
      */

    public static void BFS(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty()) {
            TreeNode temp = treeQueue.poll();
            if(temp != null) {
                visit(temp);
                treeQueue.add(temp.left);
                treeQueue.add(temp.right);
            }
        }
    }

    public static void main(String[] args){
        TreeNode tree = new TreeNode("A");
        tree.setLeft(new TreeNode("B"));
        tree.setRight(new TreeNode("C"));
        tree.getLeft().setLeft(new TreeNode("D"));
        tree.getLeft().setRight(new TreeNode("E"));
        tree.getRight().setLeft(new TreeNode("F"));
        tree.getRight().setRight(new TreeNode("G"));

        System.out.println("\n先序遍历，递归方法实现");
        preOrderRecursion(tree);
        System.out.println("\n中序遍历，递归方法实现");
        inOrderRecursion(tree);
        System.out.println("\n后序遍历，递归方法实现");
        postOrderRecursion(tree);
        System.out.println("\n深度优先遍历，Stack方法实现");
        DFS(tree);
        System.out.println("\n广度优先遍历，Queue方法实现");
        BFS(tree);
    }
}