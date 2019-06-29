package leetcode_interviewed_100;
//Design an algorithm to find the maximum profit. You may complete at most k transactions.
public class Best_Time_to_Buy_and_Sell_Stock4 {
	public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) return 0;
        
        int days = prices.length;
        if (k >= days) return maxProfit2(prices);
        
        int[][] local = new int[days][k + 1];//local[i][j]为在到达第i天时最多可进行j次交易并且最后一次交易在当天卖出的最大利润
        int[][] global = new int[days][k + 1];//global[i][j]为在到达第i天时最多可进行j次交易的最大利润
        for (int i = 1; i < days ; i++) {
            int diff = prices[i] - prices[i - 1];
            
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
             }
        }
        
        return global[days - 1][k];
    }
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        
        return maxProfit;
    }
}
