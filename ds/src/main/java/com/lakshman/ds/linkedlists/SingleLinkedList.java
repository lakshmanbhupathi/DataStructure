package com.lakshman.ds.linkedlists;

/**
 * Single Linked list and basic operations
 *
 */
public class SingleLinkedList {
    private Node head;

    class Node{
        int value;
        Node next;

        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Inserts node into linkedList
     * @param value
     * @return
     */
    public boolean insertNode(int value){
        if(head == null){
            head = new Node(value,null);
            return true;
        }

        Node currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(value,null);
        return true;
    }

    public void printLinkedList(){
        Node currentNode = head;
        while(currentNode != null){
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
    }

}
