import java.util.LinkedList;
import java.util.*;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public List<Integer> preorder() {
    List<Integer> nodes = new LinkedList<>();
    preorderAux(this, nodes);
    return nodes;
  }

  public void preorderAux(TreeNode root, List<Integer> acc) {
    if (left == null || right == null)
      return;
    acc.add(val);
    preorderAux(left, acc);
    preorderAux(right, acc);
    return;
  }

  public List<Integer> inorder() {
    List<Integer> nodes = new LinkedList<>();
    inorderAux(this, nodes);
    return nodes;
  }

  public void inorderAux(TreeNode root, List<Integer> acc) {
    if (left == null || right == null)
      return;
    inorderAux(left, acc);
    acc.add(val);
    inorderAux(right, acc);
    return;
  }

  @Override
  public String toString() {

    return "Preorder: " + preorder().toString() + " inorder: " + inorder().toString();
  }
}