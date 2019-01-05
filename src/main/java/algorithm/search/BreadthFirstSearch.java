package algorithm.search;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("Duplicates")
public class BreadthFirstSearch {

    public static void bfs(LinkedList<Integer>[] adj, int number, int s, int t) {

        boolean[] visited = new boolean[number];
        visited[s] = true;

        int[] prev = new int[number];

        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (queue.size() > 0) {
            Integer current = queue.poll();
            for (int i = 0; i < adj[current].size(); i++) {
                Integer q = adj[current].get(i);
                if (!visited[q]) {
                    prev[q] = current;

                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private static void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }
}
