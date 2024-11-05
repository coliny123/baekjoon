import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int G = sc.nextInt();
        
        int lt = 1;
        int rt = 1;
        
        int cnt=0;
        while(2*rt - 1 <= G){
            int val = (rt + lt) * (rt - lt);
            if(val <= G){
                if(val == G){
                    cnt++;
                    System.out.println(rt);
                };
                rt++;
            }else{
                lt++;
            }
        }
        
        if(cnt == 0){
            System.out.println(-1);
        }
    }
}
