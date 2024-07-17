//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        int[] ind = new int[V];
        
        for(int i = 0; i < V;i++){
            for(int it: adj.get(i)){
                ind[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer> ();
        
        for(int i = 0; i< V;i++){
            if(ind[i] == 0){
                q.add(i);
            }
        }
        
        int count = 0;
        
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            count++;
            
            // node is in the topo sort
            // so please remove it from the indegree
            
            for(int it: adj.get(node)){
                ind[it]--;
                
                if(ind[it] == 0){
                    q.add(it);
                    
                }
            }
        }
        if(count == V){
            return false;
        }
        return true;
    }
}