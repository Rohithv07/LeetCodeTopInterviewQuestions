TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode temp = null;
        // morris traversal
        while (root != null) {
            if (root.left != null) {
                temp = root.left;
                while (temp.right != null && temp.right != root) 
                    temp = temp.right;
                if (temp.right != null) {
                    if (pre != null && pre.val > root.val) {
                        if (first == null) 
                            first = pre;
                        second = root;
                    }
                    pre = root;
                    temp.right = null;
                    root = root.right;
                }
                else {
                    temp.right = root;
                    root = root.left;
                }
            }
            else {
                if (pre != null && pre.val > root.val) {
                    if (first == null)
                        first = pre;
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        // swap the node values
        if (first != null && second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
