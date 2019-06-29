package leetcode_interviewed_100;
//Design an algorithm to find the maximum profit. You may complete at most two transactions.
public class Best_Time_to_Buy_and_Sell_Stock3 {
	public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2){
            return 0;
        }
        int n=prices.length;
        int[] preProfit=new int[n];//��i��֮ǰ����һ�ν��׵��������preProfit[i]
        int[] posProfit=new int[n];//��i��֮�����һ�ν��׵��������preProfit[i]
         
        int curMin=prices[0];
        for(int i=1;i<n;i++){
            curMin = Math.min(curMin, prices[i]);
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
        }
        
        int curMax=prices[n-1];
        for(int i=n-2;i>=0;i--){
            curMax=Math.max(curMax, prices[i]);
            posProfit[i] = Math.max(posProfit[i+1],  curMax-prices[i]);
        }
        int maxProfit=0;
        for(int i=0;i<n;i++){
            maxProfit=Math.max(maxProfit,preProfit[i]+posProfit[i]);
        }
        return maxProfit;
    }
}
