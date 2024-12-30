import java.util.*;
import java.io.*;

class Node{
    int x, y;
    
    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    public static int N, M;
    public static int answer = Integer.MAX_VALUE;
    public static ArrayList<Node> houses = new ArrayList<>();
    public static ArrayList<Node> chickens = new ArrayList<>();
    public static Node[] arr;
    public static int[] distances;
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        N = Integer.valueOf(input[0]);
        M = Integer.valueOf(input[1]);
        
        arr = new Node[M];
        
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                int dot = Integer.valueOf(input[j]);
                // 1인 경우 집 arraylist에 저장
                if(dot == 1){
                    houses.add(new Node(i, j));
                }
                // 2인 경우 치킨집 arraylist에 저장
                if(dot == 2){
                    chickens.add(new Node(i, j));
                }
            }
        }
        
        // 백트래킹으로 치킨집 C M 개 조합에 대해서 계산
        BT(0,0);
        
        System.out.println(answer);
    }
    
    public static void BT(int count, int start){
        if(count == M){
            int min = calcDistance();
            answer = Math.min(answer, min);
            return;
        }
        
        
        for(int i=start; i<chickens.size(); i++){
            arr[count] = chickens.get(i);
            BT(count+1, i+1);
        }
    }
    
    public static int calcDistance(){
        int sum = 0;
        distances = new int[houses.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<houses.size(); j++){
                Node chicken = arr[i];
                Node house = houses.get(j);
                
                int dist = Math.abs(chicken.x - house.x) + Math.abs(chicken.y - house.y);
                if(distances[j] > dist){
                    distances[j] = dist;
                }
            }
        }
        
        for(int dist : distances){
            sum += dist;
        }
        
        return sum;
    }
}
