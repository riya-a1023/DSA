class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int index=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                index++;
                if(index>max){
                    max=index;
                }
            }
            else{
                index=0;
            }
        }
          return max;
    }
}