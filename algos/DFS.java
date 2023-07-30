package graphs;

import java.util.*;

public class DFS {

  /**
   * Returns the number of nodes in a graph containing n using recursive DFS.
   * Precondition: n is not null. Raises IllegalArgumentException if n is null
   */
  private static int graphSizeRecAux(Node n, HashSet<Node> visited) {
    if (n == null)
      throw new IllegalArgumentException();
    int count = 1;
    // mark n as visited
    visited.add(n);
    // go to each neighbor and perform a DFS walk
    for (Node c : n.getChildren()) {

      // do not traverse nodes more than once
      if (!visited.contains(c)) {
        System.out.print(", " + c.getName());
        count += graphSizeRecAux(c, visited);
      }
    }
    return count;

  }

  /** Returns the number of nodes in a graph containing n using recursive DFS */
  public static int graphSizeRec(Node n) {
    // no node given
    if (n == null)
      return 0;
    System.out.print("[" + n.getName());
    int count = graphSizeRecAux(n, new HashSet<Node>());
    System.out.println("]");

    return count;
  }

  /** Returns the number of nodes in a graph containing n using iterative DFS */
  public static int graphSizeIter(Node n) {
    if (n == null) {
      return 0;
    }
    int count = 0;
    // keep track of visited nodes
    HashSet<Node> visited = new HashSet<>();
    // add nodes as we encounter them
    Stack<Node> visiting = new Stack<>();
    // add n to stack
    visiting.push(n);
    System.out.print("[");
    // keep visiting nodes if there is nodes left to visit
    while (!visiting.isEmpty()) {
      Node u = visiting.pop();
      // do not visit already visited nodes
      if (!visited.contains(u)) {
        System.out.print(" " + u.getName());
        visited.add(u);
        count++;
        for (Node c : u.getChildren()) {
          if (!visited.contains(c)) {
            visiting.push(c);
          }
        }

      }
    }
    System.out.println(" ]");
    return count;
  }

  public static List<Integer> dfsWalk(int u, Map<Integer, Set<Integer>> g) {
    List<Integer> out = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    Stack<Integer> visiting = new Stack<>();
    visiting.push(u);
    while (!visiting.isEmpty()) {
      int n = visiting.pop();
      if (!visited.contains(n)) {
        visited.add(n);
        out.add(n);
        Set<Integer> neighbors = g.get(n);
        for (int neighbor : neighbors) {
          if (!visited.contains(neighbor))
            visiting.push(neighbor);
        }
      }
    }
    return out;
  }

}
