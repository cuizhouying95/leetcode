package leetcode_interviewed_100;
//求子集（数组中有重复的元素）
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
public class Subsets {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}
	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
	        tempList.add(nums[i]);//加入 nums[i]
	        backtrack(list, tempList, nums, i + 1);//递归
	        tempList.remove(tempList.size() - 1);//移除nums[i]
	    }
	} 
	////////
	public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res, temp, nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int j) {
        res.add(new ArrayList<Integer>(temp));
        HashSet<Integer> set = new HashSet<>();
        for(int i = j; i < nums.length; i++) {
            if(i>j&&set.contains(nums[i])) continue; //跳过重复的
            set.add(nums[i]);
            temp.add(nums[i]);  //① 加入 nums[i]
            dfs(res, temp, nums, i + 1);  //② 递归
            temp.remove(temp.size() - 1);  //③ 移除 nums[i]
        }
    }
}
