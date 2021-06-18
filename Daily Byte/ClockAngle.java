/*
Given the hours and the minutes on an analog clock, return the angle formed between the two hands.
Note: Return the smaller of the two angles formed.

Ex: Given the following hours and minutes...

hours = 12, minutes = 0, return 0 (the hands are on top of each other).
Ex: Given the following hours and minutes...

hours = 3, minutes = 25, return 47.5.*/


class Solution {
    static int getAngle(int h , int m) {
        // code here
        if (m == 60)
            m = 0;
        float hourAngle = (float)((30 * h) + (0.5 * m));
        float minuteAngle = (float)(6 * m);
        float angle1 = Math.abs(hourAngle - minuteAngle);
        float angle2 = 360 - angle1;
        return angle1 < angle2 ? (int) angle1 : (int) angle2;
    }
}