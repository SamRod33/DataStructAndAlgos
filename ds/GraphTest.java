package graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GraphTest {

  Node one = new Node("1");
  Node two = new Node("2");
  Node three = new Node("3");
  Node four = new Node("4");
  Node five = new Node("5");
  Node six = new Node("6");
  Node seven = new Node("7");
  Node eight = new Node("8");

  @Test
  public void testGraphSizeRec() {
    // 1 --- 2
    // |_`___|
    // |__`__|
    // |___`_|
    // 3 --- 4
    //
    // 6 -- 7
    //
    // 5

    one.addChildren(two, three, four);
    two.addChildren(one, three, four);
    three.addChildren(two, one, four);
    four.addChildren(two, three, one);
    six.addChildren(seven);
    seven.addChildren(six);

    assertEquals(0, DFS.graphSizeRec(null));
    assertEquals(1, DFS.graphSizeRec(five));
    assertEquals(4, DFS.graphSizeRec(one));
    assertEquals(4, DFS.graphSizeRec(three));
    // one.addChildren(two, three, four);
    // two.addChildren(five, six);
    // three.addChildren(six, seven);
    // four.addChildren(seven, eight);
    // assertEquals(8, DFS.graphSizeRec(one));

  }

  @Test
  public void testGraphSizeIterDFS() {
    // 1 --- 2
    // |_`___|
    // |__`__|
    // |___`_|
    // 3 --- 4
    //
    // 6 -- 7
    //
    // 5

    one.addChildren(two, three, four);
    two.addChildren(one, three, four);
    three.addChildren(two, one, four);
    four.addChildren(two, three, one);
    six.addChildren(seven);
    seven.addChildren(six);

    assertEquals(0, DFS.graphSizeIter(null));
    assertEquals(1, DFS.graphSizeIter(five));
    assertEquals(4, DFS.graphSizeIter(one));
    assertEquals(4, DFS.graphSizeIter(three));
    // one.addChildren(two, three, four);
    // two.addChildren(five, six);
    // three.addChildren(six, seven);
    // four.addChildren(seven, eight);
    // assertEquals(8, DFS.graphSizeIter(one));

  }

  @Test
  public void testGraphSizeIterBFS() {
    // 1 --- 2
    // |_`___|
    // |__`__|
    // |___`_|
    // 3 --- 4
    //
    // 6 -- 7
    //
    // 5

    // one.addChildren(two, three, four);
    // two.addChildren(one, three, four);
    // three.addChildren(two, one, four);
    // four.addChildren(two, three, one);
    // six.addChildren(seven);
    // seven.addChildren(six);

    // assertEquals(0, BFS.graphSizeIter(null));
    // assertEquals(1, BFS.graphSizeIter(five));
    // assertEquals(4, BFS.graphSizeIter(one));
    // assertEquals(4, BFS.graphSizeIter(three));
    one.addChildren(two, three, four);
    two.addChildren(five, six);
    three.addChildren(six, seven);
    four.addChildren(seven, eight);
    assertEquals(8, BFS.graphSizeIter(one));

  }
}
