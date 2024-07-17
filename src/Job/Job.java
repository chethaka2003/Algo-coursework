package Job;

import linkedList.LinkedList;

//Job class for hols variables of Job
public class Job {
    public int job_ID;
    public String job_Name;
    public String job_Description;
    public boolean completed = false;
    public LinkedList dependencies;
    public int dep_count;
    public int [] dep_of = new int [4];
    int count;


    public Job(int job_ID, String job_Name, String job_Description) {   //Making constructor for Job class
        this.job_ID = job_ID;
        this.job_Name = job_Name;
        this.job_Description = job_Description;
        this.dependencies = new LinkedList();
        count = 0;


    }

    //Completing the project
    public void setCompleted(){
        this.completed = true;
    }

    //Adding dependency of which project
    public void add_dep_of(int job_ID){
        if(this.dep_of.length == count){
            int[] temp = new int[count + 10];
            // Copy existing elements to the new array
            for (int i = 0; i < count; i++) {
                temp[i] = this.dep_of[i];
            }
            this.dep_of = temp;
        }
        else {
            dep_of[count] = job_ID;
            count++;
        }

    }

    //Getting dependencies
    public int[] getDep(){
        return dep_of;
    }


}


