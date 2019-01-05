package algorithm.search;

import data.structure.graph.UndirectedGraph;
import org.junit.jupiter.api.Test;

public class TestBreadthOrDepthFirstSearch {

    private UndirectedGraph graph = new UndirectedGraph(8);

    {
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);

        graph.addEdge(1, 2);
        graph.addEdge(1, 4);

        graph.addEdge(2, 5);

        graph.addEdge(3, 4);

        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        graph.addEdge(5, 7);

        graph.addEdge(6, 7);
    }

    @Test
    public void bfs() {
        BreadthFirstSearch.bfs(graph.getAdj(), graph.getNumber(), 0, 6);
        System.out.println("-------------------");
        BreadthFirstSearch.bfs(graph.getAdj(), graph.getNumber(), 0, 7);
        System.out.println("-------------------");
        BreadthFirstSearch.bfs(graph.getAdj(), graph.getNumber(), 3, 5);
    }

    @Test
    public void dfs() {
        DepthFirstSearch.dfs(graph.getAdj(), graph.getNumber(), 0, 6);
        System.out.println("-------------------");
        DepthFirstSearch.dfs(graph.getAdj(), graph.getNumber(), 0, 7);
        System.out.println("-------------------");
        DepthFirstSearch.dfs(graph.getAdj(), graph.getNumber(), 3, 5);
    }
}
