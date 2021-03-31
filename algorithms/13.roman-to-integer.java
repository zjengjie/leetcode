/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */
class Solution {

    private int[] vars = new int[]{0, 0, 5, 1, 10, 0, 50, 1000, 0, 0, 0, 100, 500};

    public int romanToInt(String s) {
        if (s.length() == 1) {
            return getVal(s.charAt(0));
        }
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (getVal(s.charAt(i + 1)) > getVal(s.charAt(i))) {
                result -= getVal(s.charAt(i));
            } else {
                result += getVal(s.charAt(i));
            }
        }
        return result + getVal(s.charAt(s.length() - 1));
    }

    private int getVal(char c) {
        return vars[c % 14];
    }
}

