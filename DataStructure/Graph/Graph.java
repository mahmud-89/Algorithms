/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Graph;

/**
 *
 * @author promise
 */
import DataStructure.Queues.GenericQueue;
import DataStructure.Stack.StackArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Graph {

    Map<Integer, ArrayList<Integer>> map;

    public Graph() {
        map = new HashMap<>();
    }

    public Graph(int capacity) {
        map = new HashMap<>(capacity);
    }

    public void addEdge(int source, int destination, boolean bidirectional) {
        if (!map.containsKey(source)) {
            this.map.put(source, new ArrayList<>());
            this.map.get(source).add(destination);
        } else {
            this.map.get(source).add(destination);
        }

        if (!map.containsKey(destination)) {
            this.map.put(destination, new ArrayList<>());
        }

        if (bidirectional) {
            this.map.get(destination).add(source);
        }
    }

    public boolean isExist(int val) {
        return this.map.containsKey(val);
    }

    public boolean isConnected(int u, int v) {
        if (map.containsKey(u)) {
            return map.get(u).contains(v);
        }
        return false;
    }

    public boolean hasCycle(boolean bidirectional) {
        boolean visited[] = new boolean[sizeOfVertices()];
        if (bidirectional) {

        } else {
            boolean recStack[] = new boolean[sizeOfVertices()];
            for (int i = 0; i < sizeOfVertices(); i++) {
                if (hasCycleDirectedUtil(i, visited, recStack)) {
                    System.out.println("cycle found when starting v is: " + i);
                    return true;
                }
                System.out.println("rejected :" + i);
            }
        }
        return false;
    }

    public boolean hasCycleDirectedUtil(int v, boolean visited[], boolean recStack[]) {
        if (recStack[v]) {
            System.out.println("recStack base: " + v);
            return true;
        }
        if (visited[v]) {
            System.out.println("visited base: " + v);
            return false;
        }
        recStack[v] = true;
        visited[v] = true;

        List<Integer> children = this.map.get(v);

        for (int val : children) {
            if (hasCycleDirectedUtil(val, visited, recStack)) {
                return true;
            }
        }
        System.out.println("outer loop: " + v);
        recStack[v] = false;
        return false;
    }

    //approach-1(bfs)
    public boolean hasCycleUndirectedUtilBFS(int v) {
        boolean visited[] = new boolean[sizeOfVertices()];
        int flag[] = new int[sizeOfVertices()];
        GenericQueue<Integer> queue = new GenericQueue<>();

        for (int i = 0; i < flag.length; i++) {
            flag[i] = -1;
        }
        queue.enqueue(v);
        flag[v] = 0;
        while (!queue.isEmpty()) {
            Integer data = queue.dequeue();
            visited[data] = true;
            flag[data] = 1;
            for (Integer val : this.map.get(data)) {
                if (flag[val] == 0) {
                    System.out.println("resulting value:" + val);
                    return true;
                }
                if (!visited[val]) {
                    queue.enqueue(val);
                    flag[val] = 0;
                }
            }
        }

        return false;
    }

    //approach-2(Dfs)
    public boolean hasCycleUndirectedUtilDFS(int v, boolean visited[], int parent) {
        visited[v] = true;
        for (Integer val : this.map.get(v)) {
            if (!visited[val]) {
                if (hasCycleUndirectedUtilDFS(val, visited, v)) {
                    return true;
                }
            }else if(val != parent){
                System.out.println("val : "+val +" parent "+ parent);
                return true;
            }
        }
        return false;
    }

    public int sizeOfVertices() {
        return this.map.keySet().size();
    }

    public int sizeOfEdges(boolean bidirectional) {
        int counter = 0;
        for (int i = 0; i < sizeOfVertices(); i++) {
            counter += this.map.get(i).size();
        }
        if (bidirectional) {
            return counter / 2;
        }

        return counter;
    }

    public void clearGraph() {
        this.map.clear();
    }

    public void printGraph() {
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            Integer vertex = entry.getKey();
            System.out.printf("vertex %d is connected with: ", vertex);
            for (Integer val : map.get(vertex)) {
                System.out.print(val + " ");
            }
            System.out.println("");
        }
    }

    public void traverseBFS(int startingVertex) {
        GenericQueue<Integer> queue = new GenericQueue<>();
        boolean visited[] = new boolean[sizeOfVertices()];
        queue.enqueue(startingVertex);
        visited[startingVertex] = true;
        System.out.printf("bfs traversing from (%d): ", startingVertex);
        while (!queue.isEmpty()) {
            Integer val = queue.dequeue();
            System.out.print(val + " ");
            for (Integer v : this.map.get(val)) {
                if (!visited[v]) {
                    queue.enqueue(v);
                    visited[v] = true;
                }
            }
        }
        System.out.println("");
    }

    //iterative
    public void traverseDFS(int startingVertex) {
        boolean discoverd[] = new boolean[sizeOfVertices()];
        StackArrayList<Integer> stack = new StackArrayList<>();
        stack.push(startingVertex);
        discoverd[startingVertex] = true;
        System.out.printf("DFS traversing from vertex (%d): ", startingVertex);
        while (!stack.isEmpty()) {
            Integer val = stack.pop();
            System.out.print(val + " ");
            for (Iterator<Integer> itr = this.map.get(val).listIterator(); itr.hasNext();) {
                int n = itr.next();
                if (!discoverd[n]) {
                    stack.push(n);
                    discoverd[n] = true;
                }
            }
        }
        System.out.println("");
    }

    //recursive
    public void traverseRecursiveDFS(int startingVertex, boolean[] discoverd) {
        System.out.print(startingVertex + " ");
        discoverd[startingVertex] = true;
        for (Integer val : this.map.get(startingVertex)) {
            if (!discoverd[val]) {
                traverseRecursiveDFS(val, discoverd);
            }
        }
    }
}

