import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {

        // Convert integers to strings
        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom comparator
        Arrays.sort(arr, (a, b) -> {
            String ab = a + b;
            String ba = b + a;

            return ba.compareTo(ab);
        });

        // If the largest number is "0", return "0"
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build result
        StringBuilder result = new StringBuilder();

        for (String str : arr) {
            result.append(str);
        }

        return result.toString();
    }
}

OUTPUT:
Input:
nums = [10, 2]

Output:
"210"

Expected:
"210"
