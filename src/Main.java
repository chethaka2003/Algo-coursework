import JobQueue.JobArray;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Using new Scanner class
        Scanner input = new Scanner(System.in);

        //Creating new object in JobArray class
        JobArray jobArray = new JobArray();

        //Assigning a variable to run in infinite loop until user exits
        boolean running = true;
        while (running) {
            //showing some massages to user
            System.out.println("\nWelcome to the job scheduling system\n");
            System.out.println("Select your choice from the list below:");
            System.out.println("1. Add job");
            System.out.println("2. Add dependency");
            System.out.println("3. Execute all jobs");
            System.out.println("4. Show job details");
            System.out.println("5. Exit");
            System.out.print("\nPlease enter your choice: ");

            boolean validInput = false; // Looping until user input numbers

            int choice = 0;
            while (!validInput) {
                if (input.hasNextInt()) {
                    choice = input.nextInt();
                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                    input.next(); // Clear invalid input
                }
            }
            //Getting user inputs
            switch (choice) {
                case 1:
                    addJob(input, jobArray);
                    break;
                case 2:
                    addDependency(input, jobArray);
                    break;
                case 3:
                    jobArray.executeAllJobs();
                    break;
                case 4:
                    showJobDetails(input, jobArray);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    //Adding job method
    private static void addJob(Scanner input, JobArray jobArray) {
        boolean validInput = false;     //Looping until user input numbers
        int id = 0;

        while (!validInput) {
            try {       //Avoid getting strings as a Job ID
                System.out.print("Please enter the job ID: ");
                id = input.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Please enter numbers only.");
                input.next(); // Clear invalid input
            }
        }

        //Getting Job name
        System.out.print("Please enter the job name: ");
        String name = input.next();

        //Getting job description
        System.out.print("Please enter the job description: ");
        String description = input.next();

        //Creating a new Job
        jobArray.createJob(id, name, description);
    }

    //Adding new dependencies
    private static void addDependency(Scanner input, JobArray jobArray) {
        int jobId = 0, depId = 0;       //Setting initial values
        boolean validInput = false;

        while (!validInput) {
            try {       //Getting only numbers
                System.out.print("Please enter the job ID: ");
                jobId = input.nextInt();
                System.out.print("Please enter the dependency job ID: ");
                depId = input.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Please enter numbers only.");
                input.next(); // Clear invalid input
            }
        }

        //Creating new depndency
        jobArray.createDependencies(jobId, depId);
    }

    //Showing Job details respectively
    private static void showJobDetails(Scanner input, JobArray jobArray) {
        boolean validInput = false;
        int jobId = 0;

        while (!validInput) {
            try {
                System.out.print("Please enter the job ID to show details: ");
                jobId = input.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Please enter numbers only.");
                input.next(); // Clear invalid input
            }
        }

        //Showing Job details
        jobArray.showJob(jobId);

//        JobArray obj = new JobArray();
//        obj.createJob(1111,"Water","none");
//        obj.createJob(2222,"Poop","none");
//        obj.createJob(3333,"Eat","none");
//        obj.createJob(4444,"apple","none");
//        obj.createJob(5555,"eat","none");
//        obj.createJob(6666,"eat","none");
//        obj.createDependencies(1111,2222);
//        obj.createDependencies(2222,3333);
//        obj.createDependencies(3333,4444);
//        obj.createDependencies(4444,6666);
//        obj.createDependencies(6666,5555);
//        obj.executeAllJobs();
    }
}
