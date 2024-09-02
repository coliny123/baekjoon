import java.util.*;

public class Main {
    public static int gears[][] = new int[4][8];
    public static int directions[];
    
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<4; i++){
            String row = sc.nextLine();
            for(int j=0; j<8; j++){
                gears[i][j] = row.charAt(j) - '0';
            }
        }
        
        // print();
        
        int k = sc.nextInt();
        while(k-- > 0){
            int idx = sc.nextInt()-1;
            int dir = sc.nextInt();
            
            directions = new int[4];
            getDirections(idx, dir);
            simulation();
        }
        
        int sum=0;
        if(gears[0][0] == 1){
            sum += 1;
        }
        if(gears[1][0] == 1){
            sum += 2;
        }
        if(gears[2][0] == 1){
            sum += 4;
        }
        if(gears[3][0] == 1){
            sum += 8;
        }
        
        System.out.println(sum);
        
    }
    
    public static void simulation(){
        for(int i=0; i<4; i++){
            if(directions[i] == 0){
                continue;
            }
            
            // 반시계
            if(directions[i] == -1){
                int temp = gears[i][0];
                for(int j=0; j<7; j++){
                    gears[i][j] = gears[i][j+1];
                }
                gears[i][7] = temp;
            }else{  // 시계
                int temp = gears[i][7];
                for(int j=7; j>0; j--){
                    gears[i][j] = gears[i][j-1];
                }
                gears[i][0] = temp;
            }
        }
    }
    
    public static void getDirections(int idx, int dir){
        directions[idx] = dir;
        // 오른쪽
        for(int i=idx+1; i<4; i++){
            if(gears[i-1][2] == gears[i][6]){
                break;
            }else{
                directions[i] = -directions[i-1];
            }
        }
        
        // 왼쪽
        for(int i=idx-1; i>=0; i--){
            if(gears[i+1][6] == gears[i][2]){
                break;
            }else{
                directions[i] = -directions[i+1];
            }
        }
    }
    
    public static void print(){
        for(int i=0; i<4; i++){
            for(int j=0; j<8; j++){
                System.out.print(gears[i][j]);
            }
            System.out.println();
        }
    }
}
