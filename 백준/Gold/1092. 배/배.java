import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.valueOf(br.readLine());
        Integer[] cranes = new Integer[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            cranes[i] = Integer.valueOf(input[i]);
        }
        
        
        int M = Integer.valueOf(br.readLine());
        ArrayList<Integer> boxes = new ArrayList<>();
        input = br.readLine().split(" ");
        for(int i=0; i<M; i++){
            boxes.add(Integer.valueOf(input[i]));
        }
        
        Arrays.sort(cranes, Collections.reverseOrder()); 
        Collections.sort(boxes, Collections.reverseOrder()); 
        
        if(cranes[0] < boxes.get(0)){
            System.out.println(-1);
            return;
        }
        
        int time = 0;
        while(!boxes.isEmpty()){
            time++;
            
            int boxIdx = 0;
            for(int i=0; i<N; i++){
                while(boxIdx < boxes.size()){
                    if(cranes[i] >= boxes.get(boxIdx)){
                        boxes.remove(boxIdx);
                        break;
                    }
                    boxIdx++;
                }
            }
            
        }
        
        System.out.println(time);
        
    }
}
