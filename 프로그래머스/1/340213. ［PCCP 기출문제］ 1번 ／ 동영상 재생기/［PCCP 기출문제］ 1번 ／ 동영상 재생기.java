import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int video_ed_m = Integer.valueOf(video_len.split(":")[0]);
        int video_ed_s = Integer.valueOf(video_len.split(":")[1]);
        int op_st_m = Integer.valueOf(op_start.split(":")[0]);
        int op_st_s = Integer.valueOf(op_start.split(":")[1]);
        int op_ed_m = Integer.valueOf(op_end.split(":")[0]);
        int op_ed_s = Integer.valueOf(op_end.split(":")[1]);
        
        int minute = Integer.valueOf(pos.split(":")[0]);
        int sec = Integer.valueOf(pos.split(":")[1]);

        for(String command : commands){
            if((op_st_m*60 + op_st_s <= minute*60 + sec) && (minute*60 + sec <= op_ed_m*60 + op_ed_s)){
                minute = op_ed_m;
                sec = op_ed_s;
            }
            
            if(command.equals("next")){
                sec += 10;
                if(sec >= 60){
                    minute += 1;
                    sec %= 60;
                }
                // next후 10초 미만인 경우
                // -인 경우 : 비디오 끝보다 현재가 더 클 때, 
                if((video_ed_m*60 + video_ed_s) - (minute*60 + sec) < 10){
                    minute = video_ed_m;
                    sec = video_ed_s;
                }
            }else{
                sec -= 10;
                if(sec < 0){
                    minute -= 1;
                    sec += 60;
                }
                // 10초 미만인데 prev한 경우 
                if(minute < 0){
                    minute = 0;
                    sec = 0;
                }
            }
            
        }
        
        if((op_st_m*60 + op_st_s <= minute*60 + sec) && (minute*60 + sec <= op_ed_m*60 + op_ed_s)){
            minute = op_ed_m;
            sec = op_ed_s;
        }
        
        String mStr = String.valueOf(minute);
        String sStr = String.valueOf(sec);
        if(mStr.length()==1){
            mStr = "0"+mStr;
        }
        if(sStr.length()==1){
            sStr = "0"+sStr;
        }
        answer = mStr + ":" + sStr;
        
        return answer;
    }
}