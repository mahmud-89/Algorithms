/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author promise
 */
public class TropologicalSortDemo {
    private Graph graph;
    private Map<Integer,ArrayList<Integer>> map;
    
    public TropologicalSortDemo(){
        this.graph = createGraph();
        this.map = this.graph.getMap();
    } 
    
    public Graph createGraph(){
        Graph g = new Graph();
        boolean bidirectional = false;
        g.addEdge(5, 0, bidirectional);
        g.addEdge(5, 2, bidirectional);
        g.addEdge(2, 3, bidirectional);
        g.addEdge(3, 1, bidirectional);
        g.addEdge(4, 1, bidirectional);
        g.addEdge(4, 0, bidirectional);
        return g;
    }
    
    public int sizeOfVertices(){
        return this.map.size();
    }
    
    //dfs approach
    public void tropologicalSort(){
        boolean[] visited = new boolean[this.graph.sizeOfVertices()];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<this.graph.sizeOfVertices();i++){
            if(!visited[i]){
                tropologicalSortUtil(i, visited, stack);
            }
        }
        
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println("");
    }
    private void tropologicalSortUtil(int vertex, boolean visited[], Stack stack){
        visited[vertex] = true;
        for(int val : this.map.get(vertex)){
            if(!visited[val]){
                tropologicalSortUtil(val, visited, stack);
            }
        }
        stack.push(vertex);
    }
    
    //indegree approach
    public void toposort(){
        int[] indegree = new int[sizeOfVertices()];
        for(int i=0;i<sizeOfVertices();i++){
            ArrayList<Integer> path = new ArrayList<>();
            for(int val : this.map.get(i)){
                indegree[val]++;
            }
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> path = new ArrayList<>(sizeOfVertices());
        int checkCycle = 0;
        for(int i = 0;i<sizeOfVertices();i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int curVertex = queue.poll();
            path.add(curVertex);
            for(int val : this.map.get(curVertex)){
                if(--indegree[val] == 0){
                    queue.add(val);
                }
            }
            checkCycle++;
        }
        if(checkCycle!=sizeOfVertices()){
            System.out.println("There exists a cycle in this graph!!");
            return;
        }
        
        //printing the path
        for(int val : path){
            System.out.print(val + " ");
        }
        System.out.println("");
    }
    
}

class Driver{
    public static void main(String[] args) {
        TropologicalSortDemo ts = new TropologicalSortDemo();
        
        System.out.print("dfs approach: ");
        ts.tropologicalSort();
        System.out.println("");
        
        System.out.print("indegree approach (kahn's algo): ");
        ts.toposort();
        System.out.println("");
    }
}
