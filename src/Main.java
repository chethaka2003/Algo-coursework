import JobQueue.JobArray;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the job scheduling system");
        System.out.println(" ");
        JobArray obj = new JobArray();
        obj.createJob(1111,"Water","none");
        obj.createJob(2222,"Poop","none");
        obj.createJob(3333,"Eat","none");
        obj.createJob(4444,"apple","none");
        obj.createJob(5555,"eat","none");
        obj.createJob(6666,"eat","none");
        obj.createDependencies(1111,2222);
        obj.createDependencies(2222,3333);
        obj.createDependencies(3333,4444);
        obj.createDependencies(4444,6666);
        obj.createDependencies(6666,5555);
        obj.executeAllJobs();


    }
}