class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<>();
        long n=1;
        for(int i=0;i<=rowIndex;i++){
            ans.add((int)n);
            n=n*(rowIndex-i)/(i+1);
        }
        return ans;
    }
}