import java.util.*;


class Gengre implements Comparable<Gengre>{
    int totalPlay;
    Set<Node> songs;
    
    public Gengre(int totalPlay, TreeSet<Node> songs){
        this.totalPlay=totalPlay;
        this.songs=songs;
    }
    
    @Override
    public int compareTo(Gengre x){
        return x.totalPlay - totalPlay;
    }
}

class Node implements Comparable<Node>{
    int idx, play;
    
    public Node(int idx, int play){
        this.idx=idx;
        this.play=play;
    }
    
    @Override
    public int compareTo(Node x){
        if(play == x.play){
            return idx - x.idx;
        }else{
            return x.play - play;
        }
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Gengre> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            Gengre target = map.getOrDefault(genre, new Gengre(0, new TreeSet<>()));
            target.totalPlay += play;
            target.songs.add(new Node(i, play));
            map.put(genre, target);
        }
        
        // Gengre 목록을 리스트로 변환하고 정렬
        List<Gengre> genreList = new ArrayList<>(map.values());
        Collections.sort(genreList);  // 총 재생 수 기준으로 정렬
        
        ArrayList<Integer> list = new ArrayList<>();
        for(Gengre cur : genreList) {
            int cnt = 0;
            for(Node song : cur.songs) {
                if(cnt == 2) break;  // 각 장르에서 최대 2곡 추가
                cnt++;
                list.add(song.idx);
            }
        }
        
        // 최종 결과 배열 변환
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}