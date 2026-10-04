class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        byte[][] memo = new byte[n + 1][n + 1];
        return dfs(s, 0, 0, memo);
    }

    private boolean dfs(String s, int index, int balance, byte[][] memo) {
        if (balance < 0)
            return false;
        if (index == s.length())
            return balance == 0;

        if (memo[index][balance] != 0) {
            return memo[index][balance] == 1;
        }

        boolean valid;
        char ch = s.charAt(index);

        if (ch == '(') {
            valid = dfs(s, index + 1, balance + 1, memo);
        } else if (ch == ')') {
            valid = dfs(s, index + 1, balance - 1, memo);
        } else {
            valid = dfs(s, index + 1, balance, memo)
                    || dfs(s, index + 1, balance + 1, memo)
                    || dfs(s, index + 1, balance - 1, memo);
        }

        memo[index][balance] = (byte) (valid ? 1 : -1);
        return valid;
    }
}