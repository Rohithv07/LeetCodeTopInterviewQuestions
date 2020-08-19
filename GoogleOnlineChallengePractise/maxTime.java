import java.util.*;
public class maxTime {
	public static char [] maxtime(String s) {
		char [] newS = s.toCharArray();
            
		if (newS[0] == '?') 
			newS[0] = (newS[1] <= '3' || newS[1] == '?') ? '2' : '1';

		if (newS[1] == '?') 
            newS[1] = (newS[0] == '2') ? '3' : '9';
		if (newS[3] == '?')
			newS[3] = '5';
		if (newS[4] == '?')
			newS[4] = '9';
		return newS;
	}
	public static void main(String [] args){
		String s1 = "?4:5?";
        String s2 = "?3:??";
		System.out.println(maxtime(s1));
        System.out.println(maxtime(s2));
	}
}
