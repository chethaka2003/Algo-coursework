import JobQueue.JobArray;

import java.util.Scanner;

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
        obj.createDependencies(1111,2222);
        obj.createDependencies(2222,3333);
        obj.executeAllJobs();




//        Scanner input = new Scanner(System.in);
//        System.out.println("Please eneter correct input from below Menu");
//        while (true) {
//            System.out.println(" ");            //Showing a list of inputs for user
//            System.out.println("1. Press 1 to add job ");
//            System.out.println("2. Press 2 to add Dependencies ");
//            System.out.println("3. Press 3 to Show the order of Jobs ");
//            System.out.println("4. Press 4 to Execute jobs one after another ");
//            System.out.println("5. Press 5 to Exit");
//            int choice = input.nextInt();
//
//            if (choice == 1) {
//                //add here
//            } else if (choice == 2) {
//                //add here
//            } else if (choice == 3) {
//                //add here
//            } else if (choice == 4) {
//                //add here
//            } else if (choice == 5) {
//                System.out.println("Thank you");
//                break;
//            } else {
//                System.out.println("Incorrect input please try again");
//                continue;
//            }
//        }





    }
}