
package a6;

/* NetId(s): sar325

 * Name(s): Samuel Rodriguez
 * What I thought about this assignment:
 * I thought it was a very short assignment; I wish I could have done more to
 * make this program work! Implementing the Dijkstra's Algorithm was simple.
 * Again, I feel like we could have been assigned more to do instead of
 * giving us nearly everything... very neat result nevertheless!
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import graph.Edge;
import graph.Node;

/** This class contains the solution to A6, shortest-path algorithm, <br>
 * and other methods for an undirected graph. */
public class A6 {

    /** Replace "-1" by the time you spent on A2 in hours.<br>
     * Example: for 3 hours 15 minutes, use 3.25<br>
     * Example: for 4 hours 30 minutes, use 4.50<br>
     * Example: for 5 hours, use 5 or 5.0 */
    public static double timeSpent= 2.0;

    /** Return the shortest path from node v to node last <br>
     * ---or the empty list if a path does not exist. <br>
     * Note: The empty list is a list with 0 elements ---it is not "null". */
    public static List<Node> shortestPath(Node v, Node last) {
        /* TODO Implement this method.
         * Read the A6 assignment handout for all details.
         * Remember, the graph is undirected.
         * Finally, you will need to declare a HashMap. See the handout for details */

        // Contains an entry for each node in the frontier set. The priority of
        // a node
        // is the length of the shortest known path from v to the node using
        // only settled
        // node except for the last node, which is in F
        Heap<Node> F= new Heap<>(true);
        F.add(v, 0);
        // Nodes from S and F sets have entries in the HashMap
        HashMap<Node, NodeData> SandF= new HashMap<>();
        SandF.put(v, new NodeData(null, 0));
        // Invariant:
        // 1) For a node s in Settled set S, a shortest v --> s path exists that
        // contains only settled nodes; d[s] is its length (distance) and bk[s]
        // is s's backpointer
        // 2) For each node f in Frontier set F, a v --> f path exists that
        // contains only settled nodes except for f; d[f] is
        // the length (distance) of the shortest such path and bk[f] is f's
        // backpointer on that path.
        // 3) All edges leaving S go to F
        // 4) For w in S or F, bp[w] is w’s backpointer on the shortest known
        // path from v to w
        while (F.size() > 0) {
            // removes f from F and add to S
            Node f= F.poll();
            // IMMEDIATELY RETURN PATH IF LAST IS FOUND
            if (f.equals(last)) { return path(SandF, f); }
            for (Edge e : f.getExits()) {
                Node w= e.getOther(f);
                int dF= SandF.get(f).dist;
                int wWgt= dF + e.length;
                NodeData wData= SandF.get(w);
                // w is in the Far Off Set
                if (!SandF.containsKey(w)) {
                    SandF.put(w, new NodeData(f, wWgt));
                    F.add(w, wWgt);
                } // see if f to w is a shorter path
                else if (wWgt < wData.dist) {
                    wData.dist= wWgt;
                    wData.bkptr= f;
                    F.changePriority(w, wWgt);
                }
            }

        }

        // no path from v to last --it's best to leave this at the end of the
        // method
        return new LinkedList<>();
    }

    /** An instance contains information about a node: <br>
     * the Distance of this node from the start node and <br>
     * its Backpointer: the previous node on a shortest path <br>
     * from the first node to this node (null for the start node). */
    private static class NodeData {
        /** shortest known distance from the start node to this one. */
        private int dist;
        /** backpointer on path (with shortest known distance) from start node
         * to this one */
        private Node bkptr;

        /** Constructor: an instance with dist d from the start node and<br>
         * backpointer p. */
        private NodeData(Node p, int d) {
            dist= d;     // Distance from start node to this one.
            bkptr= p;    // Backpointer on the path (null if start node)
        }

        /** return a representation of this instance. */
        @Override
        public String toString() {
            return "dist " + dist + ", bckptr " + bkptr;
        }
    }

    /** = the path from the start node to node last.<br>
     * Precondition: mapSF contains all the necessary information about<br>
     * ............. the path. */
    public static List<Node> path(HashMap<Node, NodeData> mapSF, Node last) {
        List<Node> path= new LinkedList<>();
        Node p= last;
        // invariant: All the nodes from p's successor to node last are in
        // path, in reverse order.
        while (p != null) {
            path.add(0, p);
            p= mapSF.get(p).bkptr;
        }
        return path;
    }

    /** Return the sum of the weights of the edges on path p. <br>
     * Precondition: pa contains at least 1 node. <br>
     * If 1 node, it's a path of length 0, i.e. with no edges. */
    public static int pathSum(List<Node> p) {
        synchronized (p) {
            Node w= null;
            int sum= 0;
            // invariant: if w is null, n is the start node of the path.<br>
            // .......... if w is not null, w is the predecessor of n on the
            // path.
            // .......... sum = sum of weights on edges from first node to v
            for (Node n : p) {
                if (w != null) sum= sum + w.getEdge(n).length;
                w= n;
            }
            return sum;
        }
    }

}
