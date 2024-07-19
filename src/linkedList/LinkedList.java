package linkedList;

import Job.Job;

public class LinkedList {
    Node head;          //head of the linkedlist

    //Adding new project to the array
    public void insert(Job job) {
        Node node = new Node(job);
        node.next = null;

        if (head == null) {         //Checking weather the head is null or not
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {        //lopping through every node
                temp = temp.next;
            }
            temp.next = node;          //Assigning new node address into the previous node address
        }
    }

    //Showing project details
    public void show() {
        Node temp = this.head;
        if (this.head == null) {
            System.out.println("No dependencies to show");
        }
        while (temp != null) {
            System.out.println(temp.job.job_ID);
            temp = temp.next;
        }
    }

    public boolean checkReady() {            //Check if the all dependencies are completed or not
        byte found = 0;         //Checking variable
        Node temp = this.head;
        while (temp != null) {
            if (temp.job.completed) {
                temp = temp.next;
            } else {
                found = 1;
                temp = temp.next;
            }
        }
        if (found == 0) {
            return true;
        } else {
            return false;
        }

    }


    // Method to detect cycle
    public boolean hasCycle(Job dep, Job target) {
        if (dep == target) {
            return true;
        }
        Node temp = this.head;
        while (temp != null) {
            if (temp.job.dependencies.hasCycle(temp.job, target)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    //Checks if the dependencies are empty or not
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }


    //Get the next job and remove first
    public Job poll() {
        if (this.head == null) {
            return null;
        }
        Job current = head.job;
        head = head.next;
        return current;

    }

    //Remove items in linked list
    public void remove(Job job) {
        if (head == null) {
            return;
        }
        if (head.job == job) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.job != job) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void addingFront(Job newjob) {

            Node newNode = new Node(newjob);
            newNode.next = head;
            head = newNode;

        }


}



