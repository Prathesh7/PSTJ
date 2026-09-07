import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        int[] map = new int[26];
        int[] reverseMap = new int[26];

        Arrays.fill(map, -1);
        Arrays.fill(reverseMap, -1);

        for (int i = 0; i < pattern.length(); i++) {
            int p = pattern.charAt(i) - 'a';
            int w = word.charAt(i) - 'a';

            if (map[p] == -1 && reverseMap[w] == -1) {
                map[p] = w;
                reverseMap[w] = p;
            } else if (map[p] != w || reverseMap[w] != p) {
                return false;
            }
        }

        return true;
    }
}

OUTPUT:
Input:
words = ["abc","deq","mee","aqq","dkd","ccc"]
pattern = "abb"

Output:
["mee","aqq"]

Expected:
["mee","aqq"]

Status: Correct 
