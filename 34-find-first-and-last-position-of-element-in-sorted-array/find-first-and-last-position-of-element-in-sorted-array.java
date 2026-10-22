class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=find(nums,target,true);
        int last=find(nums,target,false);
        return new int[]{first,last};
    }
    public int find(int[]nums, int target,boolean first){
        int l=0;int r=nums.length-1;int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                ans=mid;
                if(first){
                    r=mid-1;
                }
                else{ l=mid+1;}
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{r=mid-1;}
        }
        return ans;
    }
}