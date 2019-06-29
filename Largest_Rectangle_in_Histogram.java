package leetcode_interviewed_100;
import java.util.Stack;
public class Largest_Rectangle_in_Histogram {

	public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0){
            return 0;
        }
        int maxArea=0;
        Stack<Integer> stack=new Stack<Integer>();//单调栈结构
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty()&&heights[i]<=heights[stack.peek()]){
                //i为heights[j]的右边离它最近且比它小的数的位置
                int j=stack.pop();//高度
                int k=stack.isEmpty()?-1:stack.peek();//heights[j]的左边离它最近且比它小的数的位置
                int curArea=(i-k-1)*heights[j];
                maxArea=Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int j=stack.pop();
            int k=stack.isEmpty()?-1:stack.peek();
            int curArea=(heights.length-k-1)*heights[j];
            maxArea=Math.max(maxArea,curArea);
        }
        return maxArea;
    }
	
}
