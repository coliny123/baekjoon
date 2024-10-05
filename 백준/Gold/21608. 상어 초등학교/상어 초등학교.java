import java.util.*;

class Node implements Comparable<Node>{
    int x, y, blank, like;
    
    public Node(int x, int y, int blank, int like){
        this.x=x;
        this.y=y;
        this.blank=blank;
        this.like=like;
    }
    
    @Override
    public int compareTo(Node other){
        if(like == other.like){
            if(blank == other.blank){
                if(x == other.x){
                    return y - other.y;
                }else{
                    return x - other.x;
                }
            }else{
                return other.blank - blank;
            }
        }else{
            return other.like - like;
        }
    }
}

public class Main {
    public static int N;
    public static int[][] grid;
    public static Set<Integer>[] sets;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        grid = new int[N][N];
        grid = new int[N][N];
        sets = new HashSet[N*N+1];
        for(int i=1; i<=N*N; i++) sets[i] = new HashSet<>();
        
        for(int k=0; k<N*N; k++){
            int who = sc.nextInt();
            for(int i=0; i<4; i++) sets[who].add(sc.nextInt());
            Node result = findLocation(who);
            grid[result.x][result.y] = who;
        }
        
        // for(int i=0; i<N; i++){
            // for(int j=0; j<N; j++){
                // System.out.print(grid[i][j]+ " ");
            // }
            // System.out.println();
        // }
        
        System.out.println(getHappiness());

        
        
    }
    
    public static int getHappiness(){
        int sum=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int cnt = 0;
                for(int k=0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(0>nx || nx>=N || 0>ny || ny>=N) continue;
                    
                    if(sets[grid[i][j]].contains(grid[nx][ny])) cnt++;
                }
                
                switch(cnt){
                    case 0 :
                        sum +=0;
                        break;
                    case 1 :
                        sum+=1;
                        break;
                    case 2:
                        sum+=10;
                        break;
                    case 3 :
                        sum+=100;
                        break;
                    case 4 :
                        sum+=1000;
                        break;
                }
            }
        }
        
        return sum;
    }
    
    public static Node findLocation(int who){
        int x, y = 0;
        int maxBlank=0;
        int maxLike=0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int row=0; row<N; row++){
            for(int col=0; col<N; col++){
                if(grid[row][col] != 0) continue;
                
                int blank = 0;
                int like = 0;
                for(int i=0; i<4; i++){
                    int nx = row + dx[i];
                    int ny = col + dy[i];
                    if(0>nx || nx>=N || 0>ny || ny>=N) continue;
                    
                    if(grid[nx][ny] == 0) blank++;
                    else if(sets[who].contains(grid[nx][ny])) like++;
                }
                pq.add(new Node(row, col, blank, like));
            }
        }
        
        return pq.poll();
    }
}
