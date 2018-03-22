//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

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
    public void visit(TreeNode root,ArrayList<Integer> list){
        //int[] res = new int[size];
        int i = 0;
        //使用stack存储遍历到的节点
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
            //一直往下遍历，知道到左孩子节点为空
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            //左孩子节点为空之后，往后找，找到上一个节点.如果找到的上一个节点的右孩子节点为空，那么继续往上找，直到找到一个右孩子节点不为空的
            while (!stack.isEmpty() && stack.peek().right == null) {
                node = stack.pop();
                list.add(node.val);
                //res[i++] = node.data;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node.val);
                //res[i++] = node.data;
                //找到了一个右孩子节点不为空的节点，就去遍历他的右孩子节点
                if (node != null) {
                    node = node.right;
                }
            }else{
                node=null;
            }

        }
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        visit(root,list);
        if(k>2*list.get(list))
        for(int i=0;i<list.size();i++){
            int target = k-list.get(i);
            int loc = list.lastIndexOf(target);
            if(loc!=i&&loc>=0){
                return true;
            }
        }
        return false;
    }
}
