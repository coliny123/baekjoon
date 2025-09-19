import java.io.*;
import java.util.*;


public class Main {
  static int N;
  static int max = 0;
  static int[] T;
  static int[] P;



  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    N = Integer.valueOf(br.readLine());

    T = new int[N];
    P = new int[N];

    for(int i=0; i<N; i++){
      String[] input = br.readLine().split(" ");
      int t = Integer.valueOf(input[0]);
      int p = Integer.valueOf(input[1]);

      T[i] = t;
      P[i] = p;
    }


    dfs(0, 0);

    System.out.println(max);

  }


  static void dfs(int cur, int sum){
    if(cur >= N){
      max = Math.max(max, sum);
      return;
    }

    if(cur + T[cur] <= N){
      dfs(cur + T[cur], sum + P[cur]);
    }else{
      dfs(cur + T[cur], sum);
    }

    dfs(cur+1, sum);
  }
}