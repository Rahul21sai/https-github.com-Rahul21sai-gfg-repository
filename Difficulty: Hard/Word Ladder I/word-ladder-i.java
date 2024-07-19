//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class pair{
    String first;
    int second;
    
    pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Queue<pair> q = new LinkedList<>();
        
        q.add(new pair(startWord,1));
        
        Set<String> st = new HashSet<String>();
        
        int len = wordList.length;
        
        for(int i = 0 ; i < len;i++){
            st.add(wordList[i]);
        }
        
        st.remove(startWord);
        
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            
            if(word.equals(targetWord) == true) return steps;
            
            // hat 
            
            for(int i = 0 ; i < word.length();i++){
                for(char ch= 'a'; ch <='z';ch++ ){
                    char replacedchararray[] = word.toCharArray();
                    
                    replacedchararray[i] = ch;
                    String replacedword = new String(replacedchararray);
                    
                    if(st.contains(replacedword) == true){
                        st.remove(replacedword);
                        
                        q.add(new pair(replacedword,steps+1));
                    }
                    
                }
            }
        }
        return 0;
    }
}