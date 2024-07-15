//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        
        HashSet<ArrayList<String>> st = new HashSet<>();
        
        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j< m ; j++){
                ArrayList<String> vec = new ArrayList<>();
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    dfs(i,j,vis,grid,vec,i,j);
                    st.add(vec);
                }
            }
        }
        
        return st.size();
    }
    
    private static String toString(int r , int c){
        return Integer.toString(r)+ " "+ Integer.toString(c);
    }
    
    
    private static void dfs(int row , int col,int[][]vis, int[][] grid,ArrayList<String> vec, int row0,int col0){
        vis[row][col] = 1;
        vec.add(toString(row-row0, col-col0));
        
        int n =  grid.length;
        int m = grid[0].length;
        
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        
        for(int i = 0; i < 4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            
            if(nrow >=0 && ncol>=0 && nrow < n && ncol<m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                dfs(nrow,ncol,vis,grid,vec,row0,col0);
            }
        }
    }
}
