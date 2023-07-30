package graphs;

import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;

public class BFS {

  /**
   * Return the size of the graph that contains n. Precondition: n must not be
   * null
   */
  public static int graphSizeIter(Node n) {
    if (n == null) {
      return 0;
    }
    int count = 0;
    Set<Node> visited = new HashSet<>();
    Queue<Node> visiting = new LinkedList<>();
    // add n to queue
    visiting.add(n);
    // keep visiting nodes until there are no more to visit
    while (!visiting.isEmpty()) {
      // FIFO poll
      Node u = visiting.poll();
      // do not traverse nodes more than once
      if (!visited.contains(u)) {
        count++;
        visited.add(u);
        // traverse unvisited children
        for (Node c : u.getChildren()) {
          // add only unvisited children to queue
          if (!visited.contains(c)) {
            visiting.add(c);
          }
        }
      }
    }
    return count;
  }

}