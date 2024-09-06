import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        int x1, y1, r1, x2, y2, r2;
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            String row[] = br.readLine().split(" ");
            x1 = Integer.valueOf(row[0]);
            y1 = Integer.valueOf(row[1]);
            r1 = Integer.valueOf(row[2]);
            x2 = Integer.valueOf(row[3]);
            y2 = Integer.valueOf(row[4]);
            r2 = Integer.valueOf(row[5]);
            
            double dx = Math.pow(Math.abs(x1-x2),2);
            double dy = Math.pow(Math.abs(y1-y2),2);
            double len = Math.sqrt(dx + dy);
            
            
            if(x1==x2 && y1==y2){
                if(r1==r2){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else{
                if(len > (r1+r2) || len < Math.abs(r1-r2)){
                    sb.append(0).append("\n");
                }else if(len == (r1+r2) || len == Math.abs(r1-r2)){
                    sb.append(1).append("\n");
                }else{
                    sb.append(2).append("\n");
                }
            }
        }
        
        System.out.println(sb.toString());
    }
}
