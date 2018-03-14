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
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(root.val<key){
            root.right = deleteNode(root.right,key);
        }else if(root.val>key){
            root.left = deleteNode(root.left,key);
        }else{//find the key
            if(root.left==null){
                return root.right;  //左子树为null，直接返回右子树
            }else if(root.right==null){
                return root.left;   //同理
            }
            
            TreeNode temp = root.right;
            while(temp.left!=null){//找出右子树最小值
                temp = temp.left;
            }
            root.val=temp.val;//赋值给当前root
            root.right = deleteNode(root.right,root.val);//递归把右子树中的最小值删掉并返回右子树
                
        }
        return root;
    }
}
