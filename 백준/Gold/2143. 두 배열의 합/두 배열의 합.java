import java.util.*;
import java.io.*;

public class Main {
    static int N, M, T;
    static int[] nArr;
    static int[] mArr;
    static long[] nSumArr;
    static long[] mSumArr;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.valueOf(br.readLine());
        
        N = Integer.valueOf(br.readLine());
        nArr = new int[N];
        nSumArr = new long[N+1];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nArr[i] = Integer.valueOf(input[i]);
            nSumArr[i+1] = nSumArr[i] + nArr[i];
        }
        
        // System.out.println(Arrays.toString(nArr));
        // System.out.println(Arrays.toString(nSumArr));
        
        M = Integer.valueOf(br.readLine());
        mArr = new int[M];
        mSumArr = new long[M+1];
        input = br.readLine().split(" ");
        for(int i=0; i<M; i++){
            mArr[i] = Integer.valueOf(input[i]);
            mSumArr[i+1] = mSumArr[i] + mArr[i];
        }
        
        Map<Long, Long> nMap = new HashMap<>();
        for(int i=1; i<=N; i++){
            for(int j=0; j<i; j++){
                long key = nSumArr[i] - nSumArr[j];
                nMap.put(key, nMap.getOrDefault(key, 0L)+1);
            }
        }
        Map<Long, Long> mMap = new HashMap<>();
        for(int i=1; i<=M; i++){
            for(int j=0; j<i; j++){
                long key = mSumArr[i] - mSumArr[j];
                mMap.put(key, mMap.getOrDefault(key, 0L)+1);
            }
        }
                
        long cnt = 0;
        for(long a : nMap.keySet()){
            if(mMap.containsKey(T-a)){
                cnt += nMap.get(a) * mMap.get(T-a);
            }
        }
        System.out.println(cnt);
    }
}
