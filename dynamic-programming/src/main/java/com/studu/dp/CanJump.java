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
        int[] nums = {3, 2, 1, 1, 3, 4};
        System.out.println(canJump(nums));
        System.out.println(canJumpDP(nums));
        System.out.println(canJumpDP2(nums));
        System.out.println(canJumpGreedy(nums));
    }

    /**
     * 动态规划法
     */
    enum Index {
        UNKNOWN, GOOD, BAD;
    }

    public boolean canJumpFromPositionDP(int position, int[] nums, Index[] indexes) {

        if (indexes[position] != Index.UNKNOWN) {
            return indexes[position] == Index.GOOD;
        }

        if (position == nums.length - 1 || nums[position] >= nums.length - position) {
            indexes[position] = Index.GOOD;
            return true;
        }

        int furthestPosition = position + nums[position];

        for (int i = position + 1; i <= furthestPosition; i++) {
            if (canJumpFromPositionDP(i, nums, indexes)) {
                indexes[position] = Index.GOOD;
                return true;
            }
        }

        indexes[position] = Index.BAD;
        return false;
    }

    public boolean canJumpDP(int[] nums) {
        Index[] indexes = new Index[nums.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = Index.UNKNOWN;
        }

        indexes[nums.length - 1] = Index.GOOD;
        return canJumpFromPositionDP(0, nums, indexes);
    }


    public boolean canJumpDP2(int[] nums) {
        Index[] indexes = new Index[nums.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = Index.UNKNOWN;
        }

        indexes[nums.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0 ; i--) {
            int furthestPosition = Math.min(nums.length - 1, i + nums[i]);
            for (int j = i + 1; j <= furthestPosition; j++) {
                if (indexes[j] == Index.GOOD) {
                    indexes[i] = Index.GOOD;
                    break;
                }
            }
        }

        return indexes[0] == Index.GOOD;
    }

    /**
     * 贪心算法
     * 3, 2, 1, 1, 4
     */
    public boolean canJumpGreedy(int[] nums) {
        int lastPosition = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= lastPosition - i) {
                lastPosition = i;
            }
        }

        return lastPosition == 0;
    }

}
