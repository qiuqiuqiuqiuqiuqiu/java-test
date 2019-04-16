package com.test.collections;

import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
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
        System.out.println(node.val);
    }

    public static void preOrderRecursion(TreeNode root){
        if (root != null) {
            visit(root);
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
        }
    }

    public static void preOrderTraversal(TreeNode root) {
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

    public static void main(String[] args){
        TreeNode tree = new TreeNode(10);
        tree.setLeft(new TreeNode(3));
        tree.setRight(new TreeNode(5));
        tree.getLeft().setLeft(new TreeNode(6));
        tree.getLeft().setRight(new TreeNode(8));

        preOrderRecursion(tree);
        preOrderTraversal(tree);
    }
}