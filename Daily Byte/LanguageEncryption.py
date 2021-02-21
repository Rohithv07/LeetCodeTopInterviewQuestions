"""
Your friend has created a secret encrypted language by shifting letters around in the English alphabet. Given the new order of the letters and a list of words, return whether or not your friend has sorted the words lexicographically.

Ex: Given the following order and words...

order = "worldabcefghijkmnpqstuvxyz"
words = ["word","world","row"]
return false since ‘d’ comes before ‘l’ in the new language’s ordering and therefore the first and second word are not sorted correctly.
"""



# Function to check whether Words are sorted in given Order 
def isAlienSorted(Words, Order): 
    Order_index = {c: i for i, c in enumerate(Order)} 
  
    for i in range(len(Words) - 1): 
        word1 = Words[i] 
        word2 = Words[i + 1] 
  
        # Find the first difference word1[k] != word2[k]. 
        for k in range(min(len(word1), len(word2))): 
  
            # If they compare false then it's not sorted. 
            if word1[k] != word2[k]: 
                if Order_index[word1[k]] > Order_index[word2[k]]: 
                    return False
                break
        else: 
  
            # If we didn't find a first difference, the 
            # Words are like ("add", "addition"). 
            if len(word1) > len(word2): 
                return False
  
    return True
  
  
# Program Code 
Words1 = ["hello", "leetcode"] 
Order1 = "habcldefgijkmnopqrstuvwxyz"
  
# Function call to print required answer 
print(isAlienSorted(Words1, Order1))

Words2 = ["word","world","row"]
Order2 = "worldabcefghijkmnpqstuvxyz" 
print(isAlienSorted(Words2, Order2))