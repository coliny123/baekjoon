import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        
        int[] alpha = new int[26];
        Map<Character, Integer> rankMap = new HashMap<>();
        
        String[] words = new String[N];
        for(int i=0; i<N; i++){
            words[i] = br.readLine();
            for(int j=0; j<words[i].length(); j++){
                int jisu = words[i].length() - j;
                
                int prev = rankMap.getOrDefault(words[i].charAt(j), 0);
                int result = prev + (int)Math.pow(10, jisu);
                rankMap.put(words[i].charAt(j), result);
            }
        }
        
        int num = 9;
        List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(rankMap.entrySet());
        entryList.sort(((o1, o2) -> rankMap.get(o2.getKey()) - rankMap.get(o1.getKey())));
        for(Map.Entry<Character, Integer> entry : entryList){
            // System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
            alpha[entry.getKey() - 'A'] = num;
            num--;
        }
        
        int sum = 0;
        for(String str : words){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<str.length(); j++){
                sb.append(alpha[str.charAt(j) - 'A']);
            }
            // System.out.println(Integer.valueOf(sb.toString()));
            sum += Integer.valueOf(sb.toString());
        }
        
        System.out.println(sum);
    }
}
