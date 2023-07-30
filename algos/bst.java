
class Solution {

  public static void main(String[] args) {
    int[] preorder = { 8, 5, 1, 7, 10, 12 };
    TreeNode t = bstFromPreorder(preorder);
    System.out.println(t.toString());
  }

  public static TreeNode bstFromPreorder(int[] preorder) {
    if (preorder.length == 0) {
      return null;
    }
    if (preorder.length == 1) {
      return new TreeNode(preorder[0]);
    }
    int n = nodeHelper(preorder, 0);
    // System.out.println(n);
    return buildTree(preorder, 0, 1, n, n + 1, preorder.length - 1);

  }

  public static TreeNode buildTree(int[] preorder, int k, int m, int n, int i, int j) {

    TreeNode root = new TreeNode();
    root.val = preorder[k];
    int nL = nodeHelper(preorder, m);
    int nR = nodeHelper(preorder, i);
    if (n < m) {
      root.left = null;
    } else {
      root.left = buildTree(preorder, m, m + 1, nL, nL + 1, n);
    }
    if (j < i) {
      root.right = null;
    } else {
      root.right = buildTree(preorder, i, i + 1, nR, nR + 1, j);
    }
    return root;
  }

  public static int nodeHelper(int[] arr, int root) {
    for (int i = root; i < arr.length; i++) {
      if (arr[i] > arr[root]) {
        return i - 1;
      }
    }
    return -1;
  }
}