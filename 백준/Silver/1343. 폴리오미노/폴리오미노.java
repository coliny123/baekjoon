import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        
        String[] poly = {"AAAA", "BB"};
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        int cnt=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != '.'){
                cnt++;
                if(cnt == 4){
                    sb.append(poly[0]);
                    cnt=0;
                }
            }else{
                if(cnt % 2 == 0){
                    if(cnt!=0) sb.append(poly[1]);
                }else{
                    System.out.println(-1);
                    return;
                }
                sb.append(".");
                cnt=0;
            }
        }
        
        if(cnt%2==0){
            if(cnt!=0) sb.append(poly[1]);
        }else{
            System.out.println(-1);
            return;
        }
        
        System.out.println(sb);
        
        
    }
}
