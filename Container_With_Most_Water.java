package leetcode_interviewed_100;

public class Container_With_Most_Water {
 public int maxArea(int[] height) {   
        int maxarea=0;
        int l=0;
        int r=height.length-1;
        while(l<r){
            maxarea=Math.max(maxarea,Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r]){//长度较短的一方移动，因为最大面积取决于短的一方的长度
                l++;
            }else{
                r--;
            }
        }
        return maxarea;
    }
}
