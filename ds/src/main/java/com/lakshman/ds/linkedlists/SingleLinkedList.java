package com.lakshman.ds.linkedlists;

/**
 * Single Linked list and basic operations
 */
public class SingleLinkedList {
    private Node head;

    class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Inserts node into linkedList
     *
     * @param value val
     * @return node newNode
     */
    public Node insertNode(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            return newNode;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        return newNode;
    }

    /**
     * Deletes elements from LL
     *
     * @param value value
     * @return true if deleted
     */
    public boolean deleteNode(int value) {
        if (head == null) return false;
        if (head.value == value) head = head.next;

        Node currentNode = head;
        Node prevNode = null;
        while (currentNode != null) {
            if (currentNode.value == value) {
                prevNode.next = currentNode.next;
                return true;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        return false;
    }

    public void printLinkedList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.next == null ? currentNode.value : currentNode.value + " --> ");
            currentNode = currentNode.next;
        }
    }

    /**
     * delete node with out head
     * <p>
     * won't work if node is last node in the LL.
     *
     * @param node node
     * @asked Oracle April'18
     */
    public void deleteNodeWithoutHead(Node node) {
        if (node.next == null) {
            return;
        }

        node.value = node.next.value;
        node.next = node.next.next;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (head == null) return "";
        Node node = head;
        while (node != null) {

            sb.append(node.value);
            if (node.next != null) {
                sb.append("-->");
            }
            node = node.next;
        }

        return sb.toString();
    }

    /**
     * Recursive
     * <p>
     * Ignore not working
     *
     * @asked Phenom people April'18
     */
    public void reverseLinkedList() {
        if (head == null) return;
        reverseLinkedList(head);
    }

    private Node reverseLinkedList(Node node) {
        if (node.next == null) {
            head = node;
            return node;
        }
        node.next = reverseLinkedList(node);
        return node;
    }

    public void reverseLinkedListIterative() {
        if (head == null || head.next == null) return;

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
    }

    /**
     * complete Explanation https://www.youtube.com/watch?time_continue=241&v=MRe3UsRadKw
     */
    public void reverseLinkedListRecursive() {
        reverseLinkedListRecursive(head);
    }

    private void reverseLinkedListRecursive(Node node) {
        if (node == null) return;

        // Then this is last element
        if (node.next == null) {
            head = node;
            return;
        }

        // calling recursively down
        reverseLinkedListRecursive(node.next);


        node.next.next = node;
        node.next = null;
    }

    public boolean find(int data) {
        Node node = head;
        while (node != null) {
            if (node.value == data) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertNode(1);
        singleLinkedList.insertNode(2);
        singleLinkedList.insertNode(3);
        singleLinkedList.insertNode(4);
        singleLinkedList.insertNode(5);
        System.out.println("After inserting : ");
        singleLinkedList.printLinkedList();

        singleLinkedList.reverseLinkedListRecursive();
        System.out.println("reverse LL :: " + singleLinkedList);

        singleLinkedList.deleteNode(3);
        singleLinkedList.deleteNode(5);
        singleLinkedList.deleteNode(1);
        System.out.println("\nAfter deleting 3,5,1 : ");
        System.out.print(singleLinkedList);

        singleLinkedList.insertNode(5);
        Node newNode1 = singleLinkedList.insertNode(1);
        Node newNode3 = singleLinkedList.insertNode(3);
        System.out.println("Same list : " + singleLinkedList);

        singleLinkedList.deleteNodeWithoutHead(newNode1);
        System.out.println("After deleting 1 : " + singleLinkedList);
        singleLinkedList.deleteNodeWithoutHead(newNode3);
        System.out.println("After deleting 3 : " + singleLinkedList);

        System.out.println(singleLinkedList.find(3));
        System.out.println(singleLinkedList.find(5));
        System.out.println(singleLinkedList.find(1));

    }

}
