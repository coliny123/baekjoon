import java.util.*;
import java.io.*;

public class Main {
    public static PriorityQueue<String> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int M = Integer.valueOf(input[1]);
        
        char[][] grid = new char[N][M];
        
        for(int i=0; i<N; i++){
            String row = br.readLine();
            for(int j=0; j<M; j++){
                grid[i][j] = row.charAt(j);
            }
            String[] words = row.split("#");
            for(String word : words){
                if(word.length() >= 2){
                    pq.add(word);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                sb.append(grid[j][i]);
            }
            String[] words = sb.toString().split("#");
            for(String word : words){
                if(word.length() >= 2){
                    pq.add(word);
                }
            }
            sb.setLength(0);
        }
        
        
        System.out.println(pq.poll());
    }
}
