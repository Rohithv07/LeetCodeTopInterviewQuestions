import java.util.*;
import java.io.*;


public class ChefAndMeeting {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String meetingTime = sc.next();
			String meetingAMPM = sc.next();
			String [] time1 = meetingTime.split(":");
			String t1 = (time1[0]);
			String t2 = (time1[1]);
			int t11 = Integer.parseInt(t1);
			if (t1.equals("12") && meetingAMPM.equals("AM")) {
				t1 = "0";
			}
			else if (t11 < 12 && meetingAMPM.equals("PM")) {
				int temp = Integer.parseInt(t1);
				temp += 12;
				t1 = Integer.toString(temp);
			}
			StringBuilder meet = new StringBuilder();
			meet.append(t1);
			meet.append(t2);
			String converted = meet.toString();
			int convertedMeet = Integer.parseInt(converted);
			int n = sc.nextInt();
			for (int i=0; i<n; i++) {
				String startingTime = sc.next();
				String startingAMPM = sc.next();
				String endingTime = sc.next();
				String endingAMPM = sc.next();
				String [] time2 = startingTime.split(":");
				String [] time3 = endingTime.split(":");
				String t3 = (time2[0]);
				String t4 = (time2[1]);
				int t33 = Integer.parseInt(t3);
				if (t3.equals("12") && startingAMPM.equals("AM")) {
					t3 = "0";
				}
				else if (t33 < 12 && startingAMPM.equals("PM")) {
					int temp = Integer.parseInt(t3);
					temp += 12;
					t3 = Integer.toString(temp);
				}
				StringBuilder startConverted = new StringBuilder();
				startConverted.append(t3);
				startConverted.append(t4);
				int convertedStart = Integer.parseInt(startConverted.toString());
				String t5 = (time3[0]);
				String t6 = (time3[1]);
				int t55 = Integer.parseInt(t5);
				if (t5.equals("12") && endingAMPM.equals("AM")) {
					t5 = "0";
				}
				else if (t55 < 12 && endingAMPM.equals("PM")) {
					int temp = Integer.parseInt(t5);
					temp += 12;
					t5 = Integer.toString(temp);
				}
				StringBuilder endConverted = new StringBuilder();
				endConverted.append(t5);
				endConverted.append(t6);
				int convertedEnd = Integer.parseInt(endConverted.toString());
				if ((convertedStart <= convertedMeet) && (convertedMeet <= convertedEnd) && (convertedStart <= convertedEnd))
					System.out.print("1");
				else
					System.out.print("0"); 
			}
			System.out.println();
		}
	}
}
