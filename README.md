# LeetCode-Practice
Practice [**LeetCode**](https://leetcode.com) at regular intervals.

[**LeetCode**](https://leetcode.com) 上习题的定期练习和解析。

> 除非特别说明，否则解题的方式皆通过 **`Java`** 代码实现。

### 题一：[ Two Sum](https://leetcode-cn.com/problems/two-sum)

给定一个整数数组 `nums` 和一个目标值 `target`，请你在该数组中找出和为目标值的那 **两个** 整数，并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例如下：

```
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```

#### 方法一：常见的暴力解法

即遍历每个元素 `m`，并查找是否存在一个值与 `target - m` 相等的目标元素。

```java
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[] { i, j };
            }
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
```

时间和空间复杂度：

- 时间复杂度：O(n^2)
- 空间复杂度：O(1)

#### 方法二：高效解法

如果你对 HashMap 比较了解，应该可以猜到我们比较高效的实现方式了，没错，就是通过 HashMap 本身的特性，可以将我们的遍历操作缩减为一层。如果你对 HashMap 不是很了解，可以参考：[HashMap 的实现原理](https://github.com/Moosphan/Android-Daily-Interview/issues/16)。

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // avoid empty situation
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        final HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            Integer leftIndices = map.get(target - nums[i]);
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
```

原理就是在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，那我们已经找到了对应解，并立即将其返回；不存在则继续插入操作。





