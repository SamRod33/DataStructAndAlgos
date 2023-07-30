package graphs;

public class Node {
  private String name = "";
  private Node[] children = new Node[0];

  public Node(String name, Node[] children) {
    this.name = name;
    this.children = children;
  }

  public Node(String name) {
    this.name = name;
  }

  public Node() {
  }

  public Node[] getChildren() {
    return children;
  }

  private void addChild(Node child) {
    Node[] arr = new Node[children.length + 1];
    int i = 0;
    for (Node c : children) {
      arr[i] = c;
      i++;
    }
    arr[arr.length - 1] = child;
    children = arr;
  }

  public void addChildren(Node... n) {
    for (Node c : n) {
      addChild(c);
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    StringBuilder childrenNames = new StringBuilder();
    for (Node c : children) {
      childrenNames.append(" ");
      childrenNames.append(c.getName());

    }
    return name + " :" + childrenNames.toString();
  }

}