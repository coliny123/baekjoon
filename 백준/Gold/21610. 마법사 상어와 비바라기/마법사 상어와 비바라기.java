import java.util.*;
import java.io.*;


public class Main {
    public static int N, M;
    public static int[][] field;
    public static Queue<int[]> clouds = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        field = new int[N][N];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                field[i][j] = Integer.valueOf(input[j]);
            }
        }
        
        // 비바라기 시전
        clouds.add(new int[]{N-1, 0});
        clouds.add(new int[]{N-1, 1});
        clouds.add(new int[]{N-2, 0});
        clouds.add(new int[]{N-2, 1});
        // waterCopyBug();
        // print();
        
        while(M-- > 0){
            input = br.readLine().split(" ");
            int dir = Integer.valueOf(input[0])-1;
            int s = Integer.valueOf(input[1]);
            move(dir, s);
            waterCopyBug();
            makeCloud();
        }
        // print();
        System.out.println(count());
    }
    
    public static void waterCopyBug(){
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};
        
        Queue<int[]> q = new LinkedList<>();
        while(!clouds.isEmpty()){
          int[] cur = clouds.poll();
          int cnt=0;
          for(int k=0; k<4; k++){
            int nx = cur[0] + dx[k];
            int ny = cur[1] + dy[k];
            if(inRange(nx, ny) && field[nx][ny] != 0){
              cnt++;
            }
          }
          field[cur[0]][cur[1]] += cnt;
          q.add(cur);
        }

        while(!q.isEmpty()){
          clouds.add(q.poll());
        }
    }
    
    public static void makeCloud(){
      Set<int[]> set = new TreeSet<>((o1, o2) -> {
        if(o1[0] == o2[0]){
            return o1[1] - o2[1]; 
        }else{
            return o1[0] - o2[0]; 
        }
    });
      while(!clouds.isEmpty()){
        set.add(clouds.poll());
      }

      for(int i=0; i<N; i++){
          for(int j=0; j<N; j++){
              if(set.contains(new int[]{i, j})) continue;
              if(field[i][j] < 2) continue;
                field[i][j] -= 2;

                clouds.add(new int[]{i, j});
          }
      }
    }
    
    public static void move(int dir, int s){
        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        
        // 이동
        while(!clouds.isEmpty()){
            int[] cur = clouds.poll();
            int nx = (cur[0] + s*(dx[dir] + N)) % N;
            int ny = (cur[1] + s*(dy[dir] + N)) % N;
            field[nx][ny] += 1;
            q.add(new int[]{nx, ny});
        }
        while(!q.isEmpty()){
          clouds.add(q.poll());
        }
    }
    
    public static boolean inRange(int x, int y){
        return (0<=x && x<N && 0<=y && y<N);
    }
    
    public static void print(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static long count(){
        long sum=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sum += field[i][j];
            }
        }
        return sum;
    }
}
