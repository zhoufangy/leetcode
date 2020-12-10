//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果 可以变为 1，那么这个数就是快乐数。 
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。 
//
// 
//
// 示例： 
//
// 输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
// Related Topics 哈希表 数学 
// 👍 495 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class HappyNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    //方案1：快慢指针 时间:O(logn) 空间O(1)
    /*class Solution {
        public boolean isHappy(int n) {
            int slow = n;
            int fast = getNext(slow);

            while (slow!=1&& fast!=slow){
                slow = getNext(slow);
                fast = getNext(getNext(fast));
            }
            return fast==1;
        }
        public int getNext(int n){
            int sum = 0;
            while (n>0){
                int num = n%10;
                sum += Math.pow(num,2);
                n = n/10;
            }
            return sum;
        }
    }*/

    //方案二 Set判重 时间:O(logn) 空间:O(logn)
    class Solution {
        Set mark = new HashSet();
        public Boolean isHappy(int n) {
            int sum = 0;
            while (n>0){
                int num = n%10;
                sum += Math.pow(num,2);
                n = n/10;
            }
            if (sum == 1) {
                return true;
            }
            if (mark.contains(sum)) {
                return false;
            }
            mark.add(sum);
            return isHappy(sum);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        System.out.println(solution.isHappy(19));
    }
}