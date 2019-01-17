package data.structure.graph;

import java.util.LinkedList;

public class Graph {

    private LinkedList<Integer>[] adj;

    private int number;

    public Graph(int number) {
        this.number = number;
        adj = new LinkedList[number];
        for (int i = 0; i < number; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    public int getNumber() {
        return number;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }
}
