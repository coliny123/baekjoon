import java.util.*;

class Node{
    int price, time;
    
    public Node(int price, int time){
        this.price=price;
        this.time=time;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Node> st = new Stack<>();
        
        for(int i=0; i<prices.length; i++){
           while (!st.empty() && prices[i] < st.peek().price){
                Node node = st.pop();
                answer[node.time] = i - node.time;
            }
            st.push(new Node(prices[i], i));
        }
        
        while(!st.empty()){
            Node node = st.pop();
            answer[node.time] = (prices.length-1) - node.time;
        }
        
        return answer;
    }
}