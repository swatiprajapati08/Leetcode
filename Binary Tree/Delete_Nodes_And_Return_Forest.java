/*
 Leetcode Qn Link : https://leetcode.com/problems/delete-nodes-and-return-forest/description/
*/

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> delete = new HashSet<>();
        for (int i : to_delete)
            delete.add(i);

        List<TreeNode> ans = new ArrayList<>();

        delNodes(root, ans, delete);

        // check if root also need to remove or not

        if(!delete.contains(root.val))
        ans.add(root);

        return ans;
    }

     TreeNode delNodes(TreeNode root, List<TreeNode> ans, HashSet<Integer> delete) {
        if (root == null)
            return null;

        // can't go by preorder as if we have to delete other node, we will skip that

        root.left = delNodes(root.left, ans, delete);
        root.right = delNodes(root.right, ans, delete);

        if (delete.contains(root.val)) {
            if (root.left != null) {
                ans.add(root.left);
            }
            if (root.right != null) {
                ans.add(root.right);
            }
            return null; // break the tree
        }else{
            return root; // no need to break the tree
        }
    }
}
