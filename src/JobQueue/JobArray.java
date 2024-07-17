package JobQueue;

import Job.Job;
import linkedList.LinkedList;

public class JobArray {
    private Job[] jobs = new Job[10];
    public static int count = 0;
    public static int front = 0;          //To maintain the queue front
    public static int back = 0;
    LinkedList readyQueue = new LinkedList();       //To add the items which are ready to execute

    //Creating new job
    public void createJob(int job_Id, String jobName, String jobDescription) {
        if (count == jobs.length) {  // Check if the size of the array is enough
            Job[] current_jobs = jobs;
            jobs = new Job[current_jobs.length + 5];  // Increase the current size of the array
        }
        Job newJob = new Job(job_Id, jobName, jobDescription);
        jobs[count] = newJob;
        readyQueue.insert(newJob);// Add the job to the ready queue initially
        count++;

    }

    public Job find_job(int jobID) {  // Finding a job
        for (int i = 0; i < count; i++) {
            if (jobs[i].job_ID == jobID) {
                return jobs[i];  // Returning the job
            }
        }
        System.out.println("Job not found");  // Showing message to the user
        return null;
    }

    //Creating dependencies
    public void createDependencies(int job_Id, int dep_Id) {
        //Getting jobs using Job ID
        Job job = find_job(job_Id);
        Job dep = find_job(dep_Id);
        if (job == null || dep == null) {  // Avoiding adding null jobs
            System.out.println("Jobs do not exist");
        } else if (job_Id == dep_Id) {  // Avoiding implementing job ID as dependent ID
            System.out.println("You can't insert job ID as dependent ID");
        } else if (dep.dependencies.hasCycle(dep, job)) {  // Detecting cycle before adding dependency
            System.out.println("Adding Job ID :"+dep_Id+" as dependency of Job:"+job_Id+" creates a cycle");
        } else {
            job.dependencies.insert(dep);  // Add dependencies
            job.dep_count++;  // Increment the in-degree of the dependent job
            dep.add_dep_of(job_Id);
            if (job.dep_count == 1) {
                readyQueue.remove(job);  // Remove the job from the ready queue if it has dependencies
            }
        }
    }

    public void showJob(int job_Id) {  // Showing the details of the job
        //Getting job using Job ID
        Job job = find_job(job_Id);
        if (job != null) {
            //Showing details
            System.out.println(" ");
            System.out.println("Job ID: " + job_Id);
            System.out.println(" ");
            System.out.println("Job name: " + job.job_Name);
            System.out.println(" ");
            System.out.println("Job description: " + job.job_Description);
            System.out.println(" ");
            System.out.println("Dependencies of job ID: " + job_Id);
            job.dependencies.show();
            System.out.println(" ");
        }
    }

    //Getting next job in readyQueue
    public Job getNextJobToExecute() {
        if (!readyQueue.isEmpty()) {
            return readyQueue.poll();  // Get and remove the next job from the ready queue
        }
        return null;  // No jobs are ready to execute
    }

    //Execute next job in ready queue
    public void executeJob(Job job) {
        if (job.dependencies.checkReady()) {    //Checking the all dependencies are completed oe not
            job.setCompleted(); //Set the job as completed
            int[] dep_of = job.getDep();        //Getting the depndency of that job
            for (int i = 0; i < dep_of.length; i++) { //Looping through all dependencies which are not null
                if (dep_of[i] != 0) {
                    Job dependentJob = find_job(dep_of[i]);
                    if (dependentJob != null) {
                        dependentJob.dep_count--; //decreasing the dependency count of that job when it is completed
                        if (dependentJob.dep_count == 0) {
                            readyQueue.insert(dependentJob);    //Adding the job top the ready queue when all dependencies are completed
                        }
                    }
                }
            }
        }
    }

    //Executing all the jobs
    public void executeAllJobs() {
        while (!readyQueue.isEmpty()) {
            Job job = getNextJobToExecute();    //Getting next job
            if (job != null) {
                System.out.println("Currently executing job details:");
                showJob(job.job_ID);
                executeJob(job);
                System.out.println(job.job_ID + " is completed ");
                System.out.println(" ");
            }
        }
    }

    //Showing current executing Job
    public Job showCurrentExecuteJob() {
        return jobs[front];
    }

}
