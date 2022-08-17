International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:

'a' maps to ".-",
'b' maps to "-...",
'c' maps to "-.-.", and so on.
For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
Return the number of different transformations among all words we have.

 

Example 1:

Input: words = ["gin","zen","gig","msg"]
Output: 2
Explanation: The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."
There are 2 different transformations: "--...-." and "--...--.".
Example 2:

Input: words = ["a"]
Output: 1
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 12
words[i] consists of lowercase English letters.



class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        // create a map with the alphabet and the mapping
        Map<Character, String> morseCode = new HashMap<>();
        morseCode.put('a', ".-");
        morseCode.put('b', "-...");
        morseCode.put('c',"-.-.");
        morseCode.put('d',"-..");
        morseCode.put('e',".");
        morseCode.put('f',"..-.");
        morseCode.put('g',"--.");
        morseCode.put('h',"....");
        morseCode.put('i',"..");
        morseCode.put('j',".---");
        morseCode.put('k',"-.-");
        morseCode.put('l',".-..");
        morseCode.put('m',"--");
        morseCode.put('n',"-.");
        morseCode.put('o',"---");
        morseCode.put('p',".--.");
        morseCode.put('q',"--.-");
        morseCode.put('r',".-.");
        morseCode.put('s',"...");
        morseCode.put('t',"-");
        morseCode.put('u',"..-");
        morseCode.put('v',"...-");
        morseCode.put('w',".--");
        morseCode.put('x',"-..-");
        morseCode.put('y',"-.--");
        morseCode.put('z',"--..");
        // now we have the mapping and now we can go through each of the string and based on each character we can append the appropriate code using a stringbuilder and store it inside the hashset
        Set<String> set = new HashSet<>();
        for (String s: words) {
            StringBuilder sb = new StringBuilder();
            for (char ch: s.toCharArray()) {
                String code = morseCode.get(ch);
                sb.append(code);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}