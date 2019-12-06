package com.studu.dp;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/jump-game/
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 */
public class CanJump {

    /**
     * 回溯法，一个一个试
     * @param position
     * @param nums
     * @return
     */
    private boolean canJumpFromPosition(int position, int[] nums) {

        if (position == nums.length - 1 || nums[position] >= nums.length - position)
            return true;

        int furthestJump = position + nums[position];

        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 回溯法优化，先跳最长的那步
     * @param position
     * @param nums
     * @return
     */
    private boolean canJumpFromPositionOPT(int position, int[] nums) {

        if (position == nums.length - 1 || nums[position] >= nums.length - position)
            return true;

        int furthestJump = position + nums[position];

        for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {
            if (canJumpFromPositionOPT(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPositionOPT(0, nums);
    }

    @Test
    public void test() {
        int[] nums = {0, 3, 2, 1, 1, 3, 4};
        System.out.println(canJump(nums));
    }

    /**
     * 动态规划法
     */
    enum Index {
        UNKNOWN, GOOD, BAD;
    }



}
