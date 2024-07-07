package JobQueue;

import Job.Job;
import linkedList.LinkedList;

public class JobArray {
    private Job[] jobs = new Job[10];
    public static int count = 0;
    public static int front = 0;          //To maintain the queue front
    public static int back = 0;
//    public void input_Array(int size){
//        this.jobs = new Job[size];
//    }

    public void createJob(int job_Id,String jobName,String jobDescription){
        if (count == jobs.length){           //Checking is size of the array is enough or not
            Job[] current_jobs = jobs;
            jobs = new Job[current_jobs.length+5];      //Increasing the current size of the array
        }
        jobs[count] = new Job(job_Id,jobName,jobDescription);            //Creating new Job object
        count++;
        ++back;
    }

    public Job find_job(int jobID){            //finding a job
        for (int i = 0; i < count; i++){
            if (jobs[i].job_ID == jobID){
                return jobs[i];   //returning the job
            }
        }
        System.out.println("Job not found");        //Showing massage to the user
        return null;
    }

    public void createDependencies(int job_Id, int dep_Id) {
        if (find_job(job_Id) == null || find_job(dep_Id) == null) { // Avoiding adding null jobs
            System.out.println("Jobs do not exist");
        } else if (job_Id == dep_Id) { // Avoiding implementing job ID as dependent ID
            System.out.println("You can't insert job ID as dependent ID");
        } else if (LinkedList.avaiable(find_job(dep_Id).dependencies, find_job(job_Id))) { // Checking if the Job ID was a Dependency ID of the current Dependency in the past
            System.out.println("Job ID cannot be a previous dependency of the current Dependency");
        } else {
            find_job(job_Id).dependencies.insert(find_job(dep_Id)); // Adding dependencies
        }
    }


    public void showJob(int job_Id){            //Showing the details of the job
        System.out.println(" ");
        System.out.println("Job ID: " + job_Id);
        System.out.println(" ");
        System.out.println("Job name : "+find_job(job_Id).job_Name);
        System.out.println(" ");
        System.out.println("Job description "+find_job(job_Id).job_Description);
        System.out.println(" ");
        find_job(job_Id).dependencies.show();
        System.out.println(" ");
    }

    public void executeJob(Job job) {
        showJob(job.job_ID);
        if (job.dependencies.checkReady()) {
            System.out.println("All dependencies are completed");
            System.out.println(" ");
            jobs[front].setCompleted();
            System.out.println(" ");
            System.out.println(jobs[front].job_ID + " is completed ");
            ++front;

        } else {
            System.out.println("Completing all dependencies.....");
            executeJob(job.dependencies.getDependencies());

        }


    }
}
