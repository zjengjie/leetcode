/*
 * @lc app=leetcode id=13 lang=c
 *
 * [13] Roman to Integer
 */

int vars[13] = {0, 0, 5, 1, 10, 0, 50, 1000, 0, 0, 0, 100, 500};

int getVal(char c)
{
    return vars[c % 14];
}

int romanToInt(char *s)
{
    int len = sizeof(s) / sizeof(s[0]);
    if (len == 1)
    {
        return getVal(s[0]);
    }
    int result = 0;
    for (int i = 0; i < len - 1; i++)
    {
        if (getVal(s[i + 1]) > getVal(s[i]))
        {
            result -= getVal(s[i]);
        }
        else
        {
            result += getVal(s[i]);
        }
    }
    return result + getVal(s[len - 1]);
}
