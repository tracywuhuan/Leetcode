//https://leetcode-cn.com/problems/symmetric-tree/description/
//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetric2(root.left,root.right);
    }
    public boolean isSymmetric2(TreeNode left,TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.val!=right.val){
            return false;
        }
        return isSymmetric2(left.left,right.right) && isSymmetric2(left.right,right.left); //镜像遍历，左.左 右.右 && 左.右 右.左
    }
}
