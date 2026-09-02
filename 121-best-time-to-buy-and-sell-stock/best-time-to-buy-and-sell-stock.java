class Solution {
    public int maxProfit(int[] prices) {
        int minprice=prices[0];
        int profit=0;
        for(int price:prices){
            if(price<minprice){
                minprice=price;
            }
            profit=Math.max(profit,price-minprice);
        }
        return profit;
    }
}