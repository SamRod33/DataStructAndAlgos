package graphs;

import java.util.*;

public class Graph2Test {

  public static void main(String[] args) {
    Collection<Integer> vEmpty = new ArrayList<>();
    Collection<Edge> eEmpty = new Stack<>();
    List<Integer> vNoDups = new LinkedList<>() {
      {
        add(5);
      }
    };
    List<Integer> vDups = new LinkedList<>() {
      {
        add(5);
        add(4);
        add(1);
      }
    };
    List<Edge> eNoDups = new ArrayList<>() {
      {
        add(new Edge(1, 2));
        add(new Edge(2, 1));
        add(new Edge(1, 3));
        add(new Edge(1, 4));
        add(new Edge(3, 2));
        add(new Edge(3, 4));
      }
    };
    List<Edge> eDups = new ArrayList<>() {
      {
        add(new Edge(1, 2));
        add(new Edge(2, 1));
        add(new Edge(2, 1));
        add(new Edge(1, 3));
        add(new Edge(1, 4));
        add(new Edge(3, 2));
        add(new Edge(3, 4));
        add(new Edge(3, 4));
      }
    };

    System.out.println("Starting with Empty Graph");
    Graph2 g1 = new Graph2();
    System.out.println("First initialized:");
    System.out.println(g1.toString());
    g1.addDirectedEdges(eNoDups);
    g1.addVertices(vNoDups);
    System.out.println("After adding directed edges and nodes:");
    System.out.println(g1.toString());
    System.out.println("E = " + g1.getE().toString());
    System.out.println("V = " + g1.getV().toString());
    System.out.println("If we added undirected edges instead:");
    Graph2 g2 = new Graph2();
    g2.addEdges(eNoDups);
    g2.addVertices(vNoDups);
    System.out.println(g2.toString());
    System.out.println("E = " + g2.getE().toString());
    System.out.println("V = " + g2.getV().toString());
    System.out.println("If we added undirected edges to a graph with directed edges");
    g1.addEdges(eNoDups);
    System.out.println(g1.toString());
    System.out.println("E = " + g1.getE().toString());
    System.out.println("V = " + g1.getV().toString());
    System.out.println("Graphs Equal? " + g1.equals(g2));
    System.out.println("Initializing with nodes and edges (no duplicates)");
    Graph2 g3 = new Graph2(vNoDups, eNoDups);
    System.out.println(g3.toString());
    System.out.println("E = " + g3.getE().toString());
    System.out.println("V = " + g3.getV().toString());
    System.out.println("Initalizing with nodes and edges (duplciates in both)");
    Graph2 g4 = new Graph2(vDups, eDups);
    System.out.println(g4.toString());
    System.out.println("E = " + g4.getE().toString());
    System.out.println("V = " + g4.getV().toString());
    System.out.println("Graphs Equal? " + g3.equals(g4));
    Graph2 g5 = new Graph2(vEmpty, eEmpty);
    g5.addDirectedEdges(eNoDups);
    g5.addVertices(vNoDups);
    System.out.println("Graphs equal to an initial empty graph but then filled with stuff? " + g3.equals(g5));

    System.out.println("DFS @ 1: ");
    System.out.println("g3: " + DFS.dfsWalk(1, g3.getGraph()).toString());
    System.out.println("DFS @ 2: ");
    System.out.println("g3: " + DFS.dfsWalk(2, g3.getGraph()).toString());
    System.out.println("DFS @ 3: ");
    System.out.println("g3: " + DFS.dfsWalk(3, g3.getGraph()).toString());
    System.out.println("DFS @ 4: ");
    System.out.println("g3: " + DFS.dfsWalk(4, g3.getGraph()).toString());

  }

}
