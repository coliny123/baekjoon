import java.util.*;


public class Main {
    public static int[] pageSize;
    public static Deque<Integer> back = new ArrayDeque<>();
    public static Deque<Integer> front = new ArrayDeque<>();
    public static int curPage=0;
    public static int Cache=0;
    public static int C;
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int Q = sc.nextInt();
        C = sc.nextInt();
        
        pageSize = new int[N+1];
        for(int i=1; i<=N; i++){
            pageSize[i] = sc.nextInt();
        }
        
        sc.nextLine();
        while(Q-- > 0){
            String[] command = sc.nextLine().split(" ");
            
            if(command[0].equals("A")){
                enter(Integer.valueOf(command[1]));
            }
            if(command[0].equals("C")){
                compress();
            }
            if(command[0].equals("B")){
                backForward();
            }
            if(command[0].equals("F")){
                frontForward();
            }
            
            // System.out.println(" cur : " + curPage + " Cache : " + Cache);
            // System.out.println("back");
            // for(int a : back){
                // System.out.print(a + " ");
            // }
            // System.out.println();
            // System.out.println("front");
            // for(int a : front){
                // System.out.print(a + " ");
            // }
            // System.out.println();
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(curPage).append("\n");
        if(!back.isEmpty()){
            while(!back.isEmpty()){
                sb.append(back.pollLast()).append(" ");
            }
        }else{
            sb.append(-1);
        }
        sb.append("\n");
        
        if(!front.isEmpty()){
            while(!front.isEmpty()){
                sb.append(front.pollLast()).append(" ");
            }
        }else{
            sb.append(-1);
        }
        
        System.out.println(sb);
        
    }
    
    public static void compress(){
        Deque<Integer> temp = new ArrayDeque<>();
        
        int cur = 0;
        while(!back.isEmpty()){
            int nx = back.pollFirst();
            if(cur != nx){
                temp.addLast(nx);
            }else{
                Cache -= pageSize[nx];
            }
            cur = nx;
        }
        
        back = temp;
    }
    
    
    public static void enter(int newPage){
        // 1번 과정
        while(!front.isEmpty()){
            Cache -= pageSize[front.pollLast()];
        }
        
        // 2번 과정
        if(curPage != 0) {
            back.addLast(curPage);
        }
        curPage = Integer.valueOf(newPage);
        Cache += pageSize[curPage];
        
        // 3번 과정
        while(!back.isEmpty() && Cache > C){
            int t = back.pollFirst();
            Cache -= pageSize[t];
        }
    }
    
    public static void frontForward(){
        if(!front.isEmpty()){
            back.addLast(curPage);
            curPage = front.pollLast();
        }
    }
    
    public static void backForward(){
        if(!back.isEmpty()){
            front.addLast(curPage);
            curPage = back.pollLast();
        }
    }
}
