class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(toDays(date1) - toDays(date2));
    }

    private int toDays(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int total = 0;

        for (int y = 1971; y < year; y++) {
            total += isLeapYear(y) ? 366 : 365;
        }

        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        for (int m = 1; m < month; m++) {
            total += days[m - 1];
        }

        if (month > 2 && isLeapYear(year)) {
            total++;
        }

        total += day;

        return total;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 ||
               (year % 4 == 0 && year % 100 != 0);
    }
}
OUTPUT:
Testcase
Test Result

Accepted
Runtime: 0 ms

Case 1
Case 2

Input:
date1 =
"2019-06-29"

date2 =
"2019-06-30"

Output:
1

Expected:
1
