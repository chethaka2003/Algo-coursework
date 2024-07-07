package Job;

import linkedList.LinkedList;

public class Job {
    public int job_ID;
    public String job_Name;
    public String job_Description;
    public boolean completed = false;
    public LinkedList dependencies;

    public Job(int job_ID, String job_Name, String job_Description) {   //Making constructor for Job class
        this.job_ID = job_ID;
        this.job_Name = job_Name;
        this.job_Description = job_Description;
        this.dependencies = new LinkedList();

    }
    public void setCompleted(){
        this.completed = true;
    }


}


