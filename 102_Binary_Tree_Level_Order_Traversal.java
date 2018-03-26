// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
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
    public void visit(TreeNode root,Queue<TreeNode> queue,List<List<Integer>> ret){
        List<Integer> list = new ArrayList<Integer>();
        int size=1;
        while(!queue.isEmpty()){
            if(size==0){
                size = queue.size();
                list = new ArrayList<Integer>();
            }
            TreeNode temp = queue.poll();
            list.add(temp.val);
            size--;
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
            if(size==0){
                ret.add(list);
            }
        }
        
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        visit(root,queue,ret);
        return ret;
    }
}
