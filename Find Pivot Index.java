class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        
        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Find pivot index
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}

output:
Accepted
Runtime: 0 ms

Case 1

Case 2

Case 3

Input
nums =
[1,7,3,6,5,6]

Output
3

Expected
3
