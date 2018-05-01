package com.lakshman.ds.bst;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public boolean insert(int data) {
        if (root == null) {
            root = new Node(data);
            return true;
        }
        return insert(root, data);
    }

    private boolean insert(Node node, int data) {
        if (node.data > data) {
            if (node.left == null) {
                node.left = new Node(data);
                return true;
            }
            insert(node.left, data);
        } else {
            if (node.right == null) {
                node.right = new Node(data);
                return true;
            }
            insert(node.right, data);
        }
        return false;
    }

    /**
     * @asked LINE April'18
     */
    public void printNodeAtSameDepth() {
        if (root == null) {
            return;
        }

        Queue<Node> currentLevelQueue = new ArrayDeque<>();
        Queue<Node> nextLevelQueue = new ArrayDeque<>();
        currentLevelQueue.add(root);

        while (!currentLevelQueue.isEmpty()) {
            Node node = currentLevelQueue.remove();
            String comma = (!currentLevelQueue.isEmpty()) ? ", " : "";
            System.out.print("(" + node.data + ")" + comma);

            if (node.left != null) nextLevelQueue.add(node.left);
            if (node.right != null) nextLevelQueue.add(node.right);

            if (currentLevelQueue.isEmpty()) {
                // new line
                System.out.println();

                // swapping queues
                Queue<Node> tempQ = currentLevelQueue;
                currentLevelQueue = nextLevelQueue;
                nextLevelQueue = tempQ;
            }
        }
    }

    public int getHeight() {
        if (root == null) return 0;
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return Math.max(1 + getHeight(node.left), 1 + getHeight(node.right)); // return only max among sub tree's height
    }

    /**
     * @asked Morgan Stanley April'18
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     *  A binary tree is said to be not - balanced when any of the node's difference of it's sub tree more than 1
     *
     * @param node
     * @return
     */
    private boolean isBalanced(Node node) {
        return (node == null) || // null return true so won't proceed ahead
                (isBalanced(node.left) &&   // recursively calling on left & right sub trees if any fails returning false whole together
                        isBalanced(node.right) &&
                        Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1);  // ***abs
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(2);
        bst.insert(3);
        bst.insert(1);
//        bst.insert(0);
        bst.insert(7);
        bst.insert(6);
        bst.insert(8);

        bst.printNodeAtSameDepth();
        System.out.println(bst.getHeight());
        System.out.println(bst.isBalanced());
    }
}
