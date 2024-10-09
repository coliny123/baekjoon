import java.util.*;

class Team implements Comparable<Team>{
    int id, totalSum, totalCnt, lastSubmit;
    HashMap<Integer, Integer> problems;
    
    public Team(int id, int totalSum, int totalCnt, int lastSubmit, HashMap<Integer, Integer> problems){
        this.id=id;
        this.totalSum=totalSum;
        this.totalCnt=totalCnt;
        this.lastSubmit=lastSubmit;
        this.problems=problems;
    }
    
    
    @Override
    public int compareTo(Team o){
        if(totalSum == o.totalSum){
            if(totalCnt == o.totalCnt){
                return lastSubmit - o.lastSubmit;
            }else{
                return totalCnt - o.totalCnt;
            }
        }else{
            return o.totalSum - totalSum;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        while(T-- > 0){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int ID = sc.nextInt();
            int M = sc.nextInt();
            
            Team[] teams = new Team[N];
            for(int i=0; i<N; i++){
                HashMap<Integer, Integer> problems = new HashMap<>();
                teams[i] = new Team(i, 0, 0, 0, problems);
            }
            
            for(int time=0; time<M; time++){
                int I = sc.nextInt()-1; 
                int J = sc.nextInt(); 
                int S = sc.nextInt(); 
                
                Team curT = teams[I];
                if(curT.problems.getOrDefault(J, 0) < S){
                    curT.totalSum -= curT.problems.getOrDefault(J, 0);
                    curT.problems.put(J, S);
                    curT.totalSum += S;
                }
                curT.totalCnt++;
                curT.lastSubmit = time;
            }
            
            Arrays.sort(teams);
            
            int rank=0;
            int answer=0;
            for(int i=0; i<N; i++){
                // System.out.println("id : " + (teams[i].id+1) + " / sum : " + teams[i].totalSum + " / cnt : " + teams[i].totalCnt + " / last : " + teams[i].lastSubmit);
                rank++;
                if(teams[i].id == ID-1){
                    answer = rank;
                    break;
                }
            }
            
            System.out.println(answer);
        }
        
        
    }
}
