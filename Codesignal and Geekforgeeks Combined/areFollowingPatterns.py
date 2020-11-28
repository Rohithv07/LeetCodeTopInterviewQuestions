Given an array strings, determine whether it follows the sequence given in the patterns array. In other words, there should be no i and j for which strings[i] = strings[j] and patterns[i] ≠ patterns[j] or for which strings[i] ≠ strings[j] and patterns[i] = patterns[j].

Example

For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the output should be
areFollowingPatterns(strings, patterns) = true;
For strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], the output should be
areFollowingPatterns(strings, patterns) = false.


Solution:

def areFollowingPatterns(strings, patterns):
    
    if len(strings) != len(patterns):
        return False
    
    d = {}
    
    
    for i in range(0, len(strings)):
        if patterns[i] not in d:
            if strings[i] not in d.values():
                d[patterns[i]] = strings[i]
            else:
                return False
        else:
            if d[patterns[i]] != strings[i]:
                return False
    
    return True
            
    

