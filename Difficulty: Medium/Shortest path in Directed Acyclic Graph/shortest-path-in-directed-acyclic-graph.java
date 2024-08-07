//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class pair{
    int first;
    int second;
    
    pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    
    private void toposort(int node, ArrayList<ArrayList<pair>> adj, int[] vis, Stack<Integer> st){
        vis[node] = 1;
        
        
        for(int i = 0; i< adj.get(node).size();i++){
            int v = adj.get(node).get(i).first;
            
            if(vis[v] == 0){
                toposort(v,adj,vis,st);
            }
        }
        
        
        
        st.add(node);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
	    
	    ArrayList<ArrayList<pair>> adj = new ArrayList<> ();
	    
	    for(int i =0; i < N ; i++){
	        ArrayList<pair> temp = new ArrayList<pair>();
	        adj.add(temp);
	    }
	    
	    for(int i = 0; i < M ; i++){
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int wt = edges[i][2];
	        
	        adj.get(u).add(new pair(v,wt));
	        
	    }
	    
	    int[] vis = new int[N];
	    
	    Stack<Integer> st = new Stack<>();
	    
	    for(int i = 0; i<N ;i++){
	        if(vis[i] == 0){
	            toposort(i,adj,vis,st);
	        }
	    }
	    
	    // take the nodes out of the stack to find the distsance
	    
	    int[] dist = new int[N];
	    
	    for(int i = 0 ; i < N ;i++){
	        dist[i] = (int)(1e9);
	    }
	    
	    dist[0] = 0;
	    
	    while(!st.isEmpty()){
	        int node = st.peek();
	        st.pop();
	        
	        
	        for(int i = 0; i < adj.get(node).size();i++){
	            
	            int v = adj.get(node).get(i).first;
	            int wt = adj.get(node).get(i).second;
	            
	            if(dist[node] + wt < dist[v]){
	                dist[v] = dist[node] + wt;
	            }
	        }
	    }
	    
	    for(int i = 0 ; i< N;i++){
	        if(dist[i] == 1e9){
	            dist[i] = -1;
	        }
	    }
	    return dist;
	    
		
	}
}