You have been given a string s, which is supposed to be a sentence. However, someone forgot to put spaces between the different words, and for some reason they capitalized the first letter of every word. Return the sentence after making the following amendments:

Put a single space between the words.
Convert the uppercase letters to lowercase.
Example

For s = "CodesignalIsAwesome", the output should be
amendTheSentence(s) = "codesignal is awesome";
For s = "Hello", the output should be
amendTheSentence(s) = "hello".


Solution:

def amendTheSentence(s):
    s = list(s)
    
    if s[0].isupper():
        s[0] = s[0].lower()
        
    for i in range(1, len(s)):
        if s[i].isupper():
            s[i] = ' ' + s[i].lower()
            
    return ''.join(s)

