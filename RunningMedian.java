import java.util.Scanner;

/**
 * Created by Pankaj on 08-03-2017.
 */
public class RunningMedian {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int elements = in.nextInt();        // Total number of integers in set

        int[] set = new int[elements];      //set to store integers
        double median;
        int i =0;   // counter to keep track of current added element
        int j =0;   // counter for median element
        while (i<elements){

            set[i++] = in.nextInt();
            median = set[j]; // Set has odd elements
            System.out.println(median);

            if(i==elements) break;

            set[i++] = in.nextInt();
            median = (double) (set[j]+set[j+1])/2; // Set has even elements
            System.out.println(median);
            j++;
        }
    }
}
