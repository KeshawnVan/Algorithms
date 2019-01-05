package algorithm.search;

import java.util.LinkedList;

@SuppressWarnings("Duplicates")
public class DepthFirstSearch {

    public static void dfs(LinkedList<Integer>[] adj, int number, int s, int t) {
        result result = new result();

        boolean[] visited = new boolean[number];
        visited[s] = true;

        int[] prev = new int[number];

        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }

        recursionDfs(s, t, visited, prev, result, adj);

        print(prev, s, t);
    }

    private static void recursionDfs(int w, int t, boolean[] visited, int[] prev, result result, LinkedList<Integer>[] adj) {
        if (result.isFound) return;

        for (int i = 0; i < adj[w].size(); i++) {
            Integer q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                visited[q] = true;
                if (w == t) result.isFound = true;
                recursionDfs(q, t, visited, prev, result, adj);
            }
        }
    }

    private static void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }

    static class result {
        boolean isFound;
    }
}
