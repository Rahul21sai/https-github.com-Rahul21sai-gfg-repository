//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        HashMap<Integer,Integer> set=new HashMap<>();
        //collects the frequency
        for(int i:arr){
            set.put(i,set.getOrDefault(i,0)+1);
        }
        
        //create a list to apply comparable
     ArrayList<Integer> list=new ArrayList<>();
     for(int num:arr){
         list.add(num);
     }
     
     //apply comparable and sort the list based on frequency and vlaue
     Collections.sort(list,(a,b)->{
         int freqA = set.get(a);
         int freqB = set.get(b);
         if(freqA != freqB){
             //simply return whose freq is more
             return freqB - freqA;
         }else{
             //if freq is same return who ever is small
             return a-b;
         }
     });
     
     return list;
        
    }
}



//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends