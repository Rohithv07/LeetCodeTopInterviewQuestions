/*You are given a dataset represented as an integer array, nums that contains values between one and n. Inside the data set, an error has occurred such that one of the values between one and n has been duplicated to another number between one and n. Because of this, one of the values between one and n appears twice and one value does not appear at all. Return the missing value and the values that appears twice.

Ex: Given the following nums…

nums = [1, 3, 2, 5, 5], return [5, 4].
Ex: Given the following nums…

nums = [1, 2, 3, 3], return [3,4].
*/


class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        for (int i=0; i<n; i++) {
            int currentValue = Math.abs(arr[i]);
            if (arr[currentValue - 1] > 0) {
                arr[currentValue - 1] = -arr[currentValue - 1];
            }
            else {
                result[0] = currentValue;
            }
        }
        for (int i=0; i<n; i++) {
            if (arr[i] > 0) {
                result[1] = i + 1;
            }
        }
        return result;
    }
}
