class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int l=0;int r=mat[0].length-1;
        int row=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            for(int i=0;i<mat.length;i++){
                if(mat[i][mid]>mat[row][mid])
                row=i;
            }
            int left=mid>0?mat[row][mid-1]:-1;
            int right=mid<mat[0].length-1?mat[row][mid+1]:-1;
            if(mat[row][mid]>left&& mat[row][mid]>right)
            return new int[]{row,mid};
            else if(right>mat[row][mid])
            l=mid+1;
            else
            r=mid-1;
        }
        return new int[]{-1,-1};
    }
}