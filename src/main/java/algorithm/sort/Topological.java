package algorithm.sort;

import data.structure.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Topological {

    public static void kahnSort(Graph graph) {

        int[] inDegree = new int[graph.getNumber()];

        LinkedList<Integer>[] adj = graph.getAdj();

        for (int i = 0; i < inDegree.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                Integer point = adj[i].get(j);
                inDegree[point]++;
            }
        }

        Queue<Integer> noReferencePoints = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            int reference = inDegree[i];
            if (reference == 0) noReferencePoints.add(i);
        }

        while (!noReferencePoints.isEmpty()) {
            Integer point = noReferencePoints.poll();
            System.out.print("->" + point);
            for (int i : adj[point]) {
                inDegree[i]--;
                if (inDegree[i] == 0) noReferencePoints.add(i);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        kahnSort(graph);
    }
}
