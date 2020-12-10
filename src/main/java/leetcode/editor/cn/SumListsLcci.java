//给定两个用链表表示的整数，每个节点包含一个数位。 
//
// 这些数位是反向存放的，也就是个位排在链表首部。 
//
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢? 
//
// 示例： 
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 链表 数学 
// 👍 40 👎 0

package leetcode.editor.cn;

class SumListsLcci {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //方案1 把链表对应每个节点相加，记录进位 时间复杂度O(N),空间O(1)
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1==null){return l2;}
            if (l2==null){return l1;}
            ListNode res = new ListNode(0);
            ListNode node = res;
            int carry = 0;
            while (l1!=null||l2!=null){
                int sum = (l1!=null?l1.val:0)+ (l2!=null?l2.val:0)+carry;
                carry = sum/10;
                node.next = new ListNode(sum%10);
                node = node.next;

                l1=l1!=null?l1.next:null;
                l2=l2!=null?l2.next:null;
            }
            return res.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new SumListsLcci().new Solution();
        ListNode sum = solution.addTwoNumbers(new SumListsLcci().getListNode1(),new SumListsLcci().getListNode2());
        String res = "";
        while (sum!=null){
            res +=sum.val;
            sum = sum.next;
        }
        System.out.println(res);
    }

    public ListNode getListNode1(){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        return l1;
    }
    public ListNode getListNode2(){
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(4);
        l1.next=l2;
        l2.next=l3;
        return l1;
    }
}