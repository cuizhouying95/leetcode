package leetcode_interviewed_100;

public class Product_of_Array_Except_Self {
	//�ⷨһ��ʹ�ó���
	public int[] productExceptSelf(int[] nums) {
		if(nums==null||nums.length<2){
	          return null;
	      }  
	        int count=0;//0�ĸ���
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
	//�ⷨ����һ��λ���ϳ�ȥ�Լ����۳ˣ������Լ���ߵ��۳��ٳ��Լ��ұߵ��۳�
	//����res���飬��ʡ�ռ�
	public int[] productExceptSelf2(int[] nums) {
		if(nums==null||nums.length<2){
	          return null;
	      } 
		int[] res=new int[nums.length];
		res[0]=nums[0];
		 for(int i=1;i!=nums.length;i++) {
			 res[i]=res[i-1]*nums[i];//nums[0..i]���۳�
		 }
		int tmp=0;
		for(int i=nums.length-1;i>0;i--) {
			res[i]=res[i-1]*tmp;
			tmp*=nums[i];
		}
		res[0]=tmp;//ͷβλ������
		return res;
	}
}
