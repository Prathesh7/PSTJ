class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        int countA = 0;
        int countB = 0;

        String vowels = "aeiouAEIOU";

        for (int i = 0; i < mid; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                countA++;
            }

            if (vowels.indexOf(s.charAt(i + mid)) != -1) {
                countB++;
            }
        }

        return countA == countB;
    }
}

OUTPUT:
Accepted
Runtime: 0 ms

Case 1
Case 2

Input:
s = "book"

Output:
true

Expected:
true
