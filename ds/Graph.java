package graphs;

public class Graph {
  private Node[] nodes;

  public Graph(Node[] nodes) {
    this.nodes = nodes;
  }

  public Node[] getNodes() {
    return nodes;
  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    output.append("Graph:");
    for (Node n : nodes) {
      output.append("\n" + n.toString());
    }
    return output.toString();
  }

}
