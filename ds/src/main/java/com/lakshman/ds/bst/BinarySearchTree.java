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

    public void printNodeAtSameDepth() {
        if (root == null) {
            return;
        }

        Queue<Node> currentLevelQueue = new ArrayDeque<>();
        Queue<Node> nextLevelQueue = new ArrayDeque<>();
        currentLevelQueue.add(root);

        while (!currentLevelQueue.isEmpty()) {
            Node node = currentLevelQueue.remove();
            String comma = (!currentLevelQueue.isEmpty()) ? ", ":"";
            System.out.print("(" + node.data + ")" + comma);

            if (node.left != null) nextLevelQueue.add(node.left);
            if (node.right != null) nextLevelQueue.add(node.right);

            if(currentLevelQueue.isEmpty()){

                // new line
                System.out.println();

                // swapping queues
                Queue<Node> tempQ = currentLevelQueue;
                currentLevelQueue = nextLevelQueue;
                nextLevelQueue = tempQ;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        bst.insert(7);
        bst.insert(6);
        bst.insert(8);

        bst.printNodeAtSameDepth();
    }
}
