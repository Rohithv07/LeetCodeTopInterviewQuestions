You have a sorted array of integers. Write a function that returns a sorted array containing the squares of those integers.

Example

For array = [-6, -4, 1, 2, 3, 5], the output should be
sortedSquaredArray(array) = [1, 4, 9, 16, 25, 36].

The array of squared integers from array is: [36, 16, 1, 4, 9, 25]. When sorted, it becomes: [1, 4, 9, 16, 25, 36].

Solution:

int[] sortedSquaredArray(int[] array) {
    int [] output_array = new int [array.length];
    int left = 0, right = array.length - 1;
    for(int j = output_array.length - 1; j >= 0; j--) {
        if (Math.abs(array[left]) > Math.abs(array[right])){
            output_array[j] = array[left] * array[left];
            left ++;
        }
        else {
            output_array[j] = array[right] * array[right];
            right --;
        }
    }
    return output_array;
}
