//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b) {
        String x = "";
        String y = "";
        for (int i = 0; i < a.size(); i++) x += a.get(i);
        for (int i = 0; i < b.size(); i++) y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for (int i = 0; i < n; i++) {
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans =
                obj.findSequences(startWord, targetWord, wordList);
            if (ans.size() == 0)
                System.out.println(-1);
            else {
                Collections.sort(ans, new comp());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ans.size(); i++) {
                    for (int j = 0; j < ans.get(i).size(); j++) {
                        sb.append(ans.get(i).get(j) + " ");
                    }
                    if (i != ans.size() - 1) sb.append("\n");
                }
                System.out.println(sb);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord,String targetWord,String[] wordList) {
        
        Set <String> st = new HashSet<String>();
        int len = wordList.length;
        for(int i = 0; i< len; i++){
            st.add(wordList[i]);
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls =  new ArrayList<>();
        ls.add(startWord);
        q.add(ls);
        
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;
        
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        while(!q.isEmpty()){
            ArrayList<String> vec = q.peek();
            q.remove();
            // erase all words that has been used in the  previous levels to transform
            
            if(vec.size() > level){
                level++;
                
                for(String it : usedOnLevel){
                    st.remove(it);
                }
            }
            
            // last word in the list that we perform the actions 
            String word = vec.get(vec.size() - 1);
            
            if(word.equals(targetWord)){
                // the first sequemce where we reached the end 
                if(ans.size() == 0) ans.add(vec);
                else if(ans.get(0).size() == vec.size()) ans.add(vec);
            }
            
            for(int i = 0; i < word.length();i++){
                
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char arr[] = word.toCharArray();
                    arr[i] = ch;
                    String replacedword = new String(arr);
                    
                    if(st.contains(replacedword) == true){
                        vec.add(replacedword);
                        
                        // java works by reference 
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        
                        // mark as visited on the level
                        
                        usedOnLevel.add(replacedword);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        return ans;
        
        
    }
}