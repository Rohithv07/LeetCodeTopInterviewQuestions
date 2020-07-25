int minDistTriplet(int[] a, int[] b, int[] c) {
    int i = 0, j = 0, k = 0;
    int minimum = 999999;
    while(i < a.length && j < b.length && k < c.length){
        int result = Math.abs(a[i] - b[j]) + Math.abs(b[j] - c[k]) + Math.abs(c[k] - a[i]);
        minimum = Math.min(minimum, result);
        int small = Math.min(a[i], Math.min(b[j], c[k]));
        
        if (small == a[i])
            i++;
        if (small == b[j])
            j++;
        if (small == c[k])
            k++;
    }
    return minimum;
}

