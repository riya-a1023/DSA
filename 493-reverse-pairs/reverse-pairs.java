class Solution {
    public int reversePairs(int[] nums) {
        return sort(nums,0,nums.length-1);
    }
    int sort(int[]a,int l,int r){
        if(l>=r)
        return 0;
        int m=(l+r)/2;
        int count=sort(a,l,m)+sort(a,m+1,r);
        int j=m+1;
        for(int i=l;i<=m;i++){
            while(j<=r && (long)a[i]>2L*a[j])
            j++;
            count+=j-(m+1);
        }
        int temp[]=new int[r-l+1];
        int i=l;
        int k=0;
         j=m+1;
        while(i<=m&&j<=r)
        temp[k++]=a[i]<=a[j] ? a[i++] : a[j++];
        while(i<=m)
        temp[k++]=a[i++];
        while(j<=r)  
        temp[k++]=a[j++];
        for( i=0;i<temp.length;i++)
        a[l+i]=temp[i]; 
       return count;
        }
}
