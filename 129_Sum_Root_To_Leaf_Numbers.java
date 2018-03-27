// https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
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
    public int calc(TreeNode root,int num){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return num*10+root.val;
        }else{
            return calc(root.left,num*10+root.val)+calc(root.right,num*10+root.val);
        }
    }
    public int sumNumbers(TreeNode root) {
        return calc(root,0);
    }
}
