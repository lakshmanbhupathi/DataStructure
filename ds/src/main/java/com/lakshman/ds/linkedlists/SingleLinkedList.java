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
     * @return true if inserted
     */
    public boolean insertNode(int value) {
        if (head == null) {
            head = new Node(value, null);
            return true;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(value, null);
        return true;
    }

    /**
     * Deletes elements from LL
     *
     * @param value value
     * @return true if deleted
     */
    public boolean deleteNode(int value){
        if(head == null) return false;
        if(head.value == value) head = head.next;

        Node currentNode = head;
        Node prevNode = null;
        while(currentNode != null){
            if (currentNode.value == value){
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

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertNode(1);
        singleLinkedList.insertNode(2);
        singleLinkedList.insertNode(3);
        singleLinkedList.insertNode(4);
        singleLinkedList.insertNode(5);

        singleLinkedList.printLinkedList();

        singleLinkedList.deleteNode(3);
        singleLinkedList.deleteNode(5);
        singleLinkedList.deleteNode(1);
        System.out.println();
        singleLinkedList.printLinkedList();
    }

}
