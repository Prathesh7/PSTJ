import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] countP = new int[26];
        int[] countWindow = new int[26];

        // Count characters in p
        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }

        int windowSize = p.length();

        // Sliding window
        for (int i = 0; i < s.length(); i++) {
            countWindow[s.charAt(i) - 'a']++;

            // Keep window size equal to p.length()
            if (i >= windowSize) {
                countWindow[s.charAt(i - windowSize) - 'a']--;
            }

            // Check if current window is an anagram
            if (i >= windowSize - 1 && Arrays.equals(countP, countWindow)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }
}

OUTPUT:
Accepted
Runtime: 0 ms

Case 1
Case 2

Input
s =
"cbaebabacd"
p =
"abc"

Output
[0,6]

Expected
[0,6]
