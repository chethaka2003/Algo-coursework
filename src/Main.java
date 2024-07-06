import JobQueue.JobArray;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        JobArray obj = new JobArray();
        obj.createJob(5555,"fuck","none");
        obj.createJob(3333,"sex","none");
        obj.createDependencies(5555,3333);
        obj.showJob(5555);
        obj.showJob(3333);



    }
}