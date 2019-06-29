package leetcode_interviewed_100;

public class Product_of_Array_Except_Self {
	//解法一，使用除法
	public int[] productExceptSelf(int[] nums) {
		if(nums==null||nums.length<2){
	          return null;
	      }  
	        int count=0;//0的个数
	        int all=1;
	        for(int i=0;i!=nums.length;i++){
	            if(nums[i]!=0){
	                all*=nums[i];
	            }else{
	                count++;
	            }
	        }
	        int[] res=new int[nums.length];
	        if(count==0){
	            for(int i=0;i!=nums.length;i++){
	                res[i]=all/nums[i];
	            }
	        }
	        if(count==1){
	            for(int i=0;i!=nums.length;i++){
	                if(nums[i]==0){
	                    res[i]=all;
	                }
	            }
	        }
	        return res;
	    }
	//解法二，一个位置上除去自己的累乘，等于自己左边的累乘再乘自己右边的累乘
	//复用res数组，节省空间
	public int[] productExceptSelf2(int[] nums) {
		if(nums==null||nums.length<2){
	          return null;
	      } 
		int[] res=new int[nums.length];
		res[0]=nums[0];
		 for(int i=1;i!=nums.length;i++) {
			 res[i]=res[i-1]*nums[i];//nums[0..i]的累乘
		 }
		int tmp=0;
		for(int i=nums.length-1;i>0;i--) {
			res[i]=res[i-1]*tmp;
			tmp*=nums[i];
		}
		res[0]=tmp;//头尾位置特殊
		return res;
	}
}
