import java.util.*;
import java.io.*;

class Menu implements Comparable<Menu>{
    int spicy, sweet;
    
    public Menu(int spicy, int sweet){
        this.spicy=spicy;
        this.sweet=sweet;
    }
    
    @Override
    public int compareTo(Menu o){
        return spicy - o.spicy;
    }
}

public class Main {
    public static Menu[] menus;
    
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        int Q = Integer.valueOf(input[1]);
        
        menus = new Menu[N];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            menus [i] = new Menu(Integer.valueOf(input[0]), Integer.valueOf(input[1]));
        }
        
        Arrays.sort(menus);
        
        StringBuilder sb = new StringBuilder();
        while(Q-- > 0){
            input = br.readLine().split(" ");
            int u = Integer.valueOf(input[0]);
            int v = Integer.valueOf(input[1]);
            int x = Integer.valueOf(input[2]);
            int y = Integer.valueOf(input[3]);
            
            int spicyLowerIdx = upperBound(0, menus.length-1, u, menus);
            int cnt=0;
            for(int i=spicyLowerIdx; i<N; i++){
                if(menus[i].spicy > v) break;
                if(menus[i].sweet >= x && menus[i].sweet <= y) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    
    public static int upperBound(int lt, int rt, int target, Menu[] arr){
        int idx = rt-1;
        boolean find = false;
        while(lt <= rt){
            int mid = (lt + rt+1) / 2;
            
            if(arr[mid].spicy < target){
                lt = mid + 1;
            }else{
                rt = mid - 1;
                idx = mid;
            }
        }
        
        return idx;
    }
}
