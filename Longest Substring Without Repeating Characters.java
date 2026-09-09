class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];
        int left = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (lastIndex[c] > left) {
                left = lastIndex[c];
            }

            lastIndex[c] = i + 1;

            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }
}

OUTPUT:
Input:
s = "abcabcbb"

Output:
3

Expected:
3

Status: Correct 
