class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int mask = Integer.MAX_VALUE, diff = (right - left);
        int k = (int)(Math.log(diff) / Math.log(2));
        if (diff > 0)
            mask = mask << (k + 1);
        return (left & right & mask);
}
}
