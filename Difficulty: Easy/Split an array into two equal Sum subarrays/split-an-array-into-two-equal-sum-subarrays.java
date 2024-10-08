//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean canSplit(int arr[]) {
        long sum = 0L;
        for(int i = 0; i < arr.length;i++){
            sum+= arr[i];
        }
        if(sum % 2!= 0) return false;
        Long sum1 = 0L;
        for(int i = 0; i < arr.length; i++){
            sum1 += arr[i];
            if(sum1 == sum/2){
                return true;
            }
        }
        return false;
    }
}