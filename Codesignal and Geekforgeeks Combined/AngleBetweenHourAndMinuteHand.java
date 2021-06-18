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
