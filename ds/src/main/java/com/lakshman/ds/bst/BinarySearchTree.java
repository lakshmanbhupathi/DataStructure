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
     * A binary tree is said to be not - balanced when any of the node's difference of it's sub tree more than 1
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


    /* Returns true if binary tree with root as root is height-balanced */

    /**
     * Elaborated version
     *
     * @param node
     * @return
     * @see <a href="https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/">Geeks4Geeks</a>
     */
    private boolean isBalanceddd(Node node) {
        int lh; /* for height of left subtree */

        int rh; /* for height of right subtree */

        /* If tree is empty then return true */
        if (node == null)
            return true;

        /* Get the height of left and right sub trees */
        lh = getHeight(node.left);
        rh = getHeight(node.right);

        if (Math.abs(lh - rh) <= 1
                && isBalanceddd(node.left)
                && isBalanceddd(node.right))
            return true;

        /* If we reach here then tree is not height-balanced */
        return false;
    }

    public boolean isPresent(int key) {
        return isPresent(root, key) != null;
    }

    private Node isPresent(Node node, int key) {
        if(node == null ) return null;
        if (node.data == key) return node;
        else if (node.data > key) {
            return isPresent(node.left, key);
        } else {
            return isPresent(node.right, key);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
//        bst.insert(0);
        bst.insert(7);
        bst.insert(6);
        bst.insert(8);

        bst.printNodeAtSameDepth();
        System.out.println(bst.getHeight());
        System.out.println(bst.isBalanced());
        System.out.println(bst.isBalanceddd(bst.root));
        System.out.println(bst.isPresent(bst.root,0));
        System.out.println(bst.isPresent(0));
        System.out.println(bst.isPresent(1));
    }
}
