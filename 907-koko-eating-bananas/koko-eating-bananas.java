class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;int r=0;
        for(int x:piles)
        r=Math.max(r,x);
        while(l<=r){
            int mid=l+(r-l)/2;
            long hours=0;
            for(int x:piles)
            hours+=(x+(long)mid-1)/mid;
            if(hours<=h)
            r=mid-1;
            else
            l=mid+1;
        }
        return l;
    }
}