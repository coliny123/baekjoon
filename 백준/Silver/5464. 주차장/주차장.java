import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 코드를 작성해주세요
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        PriorityQueue<Integer> parking = new PriorityQueue<>();
        
        int[] charges = new int[N];
        for(int i=0; i<N; i++){
            int charge = sc.nextInt();
            charges[i] = charge;
            parking.add(i);
        }
        
        int[] weight = new int[M+1];
        for(int i=1; i<=M; i++){
            weight[i] = sc.nextInt();
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> waitingQ = new LinkedList<>();
        
        
        long sum = 0;
        for(int i=0; i<2*M; i++){
            int t = sc.nextInt();
            if(t>0){
                waitingQ.add(t);
                if(!parking.isEmpty()){                    
                    int car = waitingQ.poll();
                    int space = parking.poll();
                    sum += charges[space] * weight[car];
                    map.put(t, space);
                }
            }
            else{
                t = Math.abs(t);
                int outSpace = map.get(t);
                parking.add(outSpace);
                map.remove(t);
                if(!waitingQ.isEmpty()){
                    int car = waitingQ.poll();
                    int space = parking.poll();
                    sum += charges[space] * weight[car];
                    map.put(car, space);
                }
            }
        }
        
        System.out.println(sum);
    }
}

// 3

// 1-3, 2-2, 

