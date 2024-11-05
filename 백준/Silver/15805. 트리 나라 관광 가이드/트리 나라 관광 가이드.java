import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] parents = new int[N];
        Set<Integer> set = new HashSet<>();
        int prev = -1;
        for(int i=0; i<N; i++){
            int cur = sc.nextInt();
            if(!set.contains(cur)){
                parents[cur] = prev;
                set.add(cur);
            }
            prev = cur;
        }
        
        
        System.out.println(set.size());
        for(int i=0; i<set.size(); i++){
            System.out.print(parents[i]+ " ");
        }
    }
}
