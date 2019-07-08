package leetcode_interviewed_100;
//�����������
public class Longest_Increasing_Subsequence {
	public int lengthOfLIS1(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        int max=1;
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            max=Math.max(max,dp[i]);
            }
        }
        return max;
    }
	
	public int lengthOfLIS2(int[] nums) {//���ö��ַ�
		int n=nums.length;
		int[] tails=new int[n];//tails[i]��ʾ����Ϊi+1������������е����һ��Ԫ��
		//����Ԫ��x,���������tails�������е�ֵ����ô������ӵ�tails�ĺ��棬��ʾ����������г��ȼ�1��
		//���tails[i-1]<x<=tails[i],��ô����tails[i]=x
		//tails���鱣������
		int len=0;
		for(int num:nums) {
			int index=binarySearch(tails,len,num);
			tails[index]=num;
			if(index==len) {
				len++;
			}
		}
		return len;
	}
	
	public int binarySearch(int[] tails,int len,int key) {
		int l=0;
		int h=len;
		while(l<h) {
			int mid=l+(h-l)/2;
			if(tails[mid]==key)	{
				return mid;
			}else if(tails[mid]>key) {
				h=mid;
			}else {
				l=mid+1;
			}
		}
		return l;
	}
}
