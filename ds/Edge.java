package graphs;

public class Edge {
  private int u;
  private int v;
  private int weight;

  public Edge(int u, int v) {
    this.u = u;
    this.v = v;
    weight = 1;
  }

  public Edge(int u, int v, int weight) {
    this.u = u;
    this.v = v;
    this.weight = weight;
  }

  public int fst() {
    return u;
  }

  public int snd() {
    return v;
  }

  public int[] getEdge() {
    return new int[] { u, v };
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass())
      return false;
    Edge e = (Edge) obj;
    boolean out = u == e.fst() && v == e.snd() && weight == e.weight;
    return out;
  }

  @Override
  public int hashCode() {
    return u + v + weight;
  }

  @Override
  public String toString() {
    return "(" + u + ", " + v + "):" + weight;
  }
}
