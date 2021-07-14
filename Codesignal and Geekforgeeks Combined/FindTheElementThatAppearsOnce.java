class Sol
{
    public static int search(int a[], int n)
    {
        // your code here
        if (a == null || n == 0)
            return -1;
        int xor = 0;
        for (int number : a) {
            xor ^= number;
        }
        return xor;
        
    }
}

/*
Binary Search solution but showing runtine error but getting accepted the same code in cpp

if (a == null || n == 0)
            return -1;
        if (n == 1)
            return a[0];
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if ((a[middle] != a[middle-1] && a[middle] != a[middle+1]) || (left == right))
                return a[middle];
            if (a[middle] == a[middle - 1] && (middle % 2 != 0) || a[middle] == a[middle + 1] && (middle % 2 == 0))
                left = middle + 1;
            else
                right = middle;
        }
        return -1;
*/
