// ref : https://youtu.be/t5amQL_LJjo

class Solution{
    int maxDistance(int a[], int n){
        if (n == 1) {
            return 0;
        }
        int leftMovingPointer = 0;
        int rightMovingPointer = 0;
        int maxDistance = 0;
        for (int i = 1; i < n;) {
            while (leftMovingPointer - 1 >= 0 && a[leftMovingPointer] <= a[leftMovingPointer - 1]) {
                leftMovingPointer--;
            }
            while (rightMovingPointer + 1 < n && a[rightMovingPointer] <= a[rightMovingPointer + 1]) {
                rightMovingPointer++;
            }
            maxDistance = Math.max(maxDistance, rightMovingPointer - leftMovingPointer);
            i = rightMovingPointer + 1;
            rightMovingPointer = i;
            leftMovingPointer = i;
        }
        return maxDistance;
    }
}


// better one

class Solution{
    int maxDistance(int a[], int n){
        if (n == 1) {
            return 0;
        }
        int leftMovingPointer = 0;
        int rightMovingPointer = 0;
        int maxDistance = 0;
        while (rightMovingPointer < n) {
            if (rightMovingPointer + 1 < n && a[rightMovingPointer] <= a[rightMovingPointer + 1]) {
                rightMovingPointer++;
            }
            else if (leftMovingPointer - 1 >= 0 && a[leftMovingPointer] <= a[leftMovingPointer - 1]) {
                leftMovingPointer--;
            }
            else {
                rightMovingPointer++;
                leftMovingPointer = rightMovingPointer;
            }
            maxDistance = Math.max(maxDistance, rightMovingPointer - leftMovingPointer);
        }
        return maxDistance;
    }
}