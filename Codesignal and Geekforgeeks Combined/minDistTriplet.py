def minDistTriplet(a, b, c):
    i, j, k = 0, 0, 0
    minimum = 999999999
    
    while i < len(a) and j < len(b) and k < len(c):
        result = abs(a[i] - b[j]) + abs(b[j] - c[k]) + abs(c[k] - a[i])
        minimum = min(minimum, result)
        m = min(a[i], b[j], c[k])
        
        if m == a[i]:
            i += 1
        if m == b[j]:
            j += 1
        if m == c[k]:
            k += 1
    
    return minimum
