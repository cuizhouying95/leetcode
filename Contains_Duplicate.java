package leetcode_interviewed_100;
import java.util.Set;
import java.util.HashSet;
public class Contains_Duplicate {
	public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>(nums.length);
        for(int x: nums){
            if(set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}
