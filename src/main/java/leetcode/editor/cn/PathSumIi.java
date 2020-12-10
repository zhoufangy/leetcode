//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 389 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class PathSumIi {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    //方案1 回溯 时间：O(N) N为二叉树的结点数，空间取决于结果列表的长度
    class Solution {
        List<List<Integer>> pathList = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root ==null){return pathList;}
            preOrder(root,sum,new ArrayList<Integer>());
            return pathList;
        }

        void preOrder(TreeNode node, int num, ArrayList<Integer> list) {
            if(node==null){
                return;
            }
            list.add(node.val);
            num -= node.val;
            if(num==0&& node.left==null&& node.right==null){
                pathList.add(new ArrayList<>(list));
            }else {
                preOrder(node.left,num,list);
                preOrder(node.right,num,list);
            }
            //剪枝
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
        TreeNode root = new PathSumIi().getTreeNode();
        System.out.println(solution.pathSum(root,22));
    }
    public TreeNode getTreeNode() {
        TreeNode root = new TreeNode(5);

        TreeNode l1 = new TreeNode(4);
        TreeNode l2 = new TreeNode(11);
        TreeNode l3 = new TreeNode(7);
        TreeNode l4 = new TreeNode(13);
        TreeNode l5 = new TreeNode(5);

        TreeNode r1 = new TreeNode(8);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(1);

        root.left = l1;
        root.right = r1;
        l1.left = l2;
        l2.left = l3;
        l2.right = r2;
        r1.left = l4;
        r1.right = r3;
        r3.right = r4;
        r3.left = l5;

        return root;
    }
}