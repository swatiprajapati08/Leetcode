// https://leetcode.com/problems/delete-leaves-with-a-given-value/

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return root;

        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);

        if(root.val == target && root.left == null && root.right == null) return null;
        // we can delete the node if it is leaf
        else return root;
        
    }
}
