import java.util.HashSet;
import java.util.Set;

public class Solution {
    private boolean helper(int[][] graph, int index, Set<Integer> to_add, Set<Integer> to_avoid) {
        if (to_add.contains(index))
            return true;
        if (to_avoid.contains(index))
            return false;
        to_add.add(index);
        for (int next_index : graph[index]) {
            if (!helper(graph, next_index, to_avoid, to_add))
                return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        if (graph.length == 0)
            return true;
        
        for(int start = 0;start<graph.length;start++){
            if(set1.contains(start)||set2.contains(start))
                continue;
            if(!helper(graph, start, set1, set2))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] graph1 = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
        int[][] graph2 = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        System.out.println(s.isBipartite(graph1));
        System.out.println(s.isBipartite(graph2));
    }
}