Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4



class Solution:

	def compareVersion(self, A, B):
	    a = A.split('.')
	    b = B.split('.')
        
	    j =0 
	    for st1 , st2 in zip(a,b):
	        int_a = int(st1) 
	        int_b = int(st2)
	        j=j+1
	        if(int_a == int_b) :
	            continue 
	        elif(int_a>int_b):
	            return 1 
            else :
                return -1 
        if len(a) > len(b):
            int_a = int(a[j])
            int_b  =  0 
            if(int_a == int_b):
                return  0 
            return 1 
        elif len(a) < len(b):
            int_a = 0
            int_b  =  int(b[j])
            if(int_a == int_b):
                return  0
            return -1 
        return 0
