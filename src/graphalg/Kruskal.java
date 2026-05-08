/* Kruskal.java */

package graphalg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;
import graph.*;
import set.*;

/**
 * The Kruskal class contains the method minSpanTree(), which implements
 * Kruskal's algorithm for computing a minimum spanning tree of a graph.
 */

public class Kruskal {

  /**
   * minSpanTree() returns a WUGraph that represents the minimum spanning tree
   * of the WUGraph g. The original WUGraph g is NOT changed.
   *
   * @param g The weighted, undirected graph whose MST we want to compute.
   * @return A newly constructed WUGraph representing the MST of g.
   */
  public static WUGraph minSpanTree(WUGraph g) {
    WUGraph t = new WUGraph();

    Object[] vertices = g.getVertices();
    for (Object v : vertices) {
      t.addVertex(v);
    }

    ArrayList<Edge> edgeList = new ArrayList<>();
    int i = 0;
    HashSet<VertexPair> seen = new HashSet<>();
    for (Object v : vertices) {
      Neighbors n = g.getNeighbors(v);
      if (n != null) {
        for (int j = 0; j < n.neighborList.length; j++) {
          Object u = n.neighborList[j];
          VertexPair pair = new VertexPair(u, v);
          if (!seen.contains(pair)) {
            seen.add(pair);
            edgeList.add(new Edge(v, u, n.weightList[j]));
          }
        }
      }
    }

    Edge[] edges = edgeList.toArray(new Edge[0]);
    Arrays.sort(edges, (a, b) -> a.weight - b.weight);
    HashMap<Object, Integer> vertexIndex = new HashMap<Object, Integer>();
    for (int j = 0; j < vertices.length; j++) {
      vertexIndex.put(vertices[j], j);
    }

    DisjointSets ds = new DisjointSets(vertices.length);

    for (Edge e : edges) {
      int u = vertexIndex.get(e.u);
      int v = vertexIndex.get(e.v);
      int rootU = ds.find(u);
      int rootV = ds.find(v);
      if (rootU != rootV) {
        ds.union(rootU, rootV);
        t.addEdge(e.u, e.v, e.weight);
      }
    }

    return t;
  }
}
