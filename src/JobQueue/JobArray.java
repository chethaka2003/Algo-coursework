package JobQueue;

import Job.Job;

public class JobArray {
    private Job[] jobs = new Job[10];
    public static int count = 0;
    int front;          //To maintain the queue front
    int back;
    int size;
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

    public void createDependencies(int job_Id,int dep_Id){
        if(find_job(job_Id) == null && find_job(dep_Id) == null){
            System.out.println("Jobs are not exist");
        }
        else {
            find_job(job_Id).dependencies.insert(find_job(dep_Id));     //adding dependencies
        }
    }

    public void showJob(int job_Id){
        System.out.println(find_job(job_Id).job_Name);
        System.out.println(find_job(job_Id).job_Description);
        find_job(job_Id).dependencies.show(find_job(job_Id).dependencies);
    }


}
