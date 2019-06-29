package leetcode_interviewed_100;
//Say you have an array for which the ith element is the price of a given stock on day i.

//If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
//design an algorithm to find the maximum profit.

//Note that you cannot sell a stock before you buy one.
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             //Not 7-1 = 6, as selling price needs to be larger than buying price.
public class Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
	
	public int maxProfit2(int[] prices) {
		int profit=0;
		int i=0;
		while(i<prices.length) {
			while(i<prices.length-1&&prices[i+1]<=prices[i]) i++;
			int min=prices[i++];
			while(i<prices.length-1&&prices[i+1]>=prices[i]) i++;
			profit+=i<prices.length?prices[i++]-min:0;
		}
		return profit;
	}
}
