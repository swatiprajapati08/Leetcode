//Find Leaves Of Binary Tree - (Google Onsite-2022, Amazon)
//https://leetcode.com/problems/find-leaves-of-binary-tree/


private Map<Integer, List<Integer>> mp = new HashMap<>();
    private int heightOfTree(TreeNode root){
        if(root == null) return 0;
        int h = 1 + Math.max(heightOfTree(root.left),heightOfTree(root.right));

        List<Integer> ans = null;
        if(mp.containsKey(h)){
          ans = mp.get(h);
        }else{
            ans = new ArrayList<>();
        }
        ans.add(root.val);
        mp.put(h,ans);

        return h;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        mp.clear();
        heightOfTree(root);

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> nodes : mp.values()) {
            result.add(nodes);
        }
        return result;
    }
