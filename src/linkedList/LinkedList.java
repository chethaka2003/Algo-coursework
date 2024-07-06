package linkedList;

import Job.Job;

public class LinkedList {
    Node head;          //head of the linkedlist

    public void insert(Job job) {
        Node node = new Node(job);
        node.next = null;

        if (head == null) {         //Checking weather the head is null or not
            head = node;
        }
        else{
             Node temp = head;
             while (temp.next != null) {        //lopping through every node
                temp = temp.next;
             }
             temp.next = node;          //Assigning new node address into the previous node address
        }
    }

    public void show(LinkedList current) {
        Node temp = current.head;
        while (temp != null) {
            System.out.println(temp.job.job_ID);
            temp = temp.next;
        }
    }
}
