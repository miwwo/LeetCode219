import java.util.HashSet;
import java.util.Set;

// Given an integer array nums and an integer k,
// return true if there are two distinct indices i and j in the array such that
// nums[i] == nums[j] and abs(i - j) <= k.
class Solution {
    public static boolean containsNearbyDuplicate_NoHashMap(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            while (j - i <= k && j != nums.length){
               if (nums[i] == nums[j])
                   return true;
               j++;
            }
        }
        return false;
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) return true;
            if (i >= k) set.remove(nums[i - k]);
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(Solution.containsNearbyDuplicate(nums,k));

        int[] nums_1 = {1,2,3,1,2,3};
        int k_1 = 2;
        System.out.println(Solution.containsNearbyDuplicate(nums_1,k_1));
    }
}