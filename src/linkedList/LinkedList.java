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

    public void show() {
        Node temp = this.head;
        if (this.head == null){
            System.out.println("No dependencies to show");
        }
        while (temp != null) {
            System.out.println(temp.job.job_ID);
            temp = temp.next;
        }
    }

    public boolean checkReady(){            //Check if the all dependencies are completed or not
        byte found = 0;         //Checking variable
        Node temp = this.head;
        while (temp != null) {
            if (temp.job.completed){
                temp = temp.next;
            }
            else {
                found = 1;
                temp=temp.next;
            }
        }
        if (found == 0){
            return true;
        }
        else {
            return false;
        }

    }

    public static boolean avaiable(LinkedList current,Job job) {
        Node temp = current.head;
        while (temp != null) {
            if (temp.job == job) {
                return true;
            } else {
                temp = temp.next;
                return false;
            }

        }
        return false;
    }

    public Job getDependencies() {
        Node temp = this.head;
        while (temp != null) {
            return temp.job;
        }
        return null;
    }
}
