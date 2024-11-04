import java.util.*;

public class Main {
    public static int N, K;
    public static String[] words;
    public static boolean[] visited;
    public static int max = 0;
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        words = new String[N];
        visited = new boolean[26];
        if(K < 5){
            System.out.println(0);
            return;
        }else if(K == 26){
            System.out.println(N);
            return;
        }
        
        sc.nextLine();
        for(int i=0; i<N; i++){
            String input = sc.nextLine();
            input = input.replace("anta", "");
            input = input.replace("tica", "");
            words[i] = input;
        }
        
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        
        BT(0, 0);
        
        System.out.println(max);
    }
    
    
    public static void BT(int len, int st){
        if(len == K-5){
            int cnt=0;
            for(int i=0; i<words.length; i++){
                boolean flag = true;
                for(int j=0; j<words[i].length(); j++){
                    if(!visited[words[i].charAt(j) - 'a']){
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }
        
        
        for(int i=st; i<26; i++){
            if(!visited[i]){
                visited[i] = true;
                BT(len+1, i);
                visited[i] = false;
            }
        }
    }
}
