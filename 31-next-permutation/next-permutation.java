class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // 1. Find decreasing element
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;

        // 2. Find bigger element and swap
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // 3. Reverse remaining part
        int l = i + 1, r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
}