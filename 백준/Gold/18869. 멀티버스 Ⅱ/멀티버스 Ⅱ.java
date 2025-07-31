import java.util.*;
import java.io.*;

public class Main {
    static int M, N;
    static int[][] universe;
    static List<Integer>[] list;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        M = Integer.valueOf(input[0]);
        N = Integer.valueOf(input[1]);
        
        universe = new int[M][N];
        list = new ArrayList[M];
        
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            Set<Integer> set = new HashSet<>();
            
            for(int j=0; j<N; j++){
                universe[i][j] = Integer.valueOf(input[j]);
                set.add(universe[i][j]);
            }
            
            list[i] = new ArrayList<>(set);
            
            Collections.sort(list[i]);
        }
        
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                universe[i][j] = Collections.binarySearch(list[i], universe[i][j]);
            }
        }
        
		int count = 0;
		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				if (Arrays.equals(universe[i], universe[j]))
					count++;
			}
		}

        System.out.println(count);
    }
}
