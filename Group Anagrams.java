import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];

            for (char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                key.append(count[i]).append('#');
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
OUTPUT:
Testcase > Test Result

Accepted
Runtime: 1 ms

Case 1
Case 2
Case 3

Input:
strs =
["eat","tea","tan","ate","nat","bat"]

Output:
[["bat"],["tan","nat"],["eat","tea","ate"]]

Expected:
[["bat"],["nat","tan"],["ate","eat","tea"]]
