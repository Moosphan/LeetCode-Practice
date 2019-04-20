package problem_1;

import java.util.HashMap;

/***
 * written by Moosphon
 * @date 2019/04/20
 * @problem Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 */
public class TwoValueSumTest {

    /**
     * @param nums    numbers array
     * @param target  specific target
     * @return        indices of two numbers
     * ----------------------------------------------------------------------------
     * for example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     */
    public int[] getIndicesOfTwoNumbers(int[] nums, int target){
        // avoid empty situation
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        final HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            Integer leftNumber = target - nums[i];
            Integer leftIndices = map.get(leftNumber);
            if (leftIndices == null) {
                // if another num not exit, put current num and indices into the map.
                map.put(nums[i], i);
            }else {
                // if another num has exit, return it's indices and current number's indices.
                return new int[]{leftIndices, i};
            }
        }
        return new int[]{};
    }
}
