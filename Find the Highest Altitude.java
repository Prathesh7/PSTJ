class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int highest = 0;

        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];
            highest = Math.max(highest, altitude);
        }

        return highest;
    }
}
OUTPUT:
TEST RESULT

Status: Accepted
Runtime: 0 ms

Case 1: Passed
Case 2: Passed

Input:
gain = [-5, 1, 5, 0, -7]

Output:
1

Expected:
1
