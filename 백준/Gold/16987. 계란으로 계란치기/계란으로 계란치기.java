import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int[] defense;
    static int[] attack;
    static int answer = 0;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.valueOf(br.readLine());
        
        defense = new int[N];
        attack = new int[N];
        
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            defense[i] = Integer.valueOf(input[0]);
            attack[i] = Integer.valueOf(input[1]);
        }
        
        
        BT(0, 0);
        
        System.out.println(answer);
    }
    
    
    static void BT(int cur, int broken){
        if(cur == N){
            answer = Math.max(answer, broken);
            return;
        }
        
        if(defense[cur] <= 0 || broken == N-1){
            BT(cur+1, broken);
            return;
        }
        
        
        for(int nx = 0; nx < N; nx++){
            if(nx == cur) continue;
            if(defense[nx] <= 0) continue;
            
            int cnt = hit(cur, nx);
            BT(cur + 1, broken + cnt);
            recovery(cur, nx);
        }
    }
    
    
    static int hit(int left, int right){
        int broken = 0;
        
        defense[left] -= attack[right];
        defense[right] -= attack[left];
        
        if(defense[left] <= 0) broken++;
        if(defense[right] <= 0) broken++;
        
        return broken;
    }
    
    static void recovery(int left, int right){
        defense[left] += attack[right];
        defense[right] += attack[left];
    }
}
