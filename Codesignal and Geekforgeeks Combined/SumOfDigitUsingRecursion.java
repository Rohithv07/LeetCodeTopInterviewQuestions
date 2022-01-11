class Solution {
	public int findDigit(int n) {
		if (n <= 0) {
			return 0;
		}
		return findDigit(n / 10) + (n % 10);
	}
}