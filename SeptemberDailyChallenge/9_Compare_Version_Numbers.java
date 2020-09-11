public int compareVersion(String version1, String version2) {
    if (version1 == null || version2 == null) return 0;
    int v1 = 0, v2 = 0;
    int i = 0, j = 0;
    while(i < version1.length() || j < version2.length()) {
        while (i < version1.length() && version1.charAt(i) != '.') {
            v1 = v1*10+(version1.charAt(i)-'0');
            i++;
        }
        while (j < version2.length() && version2.charAt(j) != '.') {
            v2 = v2*10+(version2.charAt(j)-'0');
            j++;
        }
        if (v1 > v2) return 1;
        else if (v1 < v2) return -1;
        i++;
        j++;
        v1 = 0;
        v2 = 0;
    }
    return 0;
}

