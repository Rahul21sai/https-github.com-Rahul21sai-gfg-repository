//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        
        ArrayList<String> list = new ArrayList<>();
        
        int n = mat.length;
        
        if(mat[n-1][n-1] == 0){
            return list;
        }
        travel(mat,list, n,0,0,"");
        
        return list;
    }
    
    public void travel(int[][] mat,ArrayList<String> ans, int n , int i , int j,String cur){
        if(i ==n || j ==n || i <0 || j <0){
            return;
        }
        
        if(i == n -1 && j == n-1){
            ans.add(cur);
            return;
        }
        
        if(mat[i][j] == 0){
            return;
        }
        mat[i][j] =0;
        travel(mat,ans,n,i+1,j,cur+"D");
        travel(mat,ans,n,i,j+1,cur+"R");
        travel(mat,ans,n,i-1,j,cur+"U");
        travel(mat,ans,n,i,j-1,cur+"L");
        mat[i][j] = 1;
    }
    
    
    
}