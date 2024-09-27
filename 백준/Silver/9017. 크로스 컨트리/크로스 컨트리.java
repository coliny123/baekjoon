import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        while(T-- > 0){
            int N = sc.nextInt();
            
            ArrayList<Integer> teams[] = new ArrayList[201];
            for(int i=0; i<201; i++) teams[i] = new ArrayList<>();
            
            int counts[] = new int[201];
            int rank[] = new int[N];
            for(int i=0; i<N; i++){
                int record = sc.nextInt();
                counts[record]++;
                rank[i] = record;
            }
            HashSet<Integer> set = new HashSet<>();
            for(int i=1; i<=200; i++){
                if(counts[i] < 6) set.add(i);
            }
            
            int point=1;
            for(int team : rank){
                if(set.contains(team)) continue;

                teams[team].add(point);                
                point++;
            }
            
            int winner=-1;
            int lowPoint = Integer.MAX_VALUE;
            for(int i=1; i<=200; i++){
                if(set.contains(i)) continue;
                
                int sum=0;
                for(int k=0; k<4; k++){
                    sum += teams[i].get(k);
                }
                
                if(lowPoint > sum){
                    lowPoint = sum;
                    winner = i;
                }else if(lowPoint == sum){
                    winner = teams[winner].get(4) < teams[i].get(4) ? winner : i;
                }
            }
            
            System.out.println(winner);
            
        }
    }
}