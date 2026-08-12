import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : invocations) {
            graph.get(edge[0]).add(edge[1]);
        }

        // Step 2: Mark suspicious methods using DFS
        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);

        // Step 3: Check if any non-suspicious method calls a suspicious method
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!suspicious[u] && suspicious[v]) {
                // Cannot remove suspicious methods
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        // Step 4: Return remaining (non-suspicious) methods
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    // DFS to mark all reachable methods
    private void dfs(int node, List<List<Integer>> graph, boolean[] suspicious) {

        suspicious[node] = true;

        for (int next : graph.get(node)) {
            if (!suspicious[next]) {
                dfs(next, graph, suspicious);
            }
        }
    }
}