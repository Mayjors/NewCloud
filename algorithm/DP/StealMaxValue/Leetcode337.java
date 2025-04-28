package algorithm.DP.StealMaxValue;


/*
小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额
    3
   / \
  2   3
   \   \
    3   1
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}
// dp:{不偷该节点， 偷该节点}
public class Leetcode337 {
    public static int[] find(TreeNode node){
        if(node == null) {
            return new int[]{0, 0};
        }
        int[] left = find(node.left);
        int[] right = find(node.right);
        int val1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 不偷该节点，则左右子树可选择偷或不偷
        int val2 = node.val + left[0] + right[0]; // 偷该节点，则左右子树必不偷
        return new int[]{val1, val2};
    }
    public int rob(TreeNode root) {
        int[] val = find(root);
        return Math.max(val[0], val[1]);
    }
}
