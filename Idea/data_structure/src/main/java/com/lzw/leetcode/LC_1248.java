package com.lzw.leetcode;


/**
 * @author a5071
 * @since 2022/2/7 12:07
 * description 给你一个整数数组nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中 「优美子数组」 的数目。
 * 示例 1：
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 */
public class LC_1248{
    public static void main(String[] args){
        LC_1248 lc_1248 = new LC_1248();
        int[] nums = new int[]{2, 1, 2, 1, 1, 1, 2};
        System.out.println("滑动窗口：" + lc_1248.numberOfSubarrays01(nums, 3));
        System.out.println("前缀和：" + lc_1248.numberOfSubarrays02(nums, 3));

    }

    // 方法一：滑动窗口
    public int numberOfSubarrays01(int[] nums, int k){
        int left = 0, right = 0, oddCnt = 0, res = 0;
        while (right < nums.length) {
            // 右指针先走，每遇到一个奇数则oddCnt++
            if ((nums[right++] & 1) == 1) {
                oddCnt++;
            }
            // 若当前滑动窗口[left, right)中有k个奇数，进入此分支统计当前滑动窗口中的优美子数组个数。
            if (oddCnt == k) {
                int tmp = right;
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }
                int rightEventCnt = right - tmp;
                int leftEventCnt = 0;
                while ((nums[left] & 1) == 0) {
                    leftEventCnt++;
                    left++;
                }
                res += (leftEventCnt + 1) * (rightEventCnt + 1);
                left++;
                oddCnt--;
            }
        }
        return res;
    }

    // 方法二：前缀和
    public int numberOfSubarrays02(int[] nums, int k){
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int odd = 0, ans = 0;
        cnt[0] = 1;
        for (int i = 0; i < n; i++) {
            odd += nums[i] & 1;
            ans += odd >= k ? cnt[odd - k] : 0;
            cnt[odd] += 1;
        }
        return ans;
    }

}
