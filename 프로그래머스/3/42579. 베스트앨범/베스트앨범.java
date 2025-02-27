import java.util.*;

class Genre implements Comparable<Genre>{
    int totalPlay;
    Set<Song> songs;
    
    public Genre(int totalPlay, TreeSet<Song> songs){
        this.totalPlay = totalPlay;
        this.songs = songs;
    }
    
    @Override
    public int compareTo(Genre o){
        return o.totalPlay - totalPlay;
    }
}

class Song implements Comparable<Song>{
    int idx;
    int play;
    
    public Song(int idx, int play){
        this.idx=idx;
        this.play=play;
    }
    
    @Override
    public int compareTo(Song o){
        if(play == o.play){
            return idx - o.idx;
        }else{
            return o.play - play;
        }
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        
        HashMap<String, Genre> map = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            String name = genres[i];
            int play = plays[i];
            
            Genre target = map.getOrDefault(name, new Genre(0, new TreeSet<>()));
            target.totalPlay += play;
            target.songs.add(new Song(i, play));
            map.put(name, target);
        }
        
        List<Genre> genreList = new ArrayList<>(map.values());
        Collections.sort(genreList);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(Genre cur : genreList){
            int count = 0;
            for(Song song : cur.songs){
                if(count == 2) break;
                count++;
                list.add(song.idx);
            }
        }
        
        answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}