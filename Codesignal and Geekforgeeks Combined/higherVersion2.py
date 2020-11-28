You have two version strings composed of several non-negative decimal fields that are separated by periods ("."). Both strings contain an equal number of numeric fields. Return 1 if the first version is higher than the second version, -1 if it is smaller, and 0 if the two versions are the same.

The syntax follows the regular semver (semantic versioning) ordering rules:

1.0.5 < 1.1.0 < 1.1.5 < 1.1.10 < 1.2.0 < 1.2.2
< 1.2.10 < 1.10.2 < 2.0.0 < 10.0.0
Example

For ver1 = "1.2.2" and ver2 = "1.2.0", the output should be
higherVersion2(ver1, ver2) = 1;
For ver1 = "1.0.5" and ver2 = "1.1.0", the output should be
higherVersion2(ver1, ver2) = -1;
For ver1 = "1.0.5" and ver2 = "1.00.05", the output should be
higherVersion2(ver1, ver2) = 0.

Solution:

def higherVersion2(ver1, ver2):
    
    ver1 = ver1.split(".")
    ver2 = ver2.split(".")
    
    if ver1 == ver2:
        return 0
    
    for i, j in zip(ver1, ver2):
        if int(i) > int(j):
            return 1
        if int(i) < int(j):
            return -1
        
    return 0
