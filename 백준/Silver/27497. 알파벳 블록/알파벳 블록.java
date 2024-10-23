import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        Stack<Integer> st = new Stack<>();
        Deque<String> dq = new ArrayDeque<>();
        while(N-- > 0){
            String[] command = br.readLine().split(" ");
            int btn = Integer.valueOf(command[0]);
            if(btn == 1){
                String block = command[1];
                dq.addLast(block);
                st.push(1);
            }
            
            if(btn == 2){
                String block = command[1];
                dq.addFirst(block);
                st.push(-1);
            }
            
            if(btn == 3 && !st.empty()){
                int dir = st.pop();
                if(dir==1) dq.pollLast();
                else dq.pollFirst();
            }
        }
        
        StringBuilder answer = new StringBuilder();
        if(!dq.isEmpty()){
            for(String a:dq) answer.append(a);
        }else{
            answer.append(0);
        }
        System.out.print(answer);
        
    }
}