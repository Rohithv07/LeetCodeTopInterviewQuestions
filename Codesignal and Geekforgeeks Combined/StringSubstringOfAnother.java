import java.util.*;

public class StringSubstringOfAnother {


	public static boolean isSubstring(String ss1, String ss2) {
		boolean matched = false;
		int n1=ss1.length(),n2=ss2.length();
		int i=0,j=0;
		char [] s1 = ss1.toCharArray();
		char [] s2 = ss2.toCharArray();
		while(i<n1 && j<n2){
			boolean changed=false; // to check after encountering a * and we found the next identical one
			while(s2[j]=='*' && i<n1 && j+1<n2 && s1[i]!=s2[j+1]){
				i++;
				changed = true;
			}
			if(changed) j++;
			while(s1[i]!=s2[j]) i++;
			while(i<n1 && j<n2 && s1[i]==s2[j]){
				i++;
				j++;
			}
			if(j==n2){
				matched=true;
				break;
			}
		}
		if(matched) return true;
		return false;
		}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(isSubstring(s1, s2));
	}
}