//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static long dp[];
    public Solution(){
        dp = new long[10001];
        Arrays.fill(dp,-1);
    }
    static long topDown(int n) {
        // code here
        if(n <= 1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = (topDown(n-1) +  topDown(n-2)) % 1000000007;
        return dp[n]% 1000000007;
    }

    static long bottomUp(int n) {
        // long[] dp = new long[n+1];
        // Arrays.fill(dp,-1);
        // dp[0] = 0;
        // dp[1] = 1;
        // for(int i = 2; i<=n;i++){
        //     dp[i] = dp[i-1]+dp[i-2];
        // }
        // return dp[n];
        
        long prev2 = 0;
        long prev = 1;
        for(int i = 2; i <=n;i++){
            long curi = prev % 1000000007+ prev2 % 1000000007;
            prev2 = prev;
            prev = curi;
        }
        
        return prev % 1000000007;
    }
}
