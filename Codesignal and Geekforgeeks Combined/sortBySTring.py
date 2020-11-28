Sort the letters in the string s by the order they occur in the string t.

Example

For s = "weather" and t = "therapyw", the output should be
sortByString(s, t) = "theeraw";

For s = "good" and t = "odg", the output should be
sortByString(s, t) = "oodg".

Solution:

def sortByString(s, t):
    dictionary = {}
    final_string = ""
   
    for elements in s:
        if elements not in dictionary:
           dictionary[elements] = 1
        else:
            dictionary[elements] = dictionary[elements] + 1
            
    for letter in t:
        if letter in dictionary:
            count = dictionary[letter]
            final_string = final_string + count * letter
    
    return final_string
    
    
