package leetcode_interviewed_100;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>(); 
        
        if(nums==null||nums.length<3) {
			return res;
		}
		for(int i=0;i<nums.length-2;i++) {
			if(i==0||nums[i-1]!=nums[i]) {
				printRest(nums,i,i+1,nums.length-1,-nums[i],res);
			}
		}
        return res;
    }
    
    public static void printRest(int[]arr,int f,int left,int right,int k,List<List<Integer>> res) {
		List<Integer> list=new LinkedList<>(); 
        while(left<right) {
			if(arr[left]+arr[right]<k) {
				left++;
			}else if(arr[left]+arr[right]>k) {
				right--;
			}else {
				if(left==f+1||arr[left-1]!=arr[left]) {//∑¿÷π÷ÿ∏¥¥Ú”°
					list.add(arr[f]);
                    list.add(arr[left]);
                    list.add(arr[right]);
                    res.add(list);
                    list=new LinkedList<>(); 
				}
				left++;
				right--;
			}
		}
	}
}
