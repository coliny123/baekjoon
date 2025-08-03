import java.util.*;
import java.io.*;


class Beer {
    int like;
    int alcohol;
    
    public Beer(int x, int y){
        this.like = x;
        this.alcohol = y;
    }
}

public class Main {
    static int N, K;
    static long M;
    static List<Beer> beers = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        K = Integer.valueOf(input[2]);
        
        for(int i=0; i<K; i++){
            input = br.readLine().split(" ");
        
            int like = Integer.valueOf(input[0]);
            int alcohol = Integer.valueOf(input[1]);
            
            beers.add(new Beer(like, alcohol));
        }
        
        Collections.sort(beers, (a, b) -> a.alcohol - b.alcohol);
        
        PriorityQueue<Beer> pq = new PriorityQueue<>((a, b) -> a.like - b.like);
        
        long likeSum = 0;
        long alcoholMax = 0;
        
        long result = Long.MAX_VALUE;
        for(Beer beer : beers){
            pq.add(beer);
            likeSum += beer.like;
            alcoholMax = Math.max(alcoholMax, beer.alcohol);
            
            if(pq.size() > N){
                Beer remove = pq.poll();
                likeSum -= remove.like;
            }
            
            
            if(likeSum >= M && pq.size() == N){
                result = Math.min(result, alcoholMax);
            }
        }
        
        
        System.out.println(result == Long.MAX_VALUE ? -1 : result);
    }
}
