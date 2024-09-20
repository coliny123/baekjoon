import java.util.*;
import java.io.*;

class Medal implements Comparable<Medal>{
    int idx, gold, silver, bronze, rank;
    public Medal(int idx, int gold, int silver, int bronze){
        this.idx=idx;
        this.gold=gold;
        this.silver=silver;
        this.bronze=bronze;
        this.rank=1;
    }
    
    @Override
    public int compareTo(Medal m) {
        // gold 내림차순
        if (this.gold != m.gold) {
            return m.gold - this.gold;
        }
        // gold가 같으면 silver 내림차순
        else if (this.silver != m.silver) {
            return m.silver - this.silver;
        }
        // silver가 같으면 bronze 내림차순
        else {
            return m.bronze - this.bronze;
        }
    }
}

public class Main {
    public static ArrayList<Medal> medals = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NK[] = br.readLine().split(" ");
        int n = Integer.parseInt(NK[0]);
        int k = Integer.parseInt(NK[1]);
        
        int cnt = n;
        while(cnt-->0){
            String input[] = br.readLine().split(" ");
            int num = Integer.valueOf(input[0]);
            int gold = Integer.valueOf(input[1]);
            int silver = Integer.valueOf(input[2]);
            int bronze = Integer.valueOf(input[3]);
            medals.add(new Medal(num, gold, silver, bronze));
        }
        
        Collections.sort(medals);
        for(int i=1; i<n; i++) {
            Medal originN = medals.get(i-1);
            Medal nextN = medals.get(i);

            if(originN.gold == nextN.gold &&originN.silver == nextN.silver &&originN.bronze == nextN.bronze) {
                nextN.rank = originN.rank;
            } else {
                nextN.rank = i + 1;
            }
        }
        
        Iterator<Medal> it = medals.iterator();
        while(it.hasNext()){
            Medal cur = it.next();
            // System.out.println(cur.rank);
            if(cur.idx == k){
                System.out.println(cur.rank);
                break;
            }
        }
        
    }
}
