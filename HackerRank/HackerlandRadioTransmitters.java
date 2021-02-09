https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem


public class Solution {

    // Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {
        /*
        always place the transmitter at the house furthest to the right possible 
        to cover the range.
        */
        Arrays.sort(x);
        int count = 0;
        int index = 0;
        while (index < x.length) {
            count += 1;
            int loc = x[index] + k; //let this i be i_orig
        //go to right as far as we cover i_orig as well.
            while (index < x.length && x[index] <= loc)
                index += 1;
            loc = x[--index] + k; //now go to the right of x[i] by k because transmitter at x[i] covers houses to its right as well. 
            while (index < x.length && x[index] <= loc)
                index += 1;
        }
        return count;
    }