class Runner {

    public static void main(String[] args) {
        Graph g = new Graph();
        boolean bidirectional = false;
        g.addEdge(0, 2, bidirectional);
        g.addEdge(1, 0, bidirectional);
        g.addEdge(1, 4, bidirectional);
        g.addEdge(4, 3, bidirectional);
        g.addEdge(3, 1, bidirectional);
        //g.addEdge(3, 4, bidirectional);

//        g.addEdge(2, 0, bidirectional);
//        g.addEdge(2, 3, bidirectional);
//        g.addEdge(3, 3, bidirectional);
        g.printGraph();

        g.traverseBFS(1);
        g.traverseDFS(0);

        //recursive dfs
        boolean discoverd[] = new boolean[g.sizeOfVertices()];
        int startingVertex = 0;
        System.out.printf("DFS traversing from %d: ", startingVertex);
        g.traverseRecursiveDFS(startingVertex, discoverd);
        System.out.println("");

        System.out.println("size of vertices: " + g.sizeOfVertices());
        System.out.println("number of edges: " + g.sizeOfEdges(bidirectional));
        System.out.println("\n\nchecking cycle...");
        System.out.println("has cycle? : " + g.hasCycle(bidirectional));

        System.out.println("\n\nclearing graph...");
        g.clearGraph();

        bidirectional = true;
        g.addEdge(0, 1, bidirectional);
        g.addEdge(0, 2, bidirectional);
        g.addEdge(2, 5, bidirectional);
        g.addEdge(1, 4, bidirectional);
        g.addEdge(1, 3, bidirectional);
        g.addEdge(3, 4, bidirectional);

        System.out.println("has cycle?" + g.hasCycleUndirectedUtilBFS(0));
        
        System.out.println("\n\nclearing graph...");
        g.clearGraph();
        bidirectional = true;
        g.addEdge(0, 1, bidirectional);
        g.addEdge(0, 2, bidirectional);
        g.addEdge(2, 5, bidirectional);
        g.addEdge(1, 4, bidirectional);
        g.addEdge(1, 3, bidirectional);
        g.addEdge(3, 4, bidirectional);
        
        discoverd = new boolean[g.sizeOfVertices()];
        System.out.println("has cycle? : " + g.hasCycleUndirectedUtilDFS(0, discoverd, -1));

    }
}

/**
 * g.addEdge(1, 2, bidirectional); g.addEdge(1, 4, bidirectional); g.addEdge(1,
 * 7, bidirectional); g.addEdge(2, 5, bidirectional); g.addEdge(2, 6,
 * bidirectional); g.addEdge(5, 7, bidirectional); g.addEdge(6, 4,
 * bidirectional); g.addEdge(6, 3, bidirectional); g.addEdge(3, 8,
 * bidirectional);
 */
