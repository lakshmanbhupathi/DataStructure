package com.lakshman.ds.bst;

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

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        bst.insert(7);
        bst.insert(6);

        System.out.println("debug");
    }

}
