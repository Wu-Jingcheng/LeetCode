import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    private boolean search(int course, List<Integer> list, boolean[] visited,
    boolean[] occupied, List<Integer>[] pre){
        if(occupied[course])
            return false;
        if(visited[course])
            return true;
        occupied[course] = true;
        for(int preCourse:pre[course]){
            if(!search(preCourse, list, visited, occupied, pre))
                return false;
        }
        list.add(course);
        occupied[course] = false;
        visited[course] = true;
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[numCourses];
        boolean[] occupied = new boolean[numCourses];
        Arrays.fill(visited, false);
        int[] res = new int[numCourses];
        int[] empty = new int[0];
        List<Integer>[] pre = new List[numCourses];
        for(int i=0;i<numCourses;i++){
            pre[i] = new ArrayList<Integer>();
        }
        for(int[] prerequisite:prerequisites){
            pre[prerequisite[0]].add(prerequisite[1]);
        }
        for(int i=0;i<numCourses;i++){
            if(!search(i, list, visited, occupied, pre))
                return empty;
        }
        for(int i=0;i<numCourses;i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public void print(int[] courses){
        for(int course:courses){
            System.out.print(course);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] pre1 = {{1,0}}, pre2 = {{1,0},{2,0}, {3,1}, {3,2}}, pre3 = {},
        pre4 = {{1,2},{2,1}};
        s.print(s.findOrder(2, pre1));
        s.print(s.findOrder(4, pre2));
        s.print(s.findOrder(0, pre3));
        s.print(s.findOrder(3, pre4));
    }
}