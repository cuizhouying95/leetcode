package leetcode_interviewed_100;
import java.util.Arrays;
//Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
public class Perfect_Squares {

	public int numSquares(int n) {
        int[]dp=new int[n+1];//���е�����ƽ���������Կ���һ����ͨ������һ������ƽ����
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=0;i*i<=n;i++){
            dp[i*i]=1;
        }
        for(int i=1;i<=n;i++){//ѡ��һ����
            for(int j=1;i+j*j<=n;j++){//ѡ����һ����
                dp[i+j*j]=Math.min(dp[i]+1,dp[i+j*j]);
            }
        }
        return dp[n];
    }
}
