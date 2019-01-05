package data.structure.graph;

import java.util.LinkedList;

public class UndirectedGraph {

    private LinkedList<Integer>[] adj;

    private int number;

    public UndirectedGraph(int number) {
        this.number = number;
        adj = new LinkedList[number];
        for (int i = 0; i < number; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }
}
