package Array;

import Job.Job;

public class Array {

    Job [] jobs;

    public Array(int limit) {
        this.jobs = new Job[limit];
    }

    public static Boolean JobContains(Job[] array, Job element ){
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(null)) {
                return true;
            }
        }

        return false;
    }

    public static void JobAdd(Job[] array, Job element) {
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            if (!(counter == array.length)) {
                if (array[i].equals(0)) {
                    array[i] = element;
                    counter++;
                }
                else {
                    counter++;
                }
            } else {
                Job[] temp = array;
                array = new Job[array.length + 4];
                array = temp;
            }

        }
    }
}
