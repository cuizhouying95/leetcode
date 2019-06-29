package leetcode_interviewed_100;
//Given n non-negative integers representing an elevation map where the width of each bar is 1, 
//compute how much water it is able to trap after raining.
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
public class Trapping_Rain_Water {
	//若要存住水，就要找到每个元素的左右两边比它大的最大元素的较小的一边
    //水桶的短边思想
    //解法一，暴力方法Time complexity: O(n^2)
	public int trap1(int[] height) {
		int ans = 0;
	    int size = height.length;
	    for (int i = 1; i < size - 1; i++) {
	        int max_left = 0, max_right = 0;
	        for (int j = i; j >= 0; j--) { //Search the left part for max bar size
	            max_left = Math.max(max_left, height[j]);
	        }
	        for (int j = i; j < size; j++) { //Search the right part for max bar size
	            max_right = Math.max(max_right, height[j]);
	        }
	        ans += Math.min(max_left, max_right) - height[i];
	    }
	    return ans; 
    }
	//解法二
	public int trap2(int[] height) {
		if(height == null)
			return 0;
	    int ans = 0;
	    int size = height.length;
	    int[] left_max=new int[size];
	    int[] right_max=new int[size];
	    left_max[0] = height[0];
	    for (int i = 1; i < size; i++) {
	        left_max[i] = Math.max(height[i], left_max[i - 1]);
	    }
	    right_max[size - 1] = height[size - 1];
	    for (int i = size - 2; i >= 0; i--) {
	        right_max[i] = Math.max(height[i], right_max[i + 1]);
	    }
	    for (int i = 1; i < size - 1; i++) {
	        ans += Math.min(left_max[i], right_max[i]) - height[i];
	    }
	    return ans;
	}
	//解法三
	public int trap3(int[] height) {
		int left = 0; 
		int right = height.length - 1;
	    int ans = 0;
	    int left_max = 0; 
	    int right_max = 0;
	    while (left < right) {
	        if (height[left] < height[right]) {
	            if(height[left] >= left_max ) {
	            	left_max = height[left]; 
	            }else {
	             ans += (left_max - height[left]);
	            }
	            ++left;
	        }
	        else {
	            if(height[right] >= right_max ) 
	             {
	            	 right_max = height[right]; 
	            	}else {
	                   ans += (right_max - height[right]);
	            	}
	            --right;
	        }
	    }
	    return ans;
	}
}
