package linkedList;

import Job.Job;

public class Node {         //Creating a new node
    Job job;
    Node next;              //Adding new memory locations for node

    public Node(Job job) {
        this.job = job;
    }
}
