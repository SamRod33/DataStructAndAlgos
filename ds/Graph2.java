package graphs;

import java.util.*;

public class Graph2 {

  private Map<Integer, Set<Integer>> graph;
  private Set<Edge> E;
  private Set<Integer> V;

  public Graph2() {
    this.graph = new HashMap<>();
    this.E = new HashSet<>();
    this.V = new HashSet<>();
  }

  public Graph2(Collection<Integer> vertices, Collection<Edge> edges) {
    graph = new HashMap<>();
    addDirectedEdges(edges);
    addVertices(vertices);
    return;
  }

  public void addVertices(Collection<Integer> vertices) {
    for (int v : vertices) {
      addVertice(v);
    }
  }

  public void addVertice(int v) {
    V.add(v);
    if (!graph.containsKey(v))
      graph.put(v, new HashSet<>());
    return;
  }

  public void addEdges(Collection<Edge> edges) {
    for (Edge e : edges) {
      addEdge(e);
    }
    return;
  }

  public void addDirectedEdges(Collection<Edge> edges) {
    for (Edge e : edges) {
      addDirectedEdge(e.fst(), e.snd());
    }
    return;
  }

  public void addEdge(Edge e) {
    if (e == null)
      return;
    int u = e.fst();
    int v = e.snd();
    addDirectedEdge(u, v);
    addDirectedEdge(v, u);
    return;
  }

  public void addDirectedEdge(int u, int v) {
    // adds u, v to V and (u, v) to E
    // then updates graph by adding v to u's set of pairs
    if (V == null)
      V = new HashSet<>();
    if (E == null)
      E = new HashSet<>();
    addVertice(u);
    addVertice(v);
    E.add(new Edge(u, v));
    if (graph.containsKey(u))
      graph.get(u).add(v);
    else {
      Set<Integer> uNeighbors = new HashSet<>();
      uNeighbors.add(v);
      graph.put(u, uNeighbors);
    }
    return;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass())
      return false;
    Graph2 g = (Graph2) obj;
    return graph.equals(g.graph) && V.equals(g.V) && E.equals(g.E);
  }

  public Set<Integer> getV() {
    return V;
  }

  public Set<Edge> getE() {
    return E;
  }

  public Map<Integer, Set<Integer>> getGraph() {
    return graph;
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    out.append("|V| = " + V.size() + "\n");
    out.append("|E| = " + E.size() + "\n");
    Iterator<Map.Entry<Integer, Set<Integer>>> iter = graph.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry<Integer, Set<Integer>> entry = iter.next();
      out.append(entry.getKey() + " -> " + entry.getValue().toString() + "\n");
    }
    return out.toString();
  }
}
